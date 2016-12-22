package dm.example;

import static kemin.tool.print.DebugTools.*;

public class FacadeMode {
	public static void demo() {
		Facade f = new Facade();
		f.methodA();
		f.methodB();
	}
	
	public static void main(String[] args) {
		demo();
	}
}

class SubSystem1 {
	public void method1() {
		println("subsystem 1: method1()");
	}
}
class SubSystem2 {
	public void method2() {
		println("subsystem 2: method2()");
	}
}
class SubSystem3 {
	public void method3() {
		println("subsystem 3: method3()");
	}
}
class SubSystem4 {
	public void method4() {
		println("subsystem 4: method4()");
	}
}

class Facade {
	private SubSystem1 ss1;
	private SubSystem2 ss2;
	private SubSystem3 ss3;
	private SubSystem4 ss4;
	
	public Facade() {
		ss1 = new SubSystem1();
		ss2 = new SubSystem2();
		ss3 = new SubSystem3();
		ss4 = new SubSystem4();
	}
	
	public void methodA() {
		println("method A()");
		ss1.method1();
		ss2.method2();
		ss4.method4();
	}
	
	public void methodB() {
		println("method B()");
		ss2.method2();
		ss3.method3();
		ss4.method4();
	}
}