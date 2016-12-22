package dm.example;

import static kemin.tool.print.DebugTools.*;

public class AbstractFactoryMode {
	
	public static void demo() {
		_IFactory serial1 = new ConcreteFactory1();
		IProductA pA1 = serial1.createProductA();
		pA1.set("apple");
		IProductB pB1 = serial1.createProductB();
		pB1.assign("ape");
		pA1.show();
		pB1.display();
		
		_IFactory serial2 = new ConcreteFactory2();
		IProductA pA2 = serial2.createProductA();
		pA2.set("banana");
		IProductB pB2 = serial2.createProductB();
		pB2.assign("bird");
		pA2.show();
		pB2.display();
	}

	public static void main(String[] args) {
		demo();
	}

}

interface _IFactory {
	IProductA createProductA();
	IProductB createProductB();
}
class ConcreteFactory1 implements _IFactory {
	@Override
	public IProductA createProductA() {
		IProductA p = new ConcreteProductA1();
		return p;
	}
	@Override
	public IProductB createProductB() {
		IProductB p = new ConcreteProductB1();
		return p;
	}
}
class ConcreteFactory2 implements _IFactory {
	@Override
	public IProductA createProductA() {
		IProductA p = new ConcreteProductA2();
		return p;
	}
	@Override
	public IProductB createProductB() {
		IProductB p = new ConcreteProductB2();
		return p;
	}
}

interface IProductA {
	public void set(String name);
	public void show();
}
class ConcreteProductA1 implements IProductA {
	String name;
	@Override
	public void set(String name) {
		this.name = name;
	}
	@Override
	public void show() {
		println("product a1: " + this.name);
	}
}
class ConcreteProductA2 implements IProductA {
	String name;
	@Override
	public void set(String name) {
		this.name = name;
	}
	@Override
	public void show() {
		println("product a2: " + this.name);
	}
}

interface IProductB {
	public void assign(String name);
	public void display();
}
class ConcreteProductB1 implements IProductB{
	String name;
	@Override
	public void assign(String name) {
		this.name = name;
	}
	@Override
	public void display() {
		println("product b1: " + this.name);
	}
}
class ConcreteProductB2 implements IProductB{
	String name;
	@Override
	public void assign(String name) {
		this.name = name;
	}
	@Override
	public void display() {
		println("product b2: " + this.name);
	}
}