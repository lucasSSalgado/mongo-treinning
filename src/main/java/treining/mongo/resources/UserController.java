package treining.mongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import treining.mongo.domain.User;
import treining.mongo.dto.UserDTO;
import treining.mongo.services.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User users = service.findById(id);
        UserDTO userDTO = new UserDTO(users);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody User user) {
        User newUser = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        User updateUser = service.updateById(user);
        UserDTO userDTO = new UserDTO(updateUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDTO);
    }

}
