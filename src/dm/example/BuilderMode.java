package dm.example;

import static kemin.tool.print.DebugTools.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuilderMode {

	public static void demo() {
		Director d = new Director();
		Builder1 b1 = new Builder1();
		Builder2 b2 = new Builder2();
		
		d.construct(b1);
		Product p = b1.getResult();
		p.show();
		
		d.construct(b2);
		p = b2.getResult();
		p.show();
	}
	
	public static void main(String[] args) {
		demo();
	}

}

class Product {
	List<String> parts = new ArrayList<String>();
	
	void addPart(String s) {
		parts.add(s);
	}
	
	void show() {
		Iterator<String> i = parts.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

class Director {
	void construct(Builder b) {
		b.buildPartB();
		b.buildPartA();
	}
}

interface Builder {
	void buildPartA();
	void buildPartB();
	Product getResult();
}

class Builder1 implements Builder {
	private Product product = new Product();
	
	public void buildPartA() {
		this.product.addPart("Part A");
	}
	public void buildPartB() {
		this.product.addPart("Part B");
	}
	public Product getResult() {
		return this.product;
	}
}

class Builder2 implements Builder {
	private Product product = new Product();
	
	public void buildPartA() {
		product.addPart("Part X");
	}
	public void buildPartB() {
		product.addPart("Part Y");
	}
	public Product getResult() {
		return product;
	}
}