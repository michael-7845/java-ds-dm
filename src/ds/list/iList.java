package ds.list;

public interface iList<T> {
	public Status init();
	public T getElem(int n);
	public Status insert(int n, T node);
	public Status delete(int n);
	public Status clear();
	public boolean isEmpty();
	public int length();
	public int locateElem(int value);
	public void show();
}
