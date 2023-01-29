package in.nitish.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import in.nitish.entity.ReadCsvEntity;
import in.nitish.repository.ReadCsvRepo;
import in.nitish.service.ReadCsvService;

@Service
public class ReadCsvImpl implements ReadCsvService {

	@Autowired
	private ReadCsvRepo readCsvRepo;

	@Override
	public String readCsv() {
		String csvFile = "C:\\Users\\NKSK\\Desktop\\New SpringBoot\\1-ReadCSVFileApp\\src\\main\\resources\\Book2.csv";

		List<ReadCsvEntity> readCsvEntitiesList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFile));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withSkipHeaderRecord()
					.withHeader("Id", "Username", "FirstName", "LastName").withIgnoreHeaderCase().withTrim());

			// List<ReadCsvEntity> readCsvEntitiesList=new ArrayList<>();
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by Header names
				Integer id = Integer.parseInt(csvRecord.get("Id"));
				String userName = csvRecord.get("Username");
				String firstName = csvRecord.get("FirstName");
				String lastName = csvRecord.get("LastName");
				ReadCsvEntity readCsvEntity = new ReadCsvEntity(id, userName, firstName, lastName);
				try {
					String writeDbToCsv=writeDbToCsv(id,userName,firstName,lastName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				readCsvEntitiesList.add(readCsvEntity);

				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("Id : " + id);
				System.out.println("UserName : " + userName);
				System.out.println("FirstName : " + firstName);
				System.out.println("LastName : " + lastName);
				System.out.println("---------------\n\n");
				
		//		readCsvEntitiesList.forEach(a ->{
		//			System.out.println("Firstname before save into db : - "+a.getFirstName());
		//			String firstName2 = a.getFirstName();
					
					
		//		});
			}
			/*
			 * FileReader fileReader=new FileReader(csvFile); CSVReader csvReader=new
			 * CSVReader(fileReader); String[] nextRecord; List<ReadCsvEntity>
			 * readCsvEntitiesList=new ArrayList<>();
			 * while((nextRecord=csvReader.readNext()) !=null) { for(String cell :
			 * nextRecord) { System.out.print(cell + "\t"); // ReadCsvEntity
			 * readCsvEntity=new ReadCsvEntity( // Integer.parseInt(cell.get("Id")), //
			 * cell.get("UserName"), // cell.get // );
			 * 
			 * } System.out.println(); }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}

		readCsvRepo.saveAll(readCsvEntitiesList);
		/*
		readCsvEntitiesList.forEach(e ->{
			System.out.println("Firstname after save into db : - "+e.getFirstName());
			List<ReadCsvEntity> findByFirstName = readCsvRepo.findByFirstName(e.getFirstName());

			System.out.println("hhh");
			for (ReadCsvEntity a: findByFirstName) {
				System.out.println("ssssss");
				System.out.println("a : " + a.getId());
				try {
					String writeDbToCsv=writeDbToCsv(a);
					System.out.println("File wrote" +writeDbToCsv);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			
		});
		*/
		/*
		String firstName1="Abhay";
		List<ReadCsvEntity> findByLastName = readCsvRepo.findByFirstName(firstName1);

		System.out.println("hhh");
		for (ReadCsvEntity a: findByLastName) {
			System.out.println("ssssss");
			System.out.println("a : " + a.getId());

		}
		*/
		return "File Uploaded Successfully";
	}

	private String writeDbToCsv(Integer id, String userName, String firstName, String lastName) throws IOException {
		final String SAMPLE_CSV_FILE = "C:\\Users\\NKSK\\Desktop\\New SpringBoot\\1-ReadCSVFileApp\\src\\main\\resources\\Book6.csv";
		
		try (
	            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

	            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
	                    .withHeader("Id", "Username", "FirstName", "LastName"));
	        ) {
			
			
	            csvPrinter.printRecord(id, userName, firstName, lastName);
//	            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
//	            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");
//
//	            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));
//
//	            csvPrinter.flush();   
	            System.out.println("End");
	        }
		return "Data write into file successfully";	
		
	}
	
	

}
