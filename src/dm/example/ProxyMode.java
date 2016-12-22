package dm.example;

import static kemin.tool.print.DebugTools.*;

/*
 * proxy��װһ�����󣬶��������ķ��ʽ��и��ӵĿ��ơ�һ�����ͱ�������ͬ�����ġ� �ؼ����ǿ���
 * �Ƚϣ�
 * adapter�ṩ�µĽӿ���ʽ�� ���ض�ԭ����ĵ��á�����ͱ����䲻��Ҫһ��ͬ�������ؼ������½ӿ�
 * facade����ϸ���ȵĽӿڣ��γɴ����ȵĽӿڣ��γɵĽӿڱ���ϵͳ������ʹ��
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