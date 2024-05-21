package may.twentyone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {
	
	private ArrayList<String> lines;

	public FileOperations() {
		lines = new ArrayList<>();
	}
	
	public void readFile(String filename) throws IOException {
    	//Clear the previous file lines if any
        lines.clear();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
    }
    
    public void saveFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
    
    public void formatLinesAndDisplay() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }
    
    public void insertLine(int lineNumber, String line) {
        if (lineNumber < 1 || lineNumber > lines.size() + 1) {
            System.out.println("Invalid line number");
        } else {
            lines.add(lineNumber - 1, line);
        }
    }
    
    public void deleteLine(int lineNumber) {
        if (lineNumber < 1 || lineNumber > lines.size()) {
            System.out.println("Invalid line number");
        } else {
            lines.remove(lineNumber - 1);
        }
    }

}
