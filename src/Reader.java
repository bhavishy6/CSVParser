import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	private File file;
	private Scanner scanner;
	private ArrayList<Entry> entriesList;

	public Reader(String fileName) {
		entriesList = new ArrayList<Entry>();
		file = new File(fileName);
		try {
			scanner = new Scanner(file);
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine().trim();
				String[] entries = line.split(",");
				Entry entry = new Entry(entries[0], entries[1], entries[2],
						entries[3], entries[4], entries[5]);
				entriesList.add(entry);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Entry> getEntriesList() {
		return entriesList;
	}

	public void printEntriesList() {
		for(Entry e : entriesList) {
			System.out.println(e);
		}
	}
	
	public void writeOutput() {
		try {
			PrintWriter writer = new PrintWriter("output.txt");
			for (int i = 0; i < entriesList.size(); i++) {
				writer.println(entriesList.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Reader one = new Reader("exampleCSV.txt");
		one.printEntriesList();
	}

}
