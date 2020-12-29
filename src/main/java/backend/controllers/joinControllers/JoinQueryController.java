package backend.controllers.joinControllers;

import backend.dto.EmployeeAndPositionDto;
import backend.services.JoinQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dept/employees")
public class JoinQueryController {
    private final JoinQueryService joinQueryService;

    public JoinQueryController(JoinQueryService joinQueryService) {
        this.joinQueryService = joinQueryService;
    }

    @GetMapping("/left")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionLeftJoin(){
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionLeftJoin(),
                HttpStatus.OK);
    }
    @GetMapping("/right")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionRightJoin(){
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionRightJoin(),
                HttpStatus.OK);
    }

    @GetMapping("/inner")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionInnerJoin(){
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionInnerJoin(),
                HttpStatus.OK);
    }

    @GetMapping("/cross")
    public ResponseEntity<List<EmployeeAndPositionDto>> getEmployeAndPositionCrossJoin() {
        return new ResponseEntity<List<EmployeeAndPositionDto>>(joinQueryService.getEmployeAndPositionCrossJoin(),
                HttpStatus.OK);
    }
}
