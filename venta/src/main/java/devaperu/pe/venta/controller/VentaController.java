package devaperu.pe.venta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devaperu.pe.venta.dto.Producto;
import devaperu.pe.venta.entity.Venta;
import devaperu.pe.venta.service.VentaService;


@RestController
@RequestMapping("/venta")
public class VentaController {
    private List<Producto> productList;
     @Autowired
    private VentaService ventaService;

    @GetMapping()
    public ResponseEntity<List<Venta>> list() {
        return ResponseEntity.ok().body(ventaService.listar());
    }

    @PostMapping()
    public ResponseEntity<Venta> save(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.guardar(venta));
    }

    @PutMapping()
    public ResponseEntity<Venta> update(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.actualizar(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ventaService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        ventaService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

     @GetMapping("/buscarProducto")
    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
        List<Producto> matchingProducts = new ArrayList<>();

        for (Producto product : productList) {
            if (product.getNombre().toLowerCase().contains(keyword.toLowerCase())) {
                matchingProducts.add(product);
            }
        }

        model.addAttribute("products", matchingProducts);
        model.addAttribute("keyword", keyword);

        return "search-results";
    }

}
