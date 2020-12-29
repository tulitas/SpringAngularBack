package backend.repository;

import backend.dto.EmployeeAndPositionDto;
import backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinEmployeeAndPositionRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(d.position, e.firstName, e.lastName, e.emailId) " +
            "FROM EmployeePosition d INNER JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpDeptDataInnerJoin();

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(d.position, e.firstName, e.lastName, e.emailId) " +
            "FROM EmployeePosition d, Employee e")
    List<EmployeeAndPositionDto> fetchEmpDeptDataCrossJoin();

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(d.position, e.firstName, e.lastName, e.emailId) " +
            "FROM EmployeePosition d LEFT JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpPosDataLeftJoin();

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(e.firstName, e.lastName, e.emailId, d.position) " +
            "FROM EmployeePosition d RIGHT JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpPosDataRightJoin();
}
