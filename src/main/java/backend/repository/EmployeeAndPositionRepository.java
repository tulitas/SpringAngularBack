package backend.repository;

import backend.model.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAndPositionRepository extends JpaRepository<EmployeePosition, Integer> {

}
