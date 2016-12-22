/**
 * 
 */
package kemin.util;

import static kemin.util.Pr.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author user
 *
 */
public class BufferedInputFile {
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(
				new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			sb.append(s+"\n");
		in.close();
		return sb.toString();
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		print(read("E:\\myws\\Dm\\src\\kemin\\util\\data"));
	}

}
