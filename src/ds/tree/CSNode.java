package ds.tree;

//孩子兄弟表示的结点定义
public class CSNode {
	public int data;
	public CSNode firstchild;
	public CSNode rightsib;
	
	public CSNode() {
		this.data = 0;
		this.firstchild = null;
		this.rightsib = null;
	}
	
	public CSNode(int data) {
		this.data = data;
		this.firstchild = null;
		this.rightsib = null;
	}
}
