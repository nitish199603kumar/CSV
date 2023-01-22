package in.nitish.readcsv;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCsv {

	public static void main(String[] args) {
		
		String str="C:\\Users\\NKSK\\Desktop\\New SpringBoot\\1-ReadCSVFileApp\\src\\main\\resources\\Book1.csv";
		readDataLineByLine(str);
		System.out.println("====================================");
		readAllDataAtOnce(str);

	}
	
	// Java code to illustrate reading a
	// CSV file line by line
	public static void readDataLineByLine(String file)
	{

		try {

			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");	
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Java code to illustrate reading a
	// all data at once
	public static void readAllDataAtOnce(String file)
	{
		try {
			// Create an object of file reader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvReader object and skip first Line
			CSVReader csvReader = new CSVReaderBuilder(filereader)
									.withSkipLines(1)
									.build();
			List<String[]> allData = csvReader.readAll();

			// print Data
			for (String[] row : allData) {
				for (String cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Java code to illustrate
	// Reading CSV File with different separator
	public static void readDataFromCustomSeparator(String file)
	{
		try {
			// Create an object of file reader class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvParser object with
			// custom separator semi-colon
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

			// create csvReader object with parameter
			// filereader and parser
			CSVReader csvReader = new CSVReaderBuilder(filereader)
									.withCSVParser(parser)
									.build();

			// Read all data at once
			List<String[]> allData = csvReader.readAll();

			// Print Data.
			for (String[] row : allData) {
				for (String cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
