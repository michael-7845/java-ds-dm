package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * ��Աimp��abstractionû����ͬ�ĸ����ͣ� ǿ������;�����Ϊ�ķ��롣������Ϊ���������е��ࡣ�ؼ����Ƿ���
 * �Ƚϣ�
 * adapter, proxy, decorator
 * ��3��ģʽ�ж����Ժ�����ͬ�����͵ĳ�Ա
 * adapter�ṩ�µĽӿ���ʽ�� ���ض�ԭ����ĵ��ã��ؼ������½ӿ�
 * decorator���ı�ԭ�ӿڣ�����µĹ��ܣ��ؼ������¹���
 * 
 * ������
 * ��a, b, c���ֹ���
 * bridge������ѡ�� �����ͨ�������������a/b/cʹ�����ֹ���
 * adapter������3�ֹ��ܣ�����Ҫͨ����������
 * decorator����a���ܣ� �����ṩ��b��c���ܵ���ǿ�� �����ѡ��a+b+c, a+c��
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