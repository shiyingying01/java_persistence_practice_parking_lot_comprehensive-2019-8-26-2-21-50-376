package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.selectAll());
    }

    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
    	employeeService.insert(employee);
        return ResponseEntity.created(URI.create("/employees/" + employee.getId())).body(employee);
    }
}
