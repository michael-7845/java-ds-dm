package dm.example;

public class IteratorMode {
	public static void demo() {
		ConcreteAggregate aggregate = new ConcreteAggregate(6);
		aggregate.setItem(0, 2);
		aggregate.setItem(1, 5);
		aggregate.setItem(2, 3);
		aggregate.setItem(3, 7);
		aggregate.setItem(4, 1);
		aggregate.setItem(5, 3);
		
//		IIterator iterator = aggregate.createIterator();
		IIterator iterator = aggregate.createReverseIterator();
		iterator.first();
		while(!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
		iterator.first();
		while(!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}
	
	public static void main(String[] args) {
		demo();
	}
}

interface IIterator {
	public Object first();
	public Object next();
	public boolean isDone();
	public Object currentItem();
}

interface IAggregate {
	public IIterator createIterator();
	public IIterator createReverseIterator();
}

class ConcreteIterator implements IIterator {
	private ConcreteAggregate aggregate;
	private int current = 0;
	
	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}
	
	public Object first() {
		current = 0;
		return aggregate.item(0);
	}
	
	public Object next() {
		Object o = null;
		current++;
		if(current < aggregate.getSize()) {
			o = aggregate.item(current);
		}
		return o;
	}
	
	public boolean isDone() {
		return (current >= aggregate.getSize())?true:false;
	}
	
	public Object currentItem() {
		return aggregate.item(current);
	}
}

class ReverseConcreteIterator implements IIterator {
	private ConcreteAggregate aggregate;
	private int current;
	
	public ReverseConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
		this.current = aggregate.getSize() - 1;
	}
	
	public Object first() {
		current = aggregate.getSize() - 1;
		return aggregate.item(current);
	}
	
	public Object next() {
		Object o = null;
		current--;
		if(current >= 0) {
			o = aggregate.item(current);
		}
		return o;
	}
	
	public boolean isDone() {
		return (current < 0)?true:false;
	}
	
	public Object currentItem() {
		return aggregate.item(current);
	}
}

class ConcreteAggregate implements IAggregate {
	private int[] items;
	private int size;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public ConcreteAggregate(int size) {
		this.size = size;
		items = new int[size];
	}
	
	@Override public IIterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	@Override public IIterator createReverseIterator() {
		return new ReverseConcreteIterator(this);
	}
	
	public Object item(int index) {
		return items[index];
	}
	
	public void setItem(int index, Object o) {
		items[index] = (Integer)o;
	}
}