import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class IntList {
	public static void main(String[] args) {
		System.out.println("\tPopulating LinkedList with randomly generated integers");
		LinkedList<Integer> ints = new LinkedList<Integer>(); //Create new LinkedList in which to store randomly generated Integers
		Random rand = new Random();
		for (int i = 0; i < 10; i++) { //Create 10 random integers between 1 and 100
			int number = rand.nextInt(100);
			ints.add(number);
		}
		for (int val : ints) { //Output the elements of the LinkedList
			System.out.println(val);
		}
		System.out.println();
		writeToFile(ints); //Call writeToFile method, passing LinkedList as an argument
		readFromFile(); //Call readFromFile function
	}

	public static void writeToFile(LinkedList<Integer> numberList) { //Declare writeToFile function
		try {
			FileWriter filewriter = new FileWriter("numbers.txt"); //Create new FileWriter object to write to file
			BufferedWriter writer = new BufferedWriter(filewriter); //Create BufferedWriter to created a buffered character-output stream
			System.out.println("\n\tWriting to file");
			for (int val : numberList) { //Enhanced for-loop to write each element of LinkedList to file
				writer.write(Integer.toString(val) + "\n");
			}
			writer.close(); //Close the stream
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile() { //Declare readFromFile function
		try {
			File LibraryFile = new File("numbers.txt"); //Create new File object to represent a model of the actual file on the disk
			FileReader filereader = new FileReader(LibraryFile); //FileReader object to read the file as a stream of characters
			BufferedReader reader = new BufferedReader(filereader); //BufferedReader  to read the text from a character-based input stream
			String line = null;
			System.out.println("\n\tReading from file");
			while ((line = reader.readLine()) != null) { //While there is another line in the buffered reader, print it to the console
				System.out.println(line);
			}
			
			reader.close(); //Close the stream
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}