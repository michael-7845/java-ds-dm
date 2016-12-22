package dm.example;

import java.util.ArrayList;
import java.util.List;

public class CompositeMode {
	public static void demo() {
		IComponent root = new Composite("root");
		IComponent A = new Leaf("A");
		IComponent B = new Leaf("B");
		IComponent X = new Composite("X");
		IComponent XA = new Leaf("XA");
		IComponent XB = new Leaf("XB");
		IComponent XY = new Composite("XY");
		IComponent XYA = new Leaf("XYA");
		IComponent XYB = new Leaf("XYB");
		IComponent C = new Leaf("C");
		IComponent D = new Leaf("D");
		
		root.add(A);
		root.add(B);
		root.add(X);
		root.add(C);
		root.add(D);
		
		X.add(XA);
		X.add(XB);
		X.add(XY);
		
		XY.add(XYA);
		XY.add(XYB);
		
		root.remove(D);
		
		root.display(1);
	}
	
	public static void main(String[] args) {
		demo();
	}

}

interface IComponent {
	public abstract void add(IComponent c);
	public abstract void remove(IComponent c);
	public abstract void display(int depth);
}

abstract class _Component implements IComponent {
	protected String name;
	public String getName() {
		return name;
	}
	public _Component(String name) {
		this.name = name;
	}
	@Override public boolean equals(Object o) {
		if(this.name.equalsIgnoreCase(((_Component)o).getName())) {
			return true;
		}
		return false;
	}
}

class Leaf extends _Component {
	public Leaf(String name) {
		super(name);
	}
	public void add(IComponent c) {
		System.out.println("leaf cannot add a child component");
	}
	public void remove(IComponent c) {
		System.out.println("leaf has no child component");
	}
	public void display(int depth) {
		for(int i=0; i<depth; i++) {
			System.out.print("-");
		}
		System.out.println("leaf:" + this.name);
	}
}

class Composite extends _Component {
	public Composite(String name) {
		super(name);
	}
	private List<IComponent> children = new ArrayList<IComponent>();
	public void add(IComponent c) {
		children.add(c);
	}
	public void remove(IComponent c) {
		children.remove(c);
	}
	public void display(int depth) {
		for(int i=0; i<depth; i++) {
			System.out.print("-");
		}
		System.out.println("composite:" + this.name);
		for(IComponent c: children) {
			c.display(depth + 2);
		}
	}
}