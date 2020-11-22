package backend.controller;


import backend.exception.ResourcesNotFoundException;
import backend.model.User;
import backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
        throws ResourcesNotFoundException{
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User sreateUser( @RequestBody User user) {
        return usersRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @RequestBody User userDetails) throws ResourcesNotFoundException {
       User user = usersRepository.findById(userId)
       .orElseThrow(()-> new ResourcesNotFoundException("User not found for this id :: " + userId));
       user.setEmail(userDetails.getEmail());
       user.setBirthDate(userDetails.getBirthDate());
       user.setPassword(userDetails.getPassword());
        final User updateUser = usersRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
        throws ResourcesNotFoundException {
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found for this id :: " + userId));
        usersRepository.delete(user);
        Map<String, Boolean> responce = new HashMap<>();
        responce.put("deleted", Boolean.TRUE);
        return responce;
    }
}
