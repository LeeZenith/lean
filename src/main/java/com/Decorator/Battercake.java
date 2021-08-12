package com.Decorator;

public abstract class Battercake {
    protected abstract String getMsg();
    public abstract int getPrice();
}
class BaseBattercake extends Battercake{

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
abstract class BatterckeDecorator extends Battercake{
    private Battercake battercake;
    public BatterckeDecorator(Battercake battercake){
        this.battercake=battercake;
    }
    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    public int getPrice() {
        return this.battercake.getPrice();
    }
}

class EggDecorator extends BatterckeDecorator{
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {}

    @Override
    protected String getMsg() {
        return super.getMsg()+"+一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+1;
    }
}

class SausageDecotator extends BatterckeDecorator {
    public SausageDecotator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+一根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+2;
    }
}

class Main{
    public static void main(String[] args) {
        Battercake battercake;

        battercake=new BaseBattercake();

        battercake=new EggDecorator(new EggDecorator(new EggDecorator(battercake)));

        System.out.println(battercake.getMsg());
        System.out.println(battercake.getPrice());
    }
}