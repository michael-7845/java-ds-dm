package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * 成员imp和abstraction没有相同的父类型， 强调抽象和具体行为的分离。往往是为了利用已有的类。关键词是分离
 * 比较：
 * adapter, proxy, decorator
 * 这3种模式中都可以含有相同父类型的成员
 * adapter提供新的接口形式， 隐藏对原有类的调用，关键词是新接口
 * decorator不改变原接口，添加新的功能，关键词是新功能
 * 
 * 举例：
 * 有a, b, c三种功能
 * bridge是让你选择， 你决定通过本类来组合上a/b/c使用哪种功能
 * adapter是有这3种功能，但你要通过我来调用
 * decorator是有a功能， 另外提供了b、c功能的增强， 你可以选择a+b+c, a+c等
 */
public class BridgeMode {
	public static void demo() {
		Abstraction ab = new RefinedAbstraction();
		ab.setImplementor(new ConcreteImplementorA());
		ab.operation();
		ab.setImplementor(new ConcreteImplementorB());
		ab.operation();
	}
	
	public static void main(String[] args) {
		demo();
	}
}

interface Implementor {
	public void operationImp();
}

class ConcreteImplementorA implements Implementor {
	@Override
	public void operationImp() {
		println("specific implemention A");
	}
}

class ConcreteImplementorB implements Implementor {
	@Override
	public void operationImp() {
		println("specific implemention B");
	}
}

abstract class Abstraction {
	protected Implementor imp; 
	public void setImplementor(Implementor imp) {
		this.imp = imp;
	}
	public abstract void operation();
}

class RefinedAbstraction extends Abstraction {
	@Override
	public void operation() {
		this.imp.operationImp();
	}
}