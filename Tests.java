package may.twentyone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

import junit.framework.TestCase;


public class Tests extends TestCase{
	
	@Test
	public void testReadFile() throws IOException {
		FileOperations op=new FileOperations();
		String path="C:\\Users\\Desktop\\myText.txt";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		List<String> lines = reader.lines().map(e-> e.toString()).collect(Collectors.toList());
		op.readFile(path);
		assertEquals(lines.size(), op.getLines().size());
		assertEquals(lines, op.getLines());	
		reader.close();
	}

	@Test
	public void testInsertLine() throws IOException {
		FileOperations op=new FileOperations();
		String path="C:\\\\Users\\\\Desktop\\\\myText.txt";
		op.readFile(path);
		op.insertLine(9, "Test Inserted Line");
		assertEquals("Test Inserted Line", op.getLines().get(8));
	}
	
	@Test
	public void testDeleteLine() throws IOException {
		FileOperations op=new FileOperations();
		String path="C:\\\\Users\\\\Desktop\\\\myText.txt";
		op.readFile(path);
		
		//number of lines before deletion
		int before= op.getLines().size();
		op.deleteLine(5);
		
		int after = op.getLines().size();
		assertEquals(before-1, after);
	}
	
	@Test
	public void testSaveOperation() throws IOException {
		FileOperations op=new FileOperations();
		String path="C:\\\\Users\\\\Desktop\\\\myText.txt";
		op.readFile(path);
		op.insertLine(9, "Test Inserted Line for save");
		
		String newFile = "C:\\temp\\newFile.txt";
		op.saveFile(newFile);
		
		//Test whether new file is loaded properly or not and check saved information
		op.readFile(newFile);
		
		BufferedReader reader = new BufferedReader(new FileReader(newFile));
		List<String> lines = reader.lines().map(e-> e.toString()).collect(Collectors.toList());
		
		assertEquals("Test Inserted Line for save", op.getLines().get(8));
		
		assertEquals(lines.size(), op.getLines().size());
		assertEquals(lines, op.getLines());	
		reader.close();
	}
}
