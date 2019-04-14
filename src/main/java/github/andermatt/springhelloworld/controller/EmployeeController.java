package github.andermatt.springhelloworld.controller;

import github.andermatt.springhelloworld.model.Employee;
import github.andermatt.springhelloworld.repository.EmployeeRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/employee")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System.")
public class EmployeeController {

    /*
    With the @Autowired annotation, Spring's dependency injection system will provide
    an instance of the EmployeeRepository.
     */
    @Autowired
    EmployeeRepository employeeRepository;  // Database access.


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "View list of all available employees", response = List.class)
    public ResponseEntity<List<Employee>> getAllEmployees() {
            List<Employee> employees = employeeRepository.findAll();
            return ResponseEntity.ok(employees);
    }

    // Returns employee with the given ID, or 404 NOT FOUND.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "View an employee with the given ID")
    @ApiResponses( value = {
        @ApiResponse(code = 200, message = "Successfully retrieved employee with given ID."),
        @ApiResponse(code = 404, message = "The employee with the given ID could not be found.")
    })
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /*
   Get an employee by email - /api/employee/email/example@something.com
     */
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    @ApiOperation(value = "Find employee with given email address.")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee with given email address."),
            @ApiResponse(code = 404, message = "The employee with the given email address could not be found.")
    })
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {

        return employeeRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
