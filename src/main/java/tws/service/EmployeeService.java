package tws.service;

import tws.entity.Employee;

import java.util.List;

public interface EmployeeService {


    void insert(Employee employee);
    List<Employee> selectAll();


}
