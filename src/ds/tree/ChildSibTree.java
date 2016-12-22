package ds.tree;

import java.util.ArrayList;
import java.util.List;

//树的孩子兄弟表示
public class ChildSibTree implements ITree {
	
	public CSNode root;
	public List<CSNode> tree;

	@Override
	public void create(List<CSNode> definition) {
		this.root = definition.get(0);
		this.tree = new ArrayList<CSNode>(definition);
	}

	@Override
	public void clear() {
		this.root = null;
		this.tree = null;
	}

	@Override
	public boolean isEmpty() {
		if(this.root == null) {
			return true;
		}
		return false;
	}

	@Override
	public int depth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CSNode root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void assign(CSNode n, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public CSNode parent(CSNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSNode leftChild(CSNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CSNode rightSibling(CSNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertChild(CSNode n, int i, ITree t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteChild(CSNode n, int i) {
		// TODO Auto-generated method stub

	}

}
