package tws.service;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	public List<Employee> selectAll() {
		List<Employee> employees = employeeMapper.selectAll();
        for(Employee employee : employees) {
        	employee.setName("中原银行-"+ employee.getName());
        }
		return employees;
	}

	public void insert(Employee employee) {
		employeeMapper.insert(employee);

	}

}
