package dm.example;

import java.util.ArrayList;
import java.util.List;

public class VisitorMode {
	public static void demo() {
		ObjectStructure o = new ObjectStructure();
		o.attach(new ConcreteElementA());
		o.attach(new ConcreteElementB());
		
		ConcreteVisitor1 v1 = new ConcreteVisitor1();
		ConcreteVisitor2 v2 = new ConcreteVisitor2();
		
		o.accept(v1);
		o.accept(v2);
	}
	
	public static void main(String[] args) {
		demo();
	}
}

abstract class Visitor {
	public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
	public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}

class ConcreteVisitor1 extends Visitor {
	public void visitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName() + " is visited by " + this.getClass().getName());
	}
	public void visitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName() + " is visited by " + this.getClass().getName());
	}
}

class ConcreteVisitor2 extends Visitor {
	public void visitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName() + " is visited by " + this.getClass().getName());
	}
	public void visitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName() + " is visited by " + this.getClass().getName());
	}
}

abstract class Element {
	public abstract void accept(Visitor visitor);
}

class ConcreteElementA extends Element {
	public void accept(Visitor visitor) {
		visitor.visitConcreteElementA(this);
	}
}

class ConcreteElementB extends Element {
	public void accept(Visitor visitor) {
		visitor.visitConcreteElementB(this);
	}
}

class ObjectStructure {
	private List<Element> elements = new ArrayList<Element>();
	public void attach(Element e) {
		elements.add(e);
	}
	public void detach(Element e) {
		elements.remove(e);
	}
	public void accept(Visitor visitor) {
		for(Element e: elements) {
			e.accept(visitor);
		}
	}
}
