package dm.example;

import static kemin.tool.print.DebugTools.*;

public class DecoratorMode {
	
	public static void demo() {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA d1 = new ConcreteDecoratorA();
		ConcreteDecoratorB d2 = new ConcreteDecoratorB();
		
		d1.setComponent(c);
		d2.setComponent(d1);
		d2.operation();
	}
	
	public static void demo2() {
		ConcreteComponent c = new ConcreteComponent();
		Decorator d = new ConcreteDecoratorB(new ConcreteDecoratorA(c));
		d.operation();
	}

	public static void main(String[] args) {
		demo2();
	}

}

interface Component {
	public void operation();
}

class ConcreteComponent implements Component {
	public void operation() {
		println("specific component: operation()");
	}
}

class Decorator implements Component {
	protected Component c;
	
	public Decorator() { }
	public Decorator(Component c) { this.c = c; }
	
	public void setComponent(Component c) {
		this.c = c;
	}
	
	public void operation() {
		if(this.c != null) {
			this.c.operation();
		}
	}
}

class ConcreteDecoratorA extends Decorator {
	private String state;
	
	public ConcreteDecoratorA() { }
	public ConcreteDecoratorA(Component c) {
		super(c);
	}
	
	@Override
	public void operation() {
		super.operation();
		this.state = "New";
		println("decorator A: operation()");
	}
}

class ConcreteDecoratorB extends Decorator {
	
	public ConcreteDecoratorB() { }
	public ConcreteDecoratorB(Component c) {
		super(c);
	}
	
	@Override
	public void operation() {
		super.operation();
		addedBehavior();
		println("decorator B: operation()");
	}
	
	public void addedBehavior() {
		println("decorator B: addedBehavior()");
	}
}