package ds.interesting;

import java.util.ArrayList;
import java.util.List;

import static kemin.util.Pr.*;

public class Combine {
	
	//how many 1 in i's binary format
    public static int countOneInBinary(int i) {          
        int n;  
        for(n=0; i > 0; n++) {  
            i &= (i - 1);  
        }         
        return n;         
    }
    
    //select n items from array[m]
    public static void comb(String[] array, int n) {
    	int p = (int)(Math.pow(2, array.length)-1);
    	
    	List<Integer> bitmaps = new ArrayList<Integer>();
    	for(int i=0; i<p; i++) {
    		if(countOneInBinary(i) == n) {
    			bitmaps.add(i);
    		}
    	}
    	
    	List<List<String>> ll = new ArrayList<List<String>>();
    	for(int bitmap: bitmaps) {
    		List<String> l = new ArrayList<String>();
    		for(int i=0; i<array.length; i++) {
    			if((bitmap&1) == 1) {
    				l.add(array[i]);
    			}
    			bitmap /= 2;
    		}
    		ll.add(l);
    	}
    	println(ll);
    	println(ll.size());
    }
    
    public static void demo(String s, int n) {
    	String[] array = s.split(",");
    	comb(array, n);
    }
	
	public static void main(String[] args) {
		demo("a,b,c,d,e,f,g", 4);
	}

}
