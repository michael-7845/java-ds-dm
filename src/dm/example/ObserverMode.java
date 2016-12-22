package dm.example;

import java.util.LinkedList;
import java.util.List;

public class ObserverMode {

	public static void demo() {
		ConcreteSubject s = new ConcreteSubject();
		
		s.attach(new ConcreteObserver("x", s));
		s.attach(new ConcreteObserver("y", s));
		s.attach(new ConcreteObserver("z", s));
		
		s.subjectState = "abc";
		s.Notify();
	}
	
	public static void main(String[] args) {
		demo();
	}

}

abstract class _Subject {
	private List<Observer> observers = new LinkedList<Observer>();
	
	public void attach(Observer o) {
		observers.add(o);
	}
	
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	public void Notify() {
		for(Observer o: observers) {
			o.update();
		}
	}
	
	public abstract String getState();
}

class ConcreteSubject extends _Subject {
	public String subjectState;
	
	public String getState() {
		return subjectState;
	}
}

abstract class Observer {
	public abstract void update();
}

class ConcreteObserver extends Observer {
	public String name;
	public _Subject subject;
	
	public ConcreteObserver(String name, _Subject subject) {
		this.name = name;
		this.subject = subject;
	}
	
	public void update() {
		System.out.println("observer " + name + " get the subject state: " + subject.getState());
	}
}