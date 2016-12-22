package dm.example;

import static kemin.tool.print.DebugTools.*;

public class StateMode {
	public static void demo() {
		_Context c = new ConcreteContext(new StateB());
		c.request();
		c.request();
		c.request();
		c.request();
		c.request();
		c.request();
	}

	public static void main(String[] args) {
		demo();
	}
}

interface IState {
	public void handle(_Context c);
}
class StateA implements IState {
	public void handle(_Context c) {
		println("state a -> state b");
		c.state = new StateB();
	}
}
class StateB implements IState {
	public void handle(_Context c) {
		println("state b -> state a");
		c.state = new StateA();
	}
}

abstract class _Context {
	IState state;
	public _Context(IState state) {
		this.state = state;
	}
	public abstract void request();
}
class ConcreteContext extends _Context {
	public ConcreteContext(IState state) {
		super(state);
	}
	public void request() {
		this.state.handle(this);
	}
}