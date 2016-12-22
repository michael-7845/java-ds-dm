package ds.tree;

import java.util.List;

//树结构的常见操作
public interface ITree {
	public void create(List<CSNode> definition);
	public void clear();
	public boolean isEmpty();
	public int depth();
	public CSNode root();
	public int value();
	public void assign(CSNode n, int value);
	public CSNode parent(CSNode n);
	public CSNode leftChild(CSNode n);
	public CSNode rightSibling(CSNode n);
	public void insertChild(CSNode n, int i, ITree t);
	public void deleteChild(CSNode n, int i);
}
