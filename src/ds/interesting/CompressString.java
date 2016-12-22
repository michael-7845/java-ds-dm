package ds.interesting;

import static kemin.util.Pr.*;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CompressString {
	
	public static String compress(String orig) {
		StringBuffer sb = new StringBuffer();
		int length = orig.length();
		if(length <= 1)
			return orig;
		
		for(int i=0; i<length; i++) {
			int j = i+1;
			char c = orig.charAt(i);
			while(j<length && c==orig.charAt(j)) {
				j++;
			}
			sb.append(c);
			sb.append(j-i);
			i = j-1;
		}
		
		return sb.toString();
	}
	
	@Test
	public void test() {
		String s1 = "aabcccaaaa";
        String expectedS1 = "a2b1c3a4";
        
        String s2 = "aaaaaaaaaaaa";
        String expectedS2 = "a12";
        
        String s3 = "abcdefg";
        String expectedS3 = "abcdefg";
        
        String s4 = "aabbccdd";
        String expectedS4 = "aabbccdd";
        
        Assert.assertEquals(expectedS1, compress(s1));
        Assert.assertEquals(expectedS2, compress(s2));
        Assert.assertEquals(expectedS3, compress(s3));
        Assert.assertEquals(expectedS4, s4);
	}
	
	public static void demo() {
		String s1 = "aabcccaaaa";
        String expectedS1 = "a2b1c3a4";
        println(compress(s1));
	}

	public static void main(String[] args) {
		demo();
	}

}
