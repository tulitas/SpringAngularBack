package backend.controllers;

import backend.dto.EmployeeAndPositionDto;
import backend.services.JoinQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoinQueryController {
    private final JoinQueryService joinQueryService;

    public JoinQueryController(JoinQueryService joinQueryService) {
        this.joinQueryService = joinQueryService;
    }

    @GetMapping("/dept/employees/left")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionLeftJoin(){
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionLeftJoin(),
                HttpStatus.OK);
    }
    @GetMapping("/dept/employees/right")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionRightJoin(){
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionRightJoin(),
                HttpStatus.OK);
    }


}