package dm.example;

public class AdapterMode {

	public static void demo() {
		Target t = new Adapter();
		t.request();
	}
	
	public static void main(String[] args) {
		demo();
	}

}

class Target { //�ͻ����ڴ��Ľӿ�
	public void request() {
		System.out.println("normal request");
	}
}

class Adaptee { //��Ҫ�������
	public void specificRequest() {
		System.out.println("specific request");
	}
}

class Adapter extends Target { //������
	private Adaptee a = new Adaptee();
	
	public void request() {
		a.specificRequest();
	}
}