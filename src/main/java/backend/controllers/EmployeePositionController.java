package backend.controllers;

import backend.exception.ResourcesNotFoundException;
import backend.model.EmployeePosition;
import backend.repository.EmployeePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/positions")
public class EmployeePositionController {
    @Autowired
    private EmployeePositionRepository employeePositionRepository;

    @GetMapping("/positions")
    public List<EmployeePosition> getAllEmployeePositions() {
                return (List<EmployeePosition>) employeePositionRepository.findAll();
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<EmployeePosition> getEmployeePositionById(@PathVariable(value = "id") Long positionId)
            throws ResourcesNotFoundException{
        EmployeePosition employeePosition = employeePositionRepository.findById(positionId)
                .orElseThrow(() -> new ResourcesNotFoundException("Position not found for this id :: " + positionId));
        return ResponseEntity.ok().body(employeePosition);
    }

    @PostMapping("/positions")
    public EmployeePosition createEmployeePosition(@RequestBody EmployeePosition employeePosition) {
        return employeePositionRepository.save(employeePosition);
    }
    @PutMapping("/positions/{id}")
    public ResponseEntity<EmployeePosition> updateUser(@PathVariable(value = "id") Long positionId,
                                                       @RequestBody EmployeePosition positionDetails) throws ResourcesNotFoundException {
        EmployeePosition employeePosition = employeePositionRepository.findById(positionId)
                .orElseThrow(()-> new ResourcesNotFoundException("User not found for this id :: " + positionId));
        employeePosition.setPosition(positionDetails.getPosition());
        final EmployeePosition updatePosition = employeePositionRepository.save(employeePosition);
        return ResponseEntity.ok(updatePosition);
    }

    @DeleteMapping("/positions/{id}")
    public Map<String, Boolean> deleteEmployeePosition(@PathVariable(value = "id") Long positionId)
            throws ResourcesNotFoundException {
        EmployeePosition employeePosition = employeePositionRepository.findById(positionId)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found for this id :: " + positionId));
        employeePositionRepository.delete(employeePosition);
        Map<String, Boolean> responce = new HashMap<>();
        responce.put("deleted", Boolean.TRUE);
        return responce;
    }
}