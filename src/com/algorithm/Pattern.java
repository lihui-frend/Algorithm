package com.algorithm;


public class Pattern {
}
//饿汉
class SingletonDemo1{
    private static SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1(){}
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}

//懒汉
class SingletonDemo2{
    private static SingletonDemo2 instance;
    private SingletonDemo2(){}
    public static SingletonDemo2 getInstance(){
        if(instance==null){
            instance = new SingletonDemo2();
        }
        return instance;
    }
}

//线程安全懒汉
class SingletonDemo3{
    private static SingletonDemo3 instance;
    private SingletonDemo3(){}

    public static synchronized SingletonDemo3 getInstance(){
        if (instance==null){
            instance = new SingletonDemo3();
        }
        return instance;
    }
}

//枚举
enum SingletonDemo4{
    instance;
    public void method(){

    }
}

//静态内部类
class SingletonDemo5{
    private static class Single{
        private static final SingletonDemo5 instance = new SingletonDemo5();
    }
    private SingletonDemo5(){}
    public static final SingletonDemo5 getinstance(){
        return Single.instance;
    }
}

//双重校验锁
class SingletonDemo6{
    private volatile static SingletonDemo6 instance;
    private SingletonDemo6(){}
    public static SingletonDemo6 getInstance(){
        if(instance==null){
            synchronized (SingletonDemo6.class){
                if (instance==null){
                    instance = new SingletonDemo6();
                }
            }
        }
        return instance;
    }
}