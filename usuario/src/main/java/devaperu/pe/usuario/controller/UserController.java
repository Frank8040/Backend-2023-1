package devaperu.pe.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import devaperu.pe.usuario.entity.User;
import devaperu.pe.usuario.service.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok().body(userService.list());
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User usuario) {
        return ResponseEntity.ok(userService.save(usuario));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User usuario) {
        return ResponseEntity.ok(userService.update(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(userService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(required = true) Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Eliminación Correcta");
    }
}
