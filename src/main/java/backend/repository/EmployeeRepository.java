package backend.repository;

import backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>, JpaRepository<Employee, Long> {

@Query ("SELECT new backend.dto.EmployeePositionDto(d.position, e.firstname, e.lastname, e.email) from Employee d left join d.employeePosition e");

}
