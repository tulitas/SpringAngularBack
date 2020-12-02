package backend.services;

import backend.model.Employee;
import backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class QueryService implements IQueryService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<Employee> JPQLQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e.firstname, e.positionId from Employee e inner join EmployeePosition p on e.positionId = p.id");
    }
}
