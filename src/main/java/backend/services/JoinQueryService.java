package backend.services;

import backend.dto.EmployeeAndPositionDto;
import backend.repository.EmployeePositionRepository;
import backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class JoinQueryService {
    @Resource
    private EmployeePositionRepository employeePositionRepository;

    @Resource
    private EmployeeRepository employeeRepository;

    public List<EmployeeAndPositionDto> getEmployeAndPositionLeftJoin() {
        System.out.println("hi2");
        List<EmployeeAndPositionDto> list = employeePositionRepository.fetchEmpPosDataLeftJoin();
        System.out.println("hi3");
        list.forEach(System.out::println);
        System.out.println("hi4");
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionRightJoin() {
        List<EmployeeAndPositionDto> list = employeePositionRepository.fetchEmpPosDataRightJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionInnerJoin(){
        List<EmployeeAndPositionDto> list = employeeRepository.fetchEmpDeptDataInnerJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionCrossJoin(){
        List<EmployeeAndPositionDto> list = employeeRepository.fetchEmpDeptDataCrossJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }
}
