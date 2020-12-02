package backend.services;

import backend.model.Employee;

import java.util.List;

public interface IQueryService {
    List<Employee> JPQLQuery();
}
