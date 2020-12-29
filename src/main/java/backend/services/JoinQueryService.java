package backend.services;

import backend.dto.EmployeeAndPositionDto;
import backend.repository.JoinEmployeeAndPositionRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class JoinQueryService {
    @Resource
    private JoinEmployeeAndPositionRepository joinEmployeeAndPositionRepository;

    public List<EmployeeAndPositionDto> getEmployeAndPositionLeftJoin() {
        List<EmployeeAndPositionDto> list = joinEmployeeAndPositionRepository.fetchEmpPosDataLeftJoin();
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionRightJoin() {
        List<EmployeeAndPositionDto> list = joinEmployeeAndPositionRepository.fetchEmpPosDataRightJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionInnerJoin(){
        List<EmployeeAndPositionDto> list = joinEmployeeAndPositionRepository.fetchEmpDeptDataInnerJoin();
        return list;
    }

    public List<EmployeeAndPositionDto> getEmployeAndPositionCrossJoin(){
        List<EmployeeAndPositionDto> list = joinEmployeeAndPositionRepository.fetchEmpDeptDataCrossJoin();
        return list;
    }
}
