package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * ��ģʽ�ü̳У�����ģʽ��ί��
 * Strategy����Ϊģʽ�������ӵ��㷨��װ������ �����滻�� Ϊ����չ���޸ģ��ܶ�̬���á��ؼ������޸�
 * �Ƚϣ�
 * Bridge���ṹ��ģʽ���ײ�ʵ�ֺ��ϲ�ӿڿ��Էֱ��ݻ��������ֲ��
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
