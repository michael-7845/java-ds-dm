package ds.stack;

import java.util.LinkedList;  

/**栈的定义*/  
public class Stack<T> {  
    /**定义栈的存储结构，LinkedList*/  
    private LinkedList<T> storage = new LinkedList<T>();  
      
    /**压栈操作*/  
    public void push(T t){storage.addFirst(t); }  
      
    /**获取栈顶元素*/  
    public T getTop() {return storage.getFirst(); }  
      
    /**出栈操作*/  
    public T pop() {return storage.removeFirst(); }  
      
    /**判断栈是否为空*/  
    public boolean isEmpty() {return storage.isEmpty(); }  
      
    /**打印栈中的元素*/  
    public String toString() {return storage.toString(); }   
      
}  
