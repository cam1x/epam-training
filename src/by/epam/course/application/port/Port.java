package by.epam.course.application.port;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Port {

    private List<Berth> berths = Collections.synchronizedList(new ArrayList<>());
    private int maxNumOfContainers;/*максимальное число
    контейнеров в порту*/
    private volatile AtomicInteger numOfContainers=new AtomicInteger();/*текущее число
    контейнеров в порту*/

    public Port(int maxNumOfContainers){
        setMaxNumOfContainers(maxNumOfContainers);
    }

    public Port(int maxNumOfContainers,int numOfContainers){
        setMaxNumOfContainers(maxNumOfContainers);
        setNumOfContainers(numOfContainers);
    }

    public synchronized void setMaxNumOfContainers(int maxNumOfContainers){
        if(maxNumOfContainers>0){
            this.maxNumOfContainers=maxNumOfContainers;
        }
    }

    public synchronized void setNumOfContainers(int numOfContainers){
        if(numOfContainers>0 && numOfContainers<=maxNumOfContainers){
            this.numOfContainers.set(numOfContainers);
        }else{
            this.numOfContainers.set(maxNumOfContainers/2);
        }
    }

    public int getMaxNumOfContainers(){
        return maxNumOfContainers;
    }

    public int getNumOfContainers(){
        return numOfContainers.get();
    }

    /*
        Добавление корабля в порт.
        Если все причалы заняты, то добавляется новый причал.
        Если есть свободный причал, то к нему будет направлен новый корабль
     */
    public void addShip(Ship ship){
        if(ship!=null){
            for(int i=0;i<berths.size();i++){
                Berth berth=berths.get(i);
                if (!berth.isWorking) {
                    berth.setShip(ship);
                    berth.process();
                    return;
                }
            }

            berths.add(new Berth(ship));
            berths.get(berths.size()-1).process();
        }
    }

    /*
        Класс для представления причала.
        У каждого причала может распалагаться только один корабль,
        который может быть разгружен (если число контейнеров >=
        60 % макс загрузки) и загружен (<60%)
        После окончания работы с текущим кораблем, порт принимает состояние
        isWorking=false и может обработать другой корабль
     */
    class Berth{

        class Loading extends Thread{

            @Override
            public void run() { {
                System.out.println("Loading.....");

                AtomicInteger loaded = new AtomicInteger(0);
                while (ship.getCongestion() < ship.getCarrying()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(numOfContainers.decrementAndGet()>=0) {
                        loaded.incrementAndGet();
                        ship.incCongestion();
                    }else{
                        numOfContainers.incrementAndGet();
                        break;
                    }
                }

                if (ship.getCongestion() == ship.getCarrying()) {
                    System.out.println("\nShip (id = " + ship.getId() + ") fully loaded. Totally loaded: " + loaded.get() + " containers.");
                } else {
                    System.out.println("\nNot enough containers in port to load ship (id = " + ship.getId() + "). Loaded only: " + loaded.get() + " containers.");
                }

                isWorking=false;
                }
            }
        }

        class Unloading extends Thread{

            @Override
            public void run() {
                System.out.println("Unloading....");

                AtomicInteger unloaded = new AtomicInteger(0);
                while (ship.getCongestion() != 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(numOfContainers.incrementAndGet()<=maxNumOfContainers) {
                        unloaded.incrementAndGet();
                        ship.decCongestion();
                    } else{
                        numOfContainers.decrementAndGet();
                        break;
                    }
                }

                if (ship.getCongestion() == 0) {
                    System.out.println("\nShip (id = " + ship.getId() + ") fully unloaded. Totally unloaded: " + unloaded.get() + " containers.");
                } else {
                    System.out.println("\nNot enough space in port to unload all containers from ship (id = " + ship.getId() + "). Unloaded only " + unloaded.get() + " containers.");
                }

                isWorking=false;
            }
        }

        private Ship ship;
        private boolean isWorking;

        public Berth(Ship ship){
            this.ship=ship;
            isWorking=true;
        }

        public void setShip(Ship ship){
            if(!isWorking){
                this.ship=ship;
                isWorking=true;
            }
        }

        public void process(){
            if( ((ship.getCongestion()*100.0)/ship.getCarrying()) >= 60 ){
               new Unloading().start();
            }else{
                new Loading().start();
            }
        }
    }
}
