package dm.example;

import static kemin.tool.print.DebugTools.*;

public class TemplateMode {
	public static void demo() {
		AbstractClass c;
		c = new ConcreteClassA();
		c.templateMethod();
		
		c = new ConcreteClassB();
		c.templateMethod();
	}

	public static void main(String[] args) {
		demo();
	}

}

abstract class AbstractClass {
	public abstract void primitiveOperation1();
	public abstract void primitiveOperation2();
	
	public void templateMethod() {
		println("template method start");
		primitiveOperation1();
		primitiveOperation2();
		println("template method end");
	}
}

class ConcreteClassA extends AbstractClass {
	public void primitiveOperation1() {
		println("concrete class A: primitive operation 1");
	}
	
	public void primitiveOperation2() {
		println("concrete class A: primitive operation 2");
	}
}

class ConcreteClassB extends AbstractClass {
	public void primitiveOperation1() {
		println("concrete class B: primitive operation 1");
	}
	
	public void primitiveOperation2() {
		println("concrete class B: primitive operation 2");
	}
}
