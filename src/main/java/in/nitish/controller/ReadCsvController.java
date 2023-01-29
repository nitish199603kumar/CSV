package in.nitish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nitish.service.ReadCsvService;

@RestController
@RequestMapping("/api/csv")
public class ReadCsvController {
	
	@Autowired
	private ReadCsvService readCsvService;
	
//	String str="C:\\Users\\NKSK\\Desktop\\New SpringBoot\\1-ReadCSVFileApp\\src\\main\\resources\\Book1.csv";
	
	@GetMapping("/readcsv")
	public ResponseEntity<String> readCsv(){
		
		String readCsv = readCsvService.readCsv();
		
		return new ResponseEntity<String>(readCsv,HttpStatus.OK);
		
	}

}
