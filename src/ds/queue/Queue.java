package ds.queue;

import java.util.LinkedList;  

/**队列的定义*/  
public class Queue<T> {  
  
    /**定义队列的存储结构，LinkedList*/  
    private LinkedList<T> storage = new LinkedList<T>();  
      
    /**进队操作*/  
    public void push(T t) {storage.addLast(t);}  
      
    /**获取队首元素*/  
    public T getHead() {return storage.getFirst();}  
      
    /**出队操作*/  
    public T pop(){return storage.removeFirst();}  
      
    /**判断队列是否为空*/  
    public boolean isEmpty() {return storage.isEmpty();}  
      
    /**打印队列元素*/  
    public String toString(){return storage.toString();}  
}  