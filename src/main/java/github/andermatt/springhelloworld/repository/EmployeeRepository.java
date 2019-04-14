package github.andermatt.springhelloworld.repository;

import github.andermatt.springhelloworld.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*
    There is a lot of Spring magic going on behind the scenes with the JpaRepository interface.

    By defining this interface, Spring will automatically implement every method that's part of the JpaRepository
    interface - we don't need to write any SQL for these boilerplate queries.

    For example - the JpaRepository interface includes a method with the following signature:
        List<T> findAll()

    <T> is a generic type in Java - note that we're defining it as type Employee.

    Spring will automatically implement this method for us, such that when we call it, every Employee
    in the employee table will be returned.

    */

    // This is a custom query - find an employee by email address. Again, we don't need to write any SQL - Spring
    // is able to generate the appropriate SQL by parsing the method name - findByEmail.
    public Optional<Employee> findByEmail(String email);
}
