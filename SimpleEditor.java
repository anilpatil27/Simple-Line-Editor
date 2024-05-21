package may.twentyone;
import java.io.*;
import java.util.*;

public class SimpleEditor {
    
    public static void main(String[] args) {
        FileOperations fileOp = new FileOperations();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Commands: read <file>, save <file>, list, insert <line number> <text>, delete <line number>, exit");
            System.out.print("> ");
            String command = scanner.nextLine();
            
            String[] parts = command.split(" ", 3);
            String cmd = parts[0];
            
            try {
                switch (cmd) {
                    case "read":
                        fileOp.readFile(parts[1]);
                        System.out.println("File loaded into the editor.");
                        break;
                    case "save":
                        fileOp.saveFile(parts[1]);
                        System.out.println("File saved.");
                        break;
                    case "list":
                        fileOp.formatLinesAndDisplay();
                        break;
                    case "insert":
                        int lineNumber = Integer.parseInt(parts[1]);
                        String text = parts[2];
                        fileOp.insertLine(lineNumber, text);
                        System.out.println("Line inserted.");
                        break;
                    case "delete":
                        lineNumber = Integer.parseInt(parts[1]);
                        fileOp.deleteLine(lineNumber);
                        System.out.println("Line deleted.");
                        break;
                    case "exit":
                        System.out.println("Exiting..!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Enter valid command.");
                }
            } catch (IOException e) {
            	//Log the error
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try with valid one.");
            }
        }
    }
}
