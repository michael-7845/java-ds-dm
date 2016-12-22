package ds.stack;

import java.util.LinkedList;  

/**ջ�Ķ���*/  
public class Stack<T> {  
    /**����ջ�Ĵ洢�ṹ��LinkedList*/  
    private LinkedList<T> storage = new LinkedList<T>();  
      
    /**ѹջ����*/  
    public void push(T t){storage.addFirst(t); }  
      
    /**��ȡջ��Ԫ��*/  
    public T getTop() {return storage.getFirst(); }  
      
    /**��ջ����*/  
    public T pop() {return storage.removeFirst(); }  
      
    /**�ж�ջ�Ƿ�Ϊ��*/  
    public boolean isEmpty() {return storage.isEmpty(); }  
      
    /**��ӡջ�е�Ԫ��*/  
    public String toString() {return storage.toString(); }   
      
}  
