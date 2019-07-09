package TestSummary;

public class ThreadPrint {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();

    }
}

class print{

    public static int flag = 1;
    public static Object obj = new Object();

    public void printToA() throws InterruptedException {

        for (int i=0;i<=10;i++) {
            synchronized (obj) {
                while (flag != 1) {
                    obj.wait();
                }

                System.out.println("A");
                flag = 2;
                obj.notifyAll();
            }

        }
    }

    public void printToB() throws InterruptedException {

        for (int i=0;i<=10;i++) {
            synchronized (obj) {
                while (flag != 2) {
                    obj.wait();
                }

                System.out.println("B");
                flag = 3;
                obj.notifyAll();
            }

        }
    }

    public void printToC() throws InterruptedException {

        for (int i=0;i<=10;i++) {
            synchronized (obj) {
                while (flag != 3) {
                    obj.wait();
                }

                System.out.println("C");
                flag = 1;
                obj.notifyAll();
            }

        }
    }
}

class ThreadA implements Runnable{

    @Override
    public void run() {
        try {
            new print().printToA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB implements Runnable{

    @Override
    public void run() {
        try {
            new print().printToB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadC implements Runnable{

    @Override
    public void run() {
        try {
            new print().printToC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}