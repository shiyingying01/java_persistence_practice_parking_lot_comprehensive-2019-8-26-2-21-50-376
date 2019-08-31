package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	@Select("SELECT * FROM employee " + "ORDER BY id " + "OFFSET #{page} ROWS FETCH NEXT #{pageSize} ROWS ONLY;")
	List<Employee> selectByPage(@Param("page") int page, @Param("pageSize") int pageSize);

	@Select("SELECT * FROM employee ")
	List<Employee> selectAll();

	@Insert("insert into employee values(#{employee.id},#{employee.name}," + "#{employee.age}) ")
	void insert(@Param("employee") Employee employee);

	@Select("SELECT * FROM employee where id=#{id}")
	Employee selectById(@Param("id") Integer id);
}
