package asdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Spliterator;

public class Hello {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("scoredata.txt"));
			String temp = null;
			try {
				while((temp = br.readLine())!=null) {
					String[] data = temp.split(" ");
					for(int i =0; i<data.length;i++) {
						System.out.println(data[i]);
					}
					
					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		
			try {
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
