package dm.example;

import java.util.HashMap;
import java.util.Map;

public class FlyweightMode {
	public static void demo() {
		int extrinicstate = 22;
		FlyweightFactory f = new FlyweightFactory();
		
		Flyweight fx = f.getFlyweight("x");
		fx.operation(--extrinicstate);
		
		Flyweight fy = f.getFlyweight("y");
		fy.operation(--extrinicstate);
		
		Flyweight fz = f.getFlyweight("z");
		fz.operation(--extrinicstate);
		
		Flyweight uf = new UnsharedFlyweight();
		uf.operation(--extrinicstate);
		
		fx.operation(--extrinicstate);
		fy.operation(--extrinicstate);
		fz.operation(--extrinicstate);
	}
	
	public static void main(String[] args) {
		demo();
	}
}

abstract class Flyweight {
	public abstract void operation(int extrinicstate);
}

class ConcreteFlyweight extends Flyweight {
	public void operation(int extrinicstate) {
		System.out.println("concrete flyweight: " + extrinicstate + "; hashCode: " + this.hashCode());
	}
}

class UnsharedFlyweight extends Flyweight {
	public void operation(int extrinicstate) {
		System.out.println("unshared concrete flyweight: " + extrinicstate + "; hashCode: " + this.hashCode());
	}
}

class FlyweightFactory {
	private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
	
	public FlyweightFactory() {
		flyweights.put("x", new ConcreteFlyweight());
		flyweights.put("y", new ConcreteFlyweight());
		flyweights.put("z", new ConcreteFlyweight());
	}
	
	public Flyweight getFlyweight(String key) {
		return flyweights.get(key);
	}
}