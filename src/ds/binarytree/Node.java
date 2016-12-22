package ds.binarytree;

/**二叉树的结点定义*/
class Node<T>{
	private T value;
	private Node<T> left;
	private Node<T> right;
	
	public Node(){
		
	}
	
	public Node(Node<T> left, Node<T> right, T value){
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public Node(T value){
		this(null, null, value);
    }
	
	public Node<T> getLeft(){
		return this.left;
    }
	
	public void setLeft(Node<T> left){
		this.left = left;
    }
	
    public Node<T> getRight(){
    	return this.right;
    }
    
    public void setRight(Node<T> right){
    	this.right = right;
    }
    
    public T getValue(){
    	return this.value;
    }
    
    public void setValue(T value){
    	this.value = value;
    }
}