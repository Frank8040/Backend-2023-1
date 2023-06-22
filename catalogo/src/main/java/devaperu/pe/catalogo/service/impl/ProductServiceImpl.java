package devaperu.pe.catalogo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devaperu.pe.catalogo.entity.Category;
import devaperu.pe.catalogo.entity.Product;
import devaperu.pe.catalogo.repository.CategoryRepository;
import devaperu.pe.catalogo.repository.ProductRepository;
import devaperu.pe.catalogo.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productoRepository;

    @Autowired
    private CategoryRepository categoriaRepository;

    @Override
    public List<Product> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Product guardar(Product producto) {
        Category categoria = categoriaRepository.findById(producto.getCategoria().getId())
                .orElse(null);
        if (categoria == null) {
            categoria = categoriaRepository.save(producto.getCategoria());
        }
        producto.setCategoria(categoria);
        return productoRepository.save(producto);
    }

    @Override
    public Product actualizar(Product producto) {
        Category categoria = categoriaRepository.findById(producto.getCategoria().getId())
                .orElse(null);
        if (categoria == null) {
            categoria = categoriaRepository.save(producto.getCategoria());
        }
        producto.setCategoria(categoria);
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Product> listarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
