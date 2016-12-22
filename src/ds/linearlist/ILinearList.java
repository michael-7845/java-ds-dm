package ds.linearlist;

public interface ILinearList<T> {
//	public void init();
	public boolean isEmpty();
	public void clean();
	public T getElem(int index);
	public int locateElem(T e);
	public void insert(int index, T e);
	public T delete(int index);
	public int length();
}
