package dm.example;

import static kemin.tool.print.DebugTools.*;

public class ChainOfResponsibilityMode {
	public static void demo() {
		Handler h1 = new ConcreteHandlerA();
		Handler h2 = new ConcreteHandlerB();
		Handler h3 = new ConcreteHandlerC();


		
		int[] requests = { -1, 0, 1, 10, 11, 49, 50, 51, 82 };
		
		println("CoR: h3 h2 h1");
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);
		for(int request: requests) {
			h3.handleRequest(request);
		}
		
		println("CoR: h1 h2 h3");
		h1.resetSuccessor(); h2.resetSuccessor(); h3.resetSuccessor();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		for(int request: requests) {
			h1.handleRequest(request);
		}
		
		println("CoR: h1 h3 h2");
		h1.resetSuccessor(); h2.resetSuccessor(); h3.resetSuccessor();
		h1.setSuccessor(h3);
		h3.setSuccessor(h2);
		for(int request: requests) {
			h1.handleRequest(request);
		}
	}

	public static void main(String[] args) {
		demo();
	}

}

abstract class Handler {
	protected Handler successor;
	public void setSuccessor(Handler suc) {
		this.successor = suc;
	}
	public void resetSuccessor() {
		this.successor = null;
	}
	public abstract void handleRequest(int i);
}

class ConcreteHandlerA extends Handler {
	@Override
	public void handleRequest(int request) {
		if((request>=0) && (request<10)) {
			println("Request is handled by A, request: " + request);
		} else {
			if(this.successor != null)
				this.successor.handleRequest(request);
		}
	}
}

class ConcreteHandlerB extends Handler {
	@Override
	public void handleRequest(int request) {
		if((request>=10) && (request<50)) {
			println("Request is handled by B, request: " + request);
		} else {
			if(this.successor != null)
				this.successor.handleRequest(request);
		}
	}
}

class ConcreteHandlerC extends Handler {
	@Override
	public void handleRequest(int request) {
		if(request>=50) {
			println("Request is handled by C, request: " + request);
		} else {
			if(this.successor != null)
				this.successor.handleRequest(request);
		}
	}
}