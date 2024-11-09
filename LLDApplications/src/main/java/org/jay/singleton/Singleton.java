package org.jay.singleton;

public class Singleton {
    private static Singleton object;
    private Singleton(){
    }
    public static  Singleton getSingletonObject(){
        if(object == null) {
            synchronized (Singleton.class) {
                if(object == null) {
                    object = new Singleton();
                }
            }
        }
        return object;
    }

    public void showMessage(){
        System.out.println("Hello from singleton");
    }

}
