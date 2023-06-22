package devaperu.pe.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import devaperu.pe.catalogo.entity.Category;
import devaperu.pe.catalogo.service.CategoryService;

@RestController
@RequestMapping("/categoria")
public class CategoryController {
    @Autowired
    private CategoryService categoriaService;

    @GetMapping()
    public ResponseEntity<List<Category>> listar() {
        return ResponseEntity.ok().body(categoriaService.listar());
    }

    @PostMapping()
    public ResponseEntity<Category> guardar(@RequestBody Category categoria) {
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }

    @PutMapping()
    public ResponseEntity<Category> actualizar(@RequestBody Category categoria) {
        return ResponseEntity.ok(categoriaService.actualizar(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(categoriaService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        categoriaService.eliminarPorId(id);
        return "Eliminación Correcta";
    }
}
