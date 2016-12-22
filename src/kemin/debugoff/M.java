/**
 * 
 */
package kemin.debugoff;
import static kemin.util.Pr.*;

/**
 * @author user
 *
 */
public class M {
public static void debug(String s) {
		
	}
	public static void p(boolean b) {

	}
	public static void p(byte b) {

	}
	public static void p(char c) {

	}
	public static void p(double d) {

	}
	public static void p(float f) {

	}
	public static void p(int i) {

	}
	public static void p(long l) {

	}
	public static void p(short s) {

	}
	public static void p(Object o) {

	}
	
	public static void d(String s) {
		
	}
	public static void d(boolean b) {

	}
	public static void d(byte b) {

	}
	public static void d(char c) {

	}
	public static void d(double d) {

	}
	public static void d(float f) {

	}
	public static void d(int i) {

	}
	public static void d(long l) {

	}
	public static void d(short s) {

	}
	public static void d(Object o) {

	}

	public static String getTrace(){
        StringBuffer sb = new StringBuffer();  
         
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        int stacksLen = stacks.length;
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ")
          .append(stacks[1].getMethodName()).append("; number: ")
          .append(stacks[1].getLineNumber()).append("; ... ");
        
        return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
