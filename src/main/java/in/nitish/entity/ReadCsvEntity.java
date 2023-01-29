package in.nitish.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="read_csv")
public class ReadCsvEntity {
	
	@Id
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;

}
