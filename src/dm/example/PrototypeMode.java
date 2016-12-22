package dm.example;

import static kemin.tool.print.DebugTools.*;

public class PrototypeMode {
	public static void demo() {
		ConcretePrototype1 p1 = new ConcretePrototype1("1");
		ConcretePrototype1 c1 = (ConcretePrototype1)p1.clone();
		
		print("p1: " + p1.getId());
		print("c1: " + c1.getId());
	}
	
	public static void main(String[] args) {
		demo();
	}
}

abstract class Prototype {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Prototype(String id) {
		super();
		this.id = id;
	}
	
	abstract public Prototype clone();
}

class ConcretePrototype1 extends Prototype {
	public ConcretePrototype1(String id) {
		super(id);
	}
	
	public Prototype clone() {
		return (Prototype)new ConcretePrototype1(getId());
	}
}