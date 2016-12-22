package dm.example;

import static kemin.tool.print.DebugTools.*;

public class FactoryMethod {
	public static void demo() {
		IFactory[] ofarray = {new AddFactory(), new SubFactory(), new MulFactory(), new DivFactory()};
		for(IFactory of: ofarray) {
			Operation oper = of.createOperation();
			oper.a = 1.0;
			oper.b = 2.0;
			println("result: " + oper.getResult());
		}
	}
	
	public static void main(String[] args) {
		demo();
	}
}

interface IFactory {
	Operation createOperation();
}

class AddFactory implements IFactory {
	public Operation createOperation() {
		return new OperationAdd();
	}
}

class SubFactory implements IFactory {
	public Operation createOperation() {
		return new OperationSub();
	}
}

class MulFactory implements IFactory {
	public Operation createOperation() {
		return new OperationMul();
	}
}

class DivFactory implements IFactory {
	public Operation createOperation() {
		return new OperationDiv();
	}
}

abstract class Operation {
	public double a = 0;
	public double b = 0;
	public abstract double getResult();
}

class OperationAdd extends Operation {
	public double getResult() {
		double result = 0;
		result = a + b;
		return result;
	}
}

class OperationSub extends Operation {
	public double getResult() {
		double result = 0;
		result = a - b;
		return result;
	}
}

class OperationMul extends Operation {
	public double getResult() {
		double result = 0;
		result = a * b;
		return result;
	}
}

class OperationDiv extends Operation {
	public double getResult() {
		double result = 0;
		result = a / b;
		return result;
	}
}