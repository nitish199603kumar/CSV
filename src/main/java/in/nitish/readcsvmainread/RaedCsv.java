package in.nitish.readcsvmainread;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class RaedCsv {

	public static void main(String[] args) {
		
		String str="C:\\Users\\NKSK\\Desktop\\New SpringBoot\\1-ReadCSVFileApp\\src\\main\\resources\\Book2.csv";
		try {
			readCsv(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public static void readCsv(String str1) throws IOException  {
		
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(str1));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL
	            		.withSkipHeaderRecord()
	                    .withHeader("Id","Username","FirstName","LastName")
	                    .withIgnoreHeaderCase()
	                    .withTrim());
	        ) {
	            for (CSVRecord csvRecord : csvParser) {
	                // Accessing values by Header names
	                String name = String.valueOf(csvRecord.get("Id"));
	                String email = csvRecord.get("Username");
	                String phone = csvRecord.get("FirstName");
	                String country = csvRecord.get("LastName");

	                System.out.println("Record No - " + csvRecord.getRecordNumber());
	                System.out.println("---------------");
	                System.out.println("Name : " + name);
	                System.out.println("Email : " + email);
	                System.out.println("Phone : " + phone);
	                System.out.println("Country : " + country);
	                System.out.println("---------------\n\n");
	            }
	        }
	}

}
