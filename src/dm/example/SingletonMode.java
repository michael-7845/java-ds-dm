package dm.example;

import static kemin.tool.print.DebugTools.*;

public class SingletonMode {
	public static void demo() {
		Singleton s = Singleton.getInstance();
		println(s.i);
		s.i = 2;
		println(s.i);
		println(s.hashCode());
		
		Singleton s2 = Singleton.getInstance();
		println(s2.i);
		println(s2.hashCode());
		
		if(s == s2) {
			println("s == s2");
		}
	}
	
	public static void demo_thread_safe() {
		class MyThread implements Runnable {
			String name;
			public MyThread(String name) {
				this.name = name;
			}
			public void run() {
				for(int i=0; i<10; i++) {
					double d = Math.random();
					long t = Math.round(d*1000);
					Singleton s = Singleton.getInstance();	
					s.i++;
					println(this.name + ": " + d + "; hashCode: " + s.hashCode() + "; i: " + s.i);
				}
			}
		}
		
		Thread[] tarray = new Thread[5];
		for(int i=0; i<5; i++) {
			tarray[i] = new Thread(new MyThread(String.valueOf(i)));
			tarray[i].start();
			try {
				tarray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		demo();
		demo_thread_safe();
	}
}

/**
 * 经典的非线程安全单例模式实现类
 */
class Singleton {
	private static Singleton instance;
	public int i;
	private Singleton() { }
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

/**
 * 线程安全的单例模式实现类
 */
class Singleton2 {
    private static Singleton2 instance;
    public int i;
    private Singleton2(){}
    
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 静态内部类实现的线程安全的单例模式<br>
 * 由于内部静态类只会被加载一次，故是线程安全的
 */
class Singleton3 {
    private Singleton3(){}
    public int i;
    private static class SingleHolder{
        static Singleton3 instance = new Singleton3();
    }
    
    public static Singleton3 getInstance(){
        return SingleHolder.instance;
    }
}

/**
 * 静态变量初始化实现线程安全的单例模式<br>
 * static变量 instance 是在类被加载时初始化并仅被初始化一次，这样就可以保证只有一个instance被初始化
 */
class Singleton4 {
    private static Singleton4 instance = new Singleton4();
    public int i;
    private Singleton4(){}
    
    public static Singleton4 getInstance(){
        return instance;
    }
}

/**
 * 高效的线程安全的单例模式实现类
 */
class Singleton5 {
    private static volatile Singleton5 instance;
    public int i;
    private Singleton5(){}
    
    public static Singleton5 getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

