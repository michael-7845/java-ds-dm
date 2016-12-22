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

class Target { //客户所期待的接口
	public void request() {
		System.out.println("normal request");
	}
}

class Adaptee { //需要适配的类
	public void specificRequest() {
		System.out.println("specific request");
	}
}

class Adapter extends Target { //适配器
	private Adaptee a = new Adaptee();
	
	public void request() {
		a.specificRequest();
	}
}