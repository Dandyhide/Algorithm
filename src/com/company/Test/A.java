package com.company.Test;

public class A {
    public static void main(String[] args) throws InterruptedException {
        String str="123";
        Object object = new Object();
        B ab = new B(object);
        B b = new B(ab);
        Thread thread = new Thread(b);
        thread.start();
        Thread.sleep(1000*5);
        synchronized (ab){
            ab.object = "asdasdsa";
            System.out.println(ab);
            System.out.println(ab.object);
        }

    }
    static class B implements Runnable{
        private Object object;
        public B(Object object){
            this.object = object;
        }

        @Override
        public void run(){
            synchronized (object){
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(object);
                }
            }

        }
    }
}
