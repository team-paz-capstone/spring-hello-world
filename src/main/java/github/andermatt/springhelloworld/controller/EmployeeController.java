package github.andermatt.springhelloworld.controller;

import github.andermatt.springhelloworld.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    // TODO - for demonstration purposes only. Real implementation
    // will retrieve employees from a service layer.
    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "Matthew", "Anderson", "anderma8@oregonstate.edu"),
            new Employee(2, "Patrick", "Rice", "ricep@oregonstate.edu"),
            new Employee(3, "Zi", "Wu", "wuzi@oregonstate.edu")
    );


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employees);
    }

    // Returns employee with the given ID, or 404 NOT FOUND.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

        return employees.stream()
                .filter(e -> e.getId() == id)
                .map(ResponseEntity::ok)
                .findFirst()
                .orElse(ResponseEntity.notFound().build());
    }
}
