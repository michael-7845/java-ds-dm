package ds.stack;

public interface IStack<T> {
	public void init();
	public void clear();
	public boolean isEmpty();
	public T getTop();
	public OpStatus push(T e) throws StackException;
	public T pop() throws StackException;
	public int length();
}
