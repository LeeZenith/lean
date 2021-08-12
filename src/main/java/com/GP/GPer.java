package com.GP;

import java.util.Observable;
import java.util.Observer;

public class GPer extends Observable {
    private String name="GPer";
    private static GPer gPer=null;
    private GPer(){}
    public static GPer getInstance(){
        if (gPer==null){
            gPer=new GPer();
        }
        return gPer;
    }
    public  String getName(){
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+this.name);
        setChanged();
        notifyObservers(question);
    }
    
}
class Question{
    private String userName;
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Teacher implements Observer{
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        GPer gPer=(GPer) observable;
        Question question=(Question) o;
        System.out.println("=====================");
        System.out.println(name+gPer.getName()+question.getContent()+question.getUserName());
    }
}
class Main{
    public static void main(String[] args) {
/*        GPer gPer=GPer.getInstance();
        Teacher tom=new Teacher("tom");
        Teacher timi = new Teacher("Timi");
        gPer.addObserver(tom);
        gPer.addObserver(timi);

        final Question question = new Question();
        question.setUserName("AA");
        question.setContent("*******************");

        gPer.publishQuestion(question);*/
        System.out.println("www.runoob.com+/+w3cnote/java-annotation.html".replaceAll("/+", "/"));
    }
}