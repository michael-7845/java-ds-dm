package dm.example;

import static kemin.tool.print.DebugTools.*;

public class SimpleFactoryMode {
	
	public static void demo() {
		OpFactory of = new OpFactory();
		for(Operator o: Operator.values()) {
			Op op = of.getOp(o);
			op.a = 6;
			op.b = 3;
			println(op.a + o.toString() + op.b + "=" + op.getResult());
		}
	}

	public static void main(String[] args) {
		demo();
	}

}

abstract class Op {
	public double a = 0;
	public double b = 0;
	
	Op() { }
	Op(double da, double db) {
		this.a = da;
		this.b = db;
	}
	
	public abstract double getResult();
}

class Add extends Op {
	public double getResult() {
		return a+b;
	}
}

class Sub extends Op {
	public double getResult() {
		return a-b;
	}
}

class Mul extends Op {
	public double getResult() {
		return a*b;
	}
}

class Div extends Op {
	public double getResult() {
		return a/b;
	}
}

enum Operator {
	Add("+"), Sub("-"), Mul("*"), Div("/");
	
    private String name;

    private Operator(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

class OpFactory {
	public Op getOp(Operator op) {
		Op result;
		switch(op) {
			default:
			case Add:
				result = new Add();
				break;
			case Sub:
				result = new Sub();
				break;
			case Mul:
				result = new Mul();
				break;
			case Div:
				result = new Div();
				break;
		}
		return result;
	}
}
