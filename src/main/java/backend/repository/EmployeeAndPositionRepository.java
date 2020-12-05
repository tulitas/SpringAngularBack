package backend.repository;

import backend.model.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeAndPositionRepository extends JpaRepository<EmployeePosition, Integer> {

}
