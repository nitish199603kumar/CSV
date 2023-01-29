package in.nitish.repository;

import java.util.List;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nitish.entity.ReadCsvEntity;

public interface ReadCsvRepo extends JpaRepository<ReadCsvEntity, Integer> {
 
     public List<ReadCsvEntity>	findByFirstName(String firstName);

}
