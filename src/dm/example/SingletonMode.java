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
 * ����ķ��̰߳�ȫ����ģʽʵ����
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
 * �̰߳�ȫ�ĵ���ģʽʵ����
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
 * ��̬�ڲ���ʵ�ֵ��̰߳�ȫ�ĵ���ģʽ<br>
 * �����ڲ���̬��ֻ�ᱻ����һ�Σ������̰߳�ȫ��
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
 * ��̬������ʼ��ʵ���̰߳�ȫ�ĵ���ģʽ<br>
 * static���� instance �����౻����ʱ��ʼ����������ʼ��һ�Σ������Ϳ��Ա�ֻ֤��һ��instance����ʼ��
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
 * ��Ч���̰߳�ȫ�ĵ���ģʽʵ����
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

