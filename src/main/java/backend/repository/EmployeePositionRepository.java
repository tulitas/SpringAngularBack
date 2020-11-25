package backend.repository;

import backend.model.EmployeePosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends CrudRepository<EmployeePosition, Long> {
}
