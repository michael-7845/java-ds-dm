package dm.example;

import java.util.ArrayList;
import java.util.List;

public class InterpreterMode {
	public static void demo() {
		_Context_ context = new _Context_();
		List<AbstractExpression> list = new ArrayList<AbstractExpression>();
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		
		for(AbstractExpression exp: list) {
			exp.interpret(context);
		}
	}
	
	public static void main(String[] args) {
		demo();
	}
}

class _Context_ {
	String input;
	String output;
}

abstract class AbstractExpression {
	public abstract void interpret(_Context_ context);
}

class TerminalExpression extends AbstractExpression {
	public void interpret(_Context_ context) {
		System.out.println("terminal expression");
	}
}

class NonterminalExpression extends AbstractExpression {
	public void interpret(_Context_ context) {
		System.out.println("non-terminal expression");
	}
}
