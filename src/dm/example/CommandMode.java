package dm.example;

import static kemin.tool.print.DebugTools.*;

import java.util.ArrayList;
import java.util.List;

public class CommandMode {
	public static void demo() {
		Invoker i = new Invoker();
		Receiver r = new Receiver();
		Command c1 = new ConcreteCommandA(r, "beer"),
				c2 = new ConcreteCommandA(r, "cola"),
				c3 = new ConcreteCommandB(r, "meat"),
				c4 = new ConcreteCommandA(r, "soda");
		i.addCommand(c1);
		i.addCommand(c2);
		i.addCommand(c3);
		i.addCommand(c4);
		i.execute();
		
		i.cancelCommand(c2);
		i.execute();
	}

	public static void main(String[] args) {
		demo();
	}
}

abstract class Command {
	Receiver r;
	String comments;
	public Command(Receiver r, String comments) {
		this.r = r;
		this.comments = comments;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		return false;
	}
	public abstract void excute();
}

class ConcreteCommandA extends Command {
	public ConcreteCommandA(Receiver r, String comments) {
		super(r, comments);
	}

	@Override
	public void excute() {
		this.r.actionA(this.comments);
	}
}

class ConcreteCommandB extends Command {
	public ConcreteCommandB(Receiver r, String comments) {
		super(r, comments);
	}

	@Override
	public void excute() {
		this.r.actionB(this.comments);
	}
}

class Invoker {
	private List<Command> commands = new ArrayList<Command>();
	public void addCommand(Command c) {
		this.commands.add(c);
	}
	public void cancelCommand(Command c) {
		this.commands.remove(c);
	}
	public void execute() {
		for(Command c: this.commands) {
			c.excute();
		}
	}
}

class Receiver {
	public void actionA(String s) {
		println(String.format("executing command A (drinking): %s", s));
	}
	
	public void actionB(String s) {
		println(String.format("executing command B (eating): %s", s));
	}
}