package by.epam.course.application.port;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship {
    private static int idCounter;
    private final int id = ++idCounter;
    private int carrying;/*грузоподъемность
    (макс число контейнеров)*/
    private final AtomicInteger congestion = new AtomicInteger(0);/*текущее число
    контейнеров на борту*/

    public Ship(int carrying) {
        setCarrying(carrying);
    }

    public Ship(int carrying, int congestion) {
        setCarrying(carrying);
        setCongestion(congestion);
    }

    public int getId() {
        return id;
    }

    public int getCarrying() {
        return carrying;
    }

    public synchronized void setCarrying(int carrying) {
        if (carrying > 0) {
            this.carrying = carrying;
        }
    }

    public int getCongestion() {
        return congestion.get();
    }

    public synchronized void setCongestion(int congestion) {
        if (congestion > 0 && congestion <= carrying) {
            this.congestion.set(congestion);
        } else {
            this.congestion.set(carrying / 2);
        }
    }

    public synchronized void incCongestion() {
        if (congestion.get() < carrying) {
            congestion.incrementAndGet();
        }
    }

    public synchronized void decCongestion() {
        if (congestion.get() >= 1) {
            congestion.decrementAndGet();
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", carrying=" + carrying +
                ", congestion=" + congestion +
                "};";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Ship other = (Ship) obj;

        return congestion.get() == congestion.get();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + carrying;
        result = prime * result + congestion.get();
        return result;
    }
}
