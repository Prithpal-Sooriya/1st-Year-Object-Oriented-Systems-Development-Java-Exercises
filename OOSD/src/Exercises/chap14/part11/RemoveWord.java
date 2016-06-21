/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Exercises.chap14.part11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
*
* @author Prithpal Sooriya
*/
public class RemoveWord {

//main method to run code
public static void main(String[] args) {

//lets use the file choose class
JFileChooser fileChooser = new JFileChooser();
//null spawns in the center of the screen, and approve option is when the user selects a file and confirms
if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//surround with try and catch in case FileNotFoundException
try {
//choose a text file (will use a text file inside this package)
File file = fileChooser.getSelectedFile();

//prompt user what word they wish to replace
Scanner scan = new Scanner(System.in);
System.out.println("What word to remove: ");
String remove = scan.next();
scan.close();
//reuse Scanner to read the file
scan = new Scanner(file);

//create a temp file to store the new file
File temp = File.createTempFile("file", ".txt", file.getParentFile());
PrintWriter printWriter = new PrintWriter(temp);
//need to use a while loop through file
while(scan.hasNextLine()){
String line = scan.nextLine();
//remove word and write to the temp file
line = line.replace(remove, "").trim();
printWriter.println(line);
}
scan.close();
printWriter.close();
//deleate old file and rename the new file
file.delete();
temp.renameTo(file);
} catch (FileNotFoundException ex) {
System.out.println("File was not found");
} catch (IOException ex1){
System.out.println("Could not write to file, IO exception");
}

} else {
System.out.println("no file selected");
}
}

}
