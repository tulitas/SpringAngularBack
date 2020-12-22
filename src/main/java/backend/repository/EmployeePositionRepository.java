package backend.repository;

import backend.dto.EmployeeAndPositionDto;
import backend.model.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePositionRepository extends CrudRepository<EmployeePosition, Long>, JpaRepository<EmployeePosition, Long> {

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(d.position, e.firstName, e.lastName, e.emailId) " +
            "FROM EmployeePosition d LEFT JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpPosDataLeftJoin();

    @Query(value = "SELECT new backend.dto.EmployeeAndPositionDto(e.firstName, e.lastName, e.emailId, d.position) " +
            "FROM EmployeePosition d RIGHT JOIN d.employees e")
    List<EmployeeAndPositionDto> fetchEmpPosDataRightJoin();
}
