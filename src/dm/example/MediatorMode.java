package dm.example;

public class MediatorMode {
	public static void demo() {
		Mediator m = new ConcreteMediator();
		
		Colleague c1 = new ConcreteColleague1(m);
		Colleague c2 = new ConcreteColleague2(m);
		
		m.setColleague1(c1);
		m.setColleague2(c2);
		
//		m.send("are you okey, guys?", c1);
//		m.send("I'm fine, thank you.", c2);
		c1.sendMessage("Good morning!");
		c2.sendMessage("Good morning!");
	}

	public static void main(String[] args) {
		demo();
	}
}

abstract class Mediator {
	public abstract void send(String message, Colleague colleague);
	public abstract void setColleague1(Colleague colleague);
	public abstract void setColleague2(Colleague colleague);
}

class ConcreteMediator extends Mediator {
	private Colleague colleague1;
	private Colleague colleague2;
	
	public void setColleague1(Colleague colleague) {
		this.colleague1 = colleague;
	}
	public void setColleague2(Colleague colleague) {
		this.colleague2 = colleague;
	}
	
	public void send(String message, Colleague colleague) {
		if(colleague == this.colleague1) {
			this.colleague2.getMessage(message);
		} else {
			this.colleague1.getMessage(message);
		}
	}
}

abstract class Colleague {
	protected Mediator mediator;
	
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public void sendMessage(String message) {
		this.mediator.send(message, this);
	}
	
	public abstract void getMessage(String message);
}

class ConcreteColleague1 extends Colleague {
	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	
	public void getMessage(String message) {
		System.out.println("colleage 1 get: " + message);
	}
}

class ConcreteColleague2 extends Colleague {
	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
	}
	
	public void getMessage(String message) {
		System.out.println("colleage 2 get: " + message);
	}
}