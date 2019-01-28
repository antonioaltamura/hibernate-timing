

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {
	
	private String file;
    private BufferedReader br = null;
    private String line = "";
    private String separator;

	public CSVReader(String file,String separator) {
		try {
			this.file = file;
			br = new BufferedReader(new FileReader(file));
			this.separator = separator;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void rewind() {
	    try {
			br.close();
			br = new BufferedReader(new FileReader(this.file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[] readLine() {
		try {
			if((line = br.readLine()) != null) {
				return line.split(separator);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
