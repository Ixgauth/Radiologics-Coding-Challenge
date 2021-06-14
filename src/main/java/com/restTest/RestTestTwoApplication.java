package com.restTest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.restTest.model.Subject;
import com.restTest.repos.SubjectRepository;

/**
 * Main method for the spring app. Should prepopulate the data for 10 Subjects and run the spring app.
 * @author ian
 *
 */
@SpringBootApplication
public class RestTestTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTestTwoApplication.class, args);
	}
	
	/**
	 * Should prepopulate the database with 10 Subjects.
	 * @author ian
	 *
	 */
	@Component
	class DemoCommandLineRunner implements CommandLineRunner{

		@Autowired
		private SubjectRepository subjRepository;

		@Override
		public void run(String... args) throws Exception {

			Subject ian = new Subject();
			ian.setId(UUID.randomUUID());
			ian.setName("Ian");
			ian.setAge(23);
			ian.setSex("Male");
			ian.setOccupation("Hopefully Developer");

			subjRepository.save(ian);

			Subject evan = new Subject();
			evan.setId(UUID.randomUUID());
			evan.setName("Evan");
			evan.setAge(22);
			evan.setSex("Male");
			evan.setOccupation("Student");

			subjRepository.save(evan);
			
			Subject keith = new Subject();
			keith.setId(UUID.randomUUID());
			keith.setName("Keith");
			keith.setAge(62);
			keith.setSex("Male");
			keith.setOccupation("Accountant");

			subjRepository.save(keith);
			
			Subject carol = new Subject();
			carol.setId(UUID.randomUUID());
			carol.setName("Carol");
			carol.setAge(61);
			carol.setSex("Female");
			carol.setOccupation("Med Tech");

			subjRepository.save(carol);
			
			Subject jasper = new Subject();
			jasper.setId(UUID.randomUUID());
			jasper.setName("Jasper");
			jasper.setAge(21);
			jasper.setSex("Male");
			jasper.setOccupation("Policy Advisor");

			subjRepository.save(jasper);
			
			Subject della = new Subject();
			della.setId(UUID.randomUUID());
			della.setName("Della");
			della.setAge(24);
			della.setSex("Female");
			della.setOccupation("Lobbyist");

			subjRepository.save(della);
			
			Subject agnes = new Subject();
			agnes.setId(UUID.randomUUID());
			agnes.setName("Agnes");
			agnes.setAge(22);
			agnes.setSex("Other");
			agnes.setOccupation("Sales");

			subjRepository.save(agnes);
			
			Subject fenton = new Subject();
			fenton.setId(UUID.randomUUID());
			fenton.setName("Fenton");
			fenton.setAge(22);
			fenton.setSex("Male");
			fenton.setOccupation("Student");

			subjRepository.save(jasper);
			
			Subject maggie = new Subject();
			maggie.setId(UUID.randomUUID());
			maggie.setName("Maggie");
			maggie.setAge(22);
			maggie.setSex("Female");
			maggie.setOccupation("Banker");

			subjRepository.save(maggie);
			
			Subject luc = new Subject();
			luc.setId(UUID.randomUUID());
			luc.setName("Luc");
			luc.setAge(22);
			luc.setSex("Male");
			luc.setOccupation("Unemployed");

			subjRepository.save(luc);
		}
	}

}
