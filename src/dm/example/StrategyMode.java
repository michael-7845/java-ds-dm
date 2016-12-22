package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * 类模式用继承，对象模式用委托
 * Strategy（行为模式）将复杂的算法封装起来， 便于替换。 为了扩展和修改，能动态配置。关键词是修改
 * 比较：
 * Bridge（结构型模式）底层实现和上层接口可以分别演化，提高移植性
 */
public class StrategyMode {
	public static void demo() {
		Context c = new Context(new StrategyA());
		c.algorithmInterface();
		
		c = new Context(new StrategyB());
		c.algorithmInterface();
	}

	public static void main(String[] args) {
		demo();
	}

}

abstract class Strategy {
	public abstract void algorithm();
}

class StrategyA extends Strategy {
	public void algorithm() {
		println("strategy a");
	}
}

class StrategyB extends Strategy {
	public void algorithm() {
		println("strategy b");
	}
}

class Context {
	Strategy s;
	
	public Context(Strategy s) {
		this.s = s;
	}
	
	public void algorithmInterface() {
		this.s.algorithm();
	}
}
