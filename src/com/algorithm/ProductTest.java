package com.algorithm;

public class ProductTest {

    public static void main(String[] args)
    {
        Clerk clerk = new Clerk();
        Thread producerThread = new Thread(new Producer(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));

        producerThread.start();
        consumerThread.start();
    }
    static class Clerk {
        private static final int MAX_PRODUCT = 20;
        private static final int MIN_PRODUCT = 0;

        private int PRODUCT = 0;

        public synchronized void addProduct() {
            if (this.PRODUCT >= MAX_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品已满,请稍候再生产");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return;
            }
            this.PRODUCT++;
            System.out.println("生产者生产了第"+this.PRODUCT+"个产品");
            notifyAll();
        }

        public synchronized void getProduct() {
            if(this.PRODUCT <= MIN_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品处于缺货状态");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return;
            }
            System.out.println("消费者消费了第" + this.PRODUCT + "个产品");
            this.PRODUCT--;
            notifyAll();
        }
    }

    static class Producer implements Runnable{
        private Clerk clerk;
        public Producer(Clerk clerk)
        {
            this.clerk=clerk;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("生产者开始生产产品");
            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                clerk.addProduct();
            }

        }

    }

    static class Consumer implements Runnable{
        private Clerk clerk;
        public Consumer(Clerk clerk)
        {
            this.clerk=clerk;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("消费者开始消费产品");
            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                clerk.getProduct();
            }

        }

    }
}