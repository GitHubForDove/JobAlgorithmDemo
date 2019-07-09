package Singleton;


// 静态内部类 实现单例模式
public class SingletonII {


    private SingletonII(){}

    private static class SingletonHolder{
        private static final SingletonII INSTANCE = new SingletonII();
    }

    public static SingletonII getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
