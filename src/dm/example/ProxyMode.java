package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * proxy封装一个对象，对这个对象的访问进行附加的控制。一般代理和被代理是同根生的。 关键词是控制
 * 比较：
 * adapter提供新的接口形式， 隐藏对原有类的调用。适配和被适配不需要一定同根生。关键词是新接口
 * facade整合细粒度的接口，形成粗粒度的接口，形成的接口比子系统更容易使用
 */
public class ProxyMode {
	public static void demo() {
		Client c = new Client();
		RealSubject rs = new RealSubject();
		Proxy proxy = new Proxy(rs);
		c.handleSubject(proxy);
	}

	public static void main(String[] args) {
		demo();
	}

}

interface Subject {
	public void request();
}

class RealSubject implements Subject {
	public void request() {
		println("RealSubject request()");
	}
}

class Proxy implements Subject {
	Subject s;
	
	public Proxy(Subject s) {
		this.s = s;
	}
	
	public void request() {
		if(s != null) {
			s.request();
		}
	}
}

class Client {
	public void handleSubject(Subject s) {
		s.request();
	}
}