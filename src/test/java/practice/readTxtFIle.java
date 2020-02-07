package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class readTxtFIle {

	public static void main(String[] args) throws IOException {
		
		 String path="./src/test/configs.properties";
	        
	        
	        FileReader fis=new FileReader(path);
	        
	        Properties prop=new Properties();
	        prop.load(fis);
	        
	        System.out.println(prop.get("url"));
	        System.out.println("**************");
	        
		
		Scanner fir = new Scanner(new File("./src/test/java/practice/hello.txt"));
		
		while(fir.hasNextLine()) {
			String text = fir.nextLine();
			  System.out.println(text);
		}
	}
	
}
