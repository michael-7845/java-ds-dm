package dm.example;

import static kemin.tool.print.DebugTools.*;

public class MementoMode {
	public static void demo() {
		IOriginator o = new Originator();
		((Originator)o).setState("On");
		((Originator)o).show();
		
		//save
		ICaretaker c = new Caretaker();
		c.setMemento(o.createMemento());
		
		((Originator)o).setState("Off");
		((Originator)o).show();
		
		//restore
		o.setMemento(c.getMemento());
		((Originator)o).show();
	}
	
	public static void main(String[] args) {
		demo();
	}
}

interface IOriginator {
	public void setMemento(Memento memento);
	public Memento createMemento();
}

class Originator implements IOriginator {
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setMemento(Memento memento) {
		this.state = memento.getState();
	}
	public Memento createMemento() {
		return new Memento(state);
	}
	public void show() {
		System.out.println("Originator state: " + state);
	}
}

class Memento {
	public Memento(String state) {
		this.state = state;
	}
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}

interface ICaretaker {
	public Memento getMemento();
	public void setMemento(Memento memento);
}

class Caretaker implements ICaretaker {
	private Memento memento;
	public Memento getMemento() {
		return memento;
	}
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}