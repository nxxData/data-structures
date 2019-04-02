package niubenben;

import javax.naming.Name;
import java.util.concurrent.ForkJoinPool;

public class HelloThreadDemo {
    public static void main(String[] args) {
        // write your code here
        Bank bank=new Bank();
        BankThread p1=new BankThread(bank);
        p1.start();//柜台取钱
        BankThread p2=new BankThread(bank);
        p2.start();//ATM上取钱
    }
}
class BankThread extends Thread{
    private Bank bank=null;
    public BankThread(Bank bank){
        this.bank=bank;
    }
    @Override
    public void run(){
        System.out.println("取钱："+bank.getMoney(400));
    }
}
class Bank{

    private int money=500;
    //取钱的方法，返回取钱的数目
    //当一个线程去调用同步方法的时候，这个线程就获取了当前对象的锁
    //其他线程当调用同步方法的时候只能等待，因为无法获取对象的锁
    //只有等前一个线程释放对象的锁方可进入
    public synchronized int getMoney(int number){
        synchronized (this) {
            if (number<0){
                return -1;
            }else if (money<0){
                return -2;
            }else if (number-money>0){
                return -3;
            }else{
                try {
                    Thread.sleep(1000);//模拟取钱的时间
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                money-=number;
                System.out.println("余额"+money);
            }
        }

        return number;
    }
}
