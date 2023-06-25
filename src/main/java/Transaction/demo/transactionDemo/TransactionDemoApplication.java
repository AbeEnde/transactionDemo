package Transaction.demo.transactionDemo;

import Transaction.demo.transactionDemo.model.DataMapper;
import Transaction.demo.transactionDemo.model.DataMapperChild;
import Transaction.demo.transactionDemo.repository.ChildRepo;
import Transaction.demo.transactionDemo.repository.ParentRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication()
public class TransactionDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(TransactionDemoApplication.class, args);
	}

	/**
	 * persist data to respective database tables when the app bootstrap
	 * @param repo
	 * @param childRepo
	 * @return
	 */
	@Bean
	CommandLineRunner runner(ParentRepo repo, ChildRepo childRepo) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<DataMapper> parentData = new TypeReference<DataMapper>(){};
			TypeReference<DataMapperChild> childData = new TypeReference<DataMapperChild>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/JsonData/parent.json");
			InputStream inputStream1 = TypeReference.class.getResourceAsStream("/JsonData/child.json");

			try {
				DataMapper data = mapper.readValue(inputStream, parentData);
				DataMapperChild data1 = mapper.readValue(inputStream1, childData);
				repo.saveAll(data.getData());
				childRepo.saveAll(data1.getData());
				System.out.println("data Saved!");
			} catch (IOException e){
				System.out.println("Unable to save data: " + e.getMessage());
			}
		};
	}

}
