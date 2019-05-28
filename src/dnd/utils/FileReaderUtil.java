package dnd.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class FileReaderUtil {

	
	public List<String> readFile(String fileName) throws IOException{
		File file = new File(fileName); 
		System.out.println(file.getAbsolutePath());

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		List<String> fileList = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null) {
			fileList.add(st);
		}
		br.close();
		return fileList;
	}
	
	public List<String> servletReadFile(String fileName, ServletContext context) throws IOException{
        String filename2 = "/WEB-INF/"+fileName;
        List<String> fileList = new ArrayList<String>();
        InputStream is = context.getResourceAsStream(filename2);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String text;
            while ((text = reader.readLine()) != null) {
                fileList.add(text);
            }
        }
        return fileList;
	}
	
	public void removeAndAddLine(String target, String newValue, String filePath) throws IOException {
		
		File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
        	reader = new BufferedReader(new FileReader(fileToBeModified));
        	String line = reader.readLine();
        	while (line != null) {
        		if(line.contains(target+":")) {
        			oldContent = oldContent + newValue + System.lineSeparator();
        		}else {
        			oldContent = oldContent + line + System.lineSeparator();
        		}
        		line = reader.readLine();
        	}
        	writer = new FileWriter(fileToBeModified);

        	writer.write(oldContent);
        } catch (IOException e) {
        	e.printStackTrace();
        } finally  {
        	try {
        		reader.close();
        		writer.close();
        	} 
        	catch (IOException e) {
        		e.printStackTrace();
        	}
        }
	}

}
