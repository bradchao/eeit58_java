package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Brad55 {

	public static void main(String[] args) {
		
		try (FileReader reader = new FileReader("dir1/Fstdata.csv");
			BufferedReader br = new BufferedReader(reader);){
			String line = br.readLine();
			//System.out.println(line);
			
			int i = 1;
			while ( (line = br.readLine()) != null ) {
				//System.out.printf("%d:%s\n", i++, line);
				
				String[] row = line.split(",");
				System.out.printf("%s:%s:%s:%s\n", row[1], row[2],row[5],row[7]);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
