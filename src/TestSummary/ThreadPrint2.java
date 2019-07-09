package TestSummary;

class Print{

    private int flag = 1;
    private int count = 0;

    public int getCount() {
        return count;
    }

    // 线程1
    public synchronized void A(){
        while(flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 2;
        notifyAll();
    }

    // 线程2打印
    public synchronized void B(){

        while(flag !=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 3;
        notifyAll();
    }

    public synchronized void C(){
        while(flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 1;
        notifyAll();
    }
}

// 创建一个线程体
class MyThread implements Runnable{
    private Print print;

    public MyThread(Print print) {
        this.print = print;
    }

    @Override
    public void run() { // 重写run()方法
        while(print.getCount() <28){ // 刚刚好 分别打印五个
            if(Thread.currentThread().getName().equals("A")){
                print.A();
            }else if(Thread.currentThread().getName().equals("B")){
                print.B();
            }else if(Thread.currentThread().getName().equals("C")){
                print.C();
            }
        }
    }
}

public class ThreadPrint2{
    public static void main(String[] args) {
        Print print = new Print();
        MyThread mt = new MyThread(print);
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        Thread thread3 = new Thread(mt,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
