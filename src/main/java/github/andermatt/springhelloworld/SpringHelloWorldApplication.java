package github.andermatt.springhelloworld;

import github.andermatt.springhelloworld.model.Employee;
import github.andermatt.springhelloworld.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

	/*
	Load the database with entities for demonstration. This method automatically runs at application startup.
	 */

	@Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {
	    System.out.println("Inside init(). Adding Employees to database...");
	    return args -> {
            List<Employee> employees = Arrays.asList(
                    new Employee( "Matthew", "Anderson", "anderma8@oregonstate.edu"),
                    new Employee( "Patrick", "Rice", "ricep@oregonstate.edu"),
                    new Employee( "Zi", "Wu", "wuzi@oregonstate.edu")
            );

            // Save to database.
            // Spring automatically generates the saveAll method for us - we don't need to write any SQL.
            employeeRepository.saveAll(employees);
        };
    }

}
