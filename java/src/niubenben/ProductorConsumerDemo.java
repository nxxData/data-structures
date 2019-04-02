package niubenben;

import java.util.LinkedList;

public class ProductorConsumerDemo {
    public static void main(String[] args) {
        Basket basket=new Basket();
        Productor productor=new Productor(basket);
        Consumer consumer=new Consumer(basket);
        productor.start();
        consumer.start();
    }
}
class Productor extends Thread{
    private Basket basket=null;

    public Productor(Basket basket) {
        super();
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.pushApple();
    }
}
class Consumer extends Thread{
    private Basket basket=null;

    public Consumer(Basket basket) {
        super();
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.popApple();
    }
}
class Basket{
    private LinkedList<Apple> basket=new LinkedList<Apple>();
    //放4轮苹果
    public synchronized void pushApple(){
        for (int i=0;i<20;i++){
            Apple apple=new Apple(i);
            push(apple);
        }
    }
    //取4轮苹果
    public synchronized void popApple(){
        for (int i=0;i<20;i++){
            pop();
        }
    }
    //向篮子放苹果
    private void push(Apple apple){
        //当篮子中放了5个苹果就等待并通知消费者来消费
        if (basket.size()==5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//等待并释放当前资源的锁
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.addFirst(apple);
        System.out.println("存放"+apple.toString()+"size:"+basket.size());
        notify();//通知消费者来消费
    }
    private void pop(){
        //当篮子中苹果数为0时，就等待并通知生产者来生产
        if (basket.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//等待并释放当前资源的锁
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Apple apple = basket.removeFirst();
        System.out.println("吃掉"+apple.toString()+"size:"+basket.size());
        notify();//通知生产者生产
    }
}
//苹果类
class Apple{
    private int id;
    public Apple(int id){
        this.id=id;
    }
    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}