package Singleton;


// 双重检验模式
public class Singleton {


    private  volatile static Singleton instance;

    public Singleton() {

    }

    // 双重校验锁-线程安全
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
