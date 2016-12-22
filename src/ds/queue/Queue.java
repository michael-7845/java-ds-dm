package ds.queue;

import java.util.LinkedList;  

/**���еĶ���*/  
public class Queue<T> {  
  
    /**������еĴ洢�ṹ��LinkedList*/  
    private LinkedList<T> storage = new LinkedList<T>();  
      
    /**���Ӳ���*/  
    public void push(T t) {storage.addLast(t);}  
      
    /**��ȡ����Ԫ��*/  
    public T getHead() {return storage.getFirst();}  
      
    /**���Ӳ���*/  
    public T pop(){return storage.removeFirst();}  
      
    /**�ж϶����Ƿ�Ϊ��*/  
    public boolean isEmpty() {return storage.isEmpty();}  
      
    /**��ӡ����Ԫ��*/  
    public String toString(){return storage.toString();}  
}  