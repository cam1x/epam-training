package by.epam.course.application.notebook;

import java.util.Calendar;
import java.util.regex.*;


/*
    Класс для представления заметки
    Возможности:
    1) Изменение темы, почты, сообщения
    2) Получение времени создания, темы, почты, сообщения
    3) Вывод на консоль
    P.S. Время создания добавляется автоматически.
         Корректность переданного эл адреса
         проверяется с помощью регулярных выражений.
 */

public class Note {

    private String topic="No topic";
    private String email="admin@gmail.com";
    private String message="No message";
    private Calendar dateOfCreating=Calendar.getInstance();
    private boolean isEdited;/*при измении сообщения после его создания
    появляется пометка edited*/

    public Note(String topic,String email,String message){
        setTopic(topic);
        setEmail(email);
        setMessage(message);
        isEdited=false;
    }

    public void setTopic(String topic){
        if(topic!=null && !topic.isEmpty()){
            this.topic=topic.trim();
            isEdited=true;
        }
    }

    public void setEmail(String email){
        if(email!=null && !email.isEmpty()) {
            Pattern emailPat = Pattern.compile("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})");
            Matcher emailMatcher = emailPat.matcher(email);
            if (emailMatcher.find()) {
                this.email = email.trim();
                isEdited=true;
            }
        }
    }

    public void setMessage(String message){
        if(message!=null && !message.isEmpty()){
            this.message=message.trim();
            isEdited=true;
        }
    }

    public void editTopic(String topic){
        if(topic!=null && !topic.isEmpty()){
            this.topic+=topic;
        }
    }

    public void editMessage(String message){
        if(message!=null && !message.isEmpty()){
            this.message+=message;
        }
    }

    public String getTopic(){
        return topic;
    }

    public String getEmail(){
        return email;
    }

    public String getMessage(){
        return message;
    }

    public String getDate(){
        return dateOfCreating.getTime().toString();
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        String string=new String();
        string+="\t"+getDate()+((isEdited)?" edited\n":"\n");
        string+="Topic: "+topic+"\n";
        string+="Email: "+email+"\n";
        string+="Message: "+message+"\n";
        return string;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Note other=(Note) obj;

        return topic.equals(other.topic) && email.equals(other.email) && message.equals(other.message);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((topic==null)?0:topic.hashCode());
        result=prime*result+((email==null)?0:email.hashCode());
        result=prime*result+((message==null)?0:message.hashCode());

        return result;
    }
}
