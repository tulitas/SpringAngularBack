package backend.repository;

import backend.dto.EmployeeAndPositionDto;
import backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>, JpaRepository<Employee, Long> {

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(d.position, e.firstName, e.lastName, e.emailId) " +
            "FROM EmployeePosition d INNER JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpDeptDataInnerJoin();

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto( e.firstName, e.lastName, e.emailId, d.position) " +
            "FROM EmployeePosition d, Employee e")
    List<EmployeeAndPositionDto> fetchEmpDeptDataCrossJoin();


}
