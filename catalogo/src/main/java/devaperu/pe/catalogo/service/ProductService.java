package devaperu.pe.catalogo.service;

import java.util.List;
import java.util.Optional;

import devaperu.pe.catalogo.entity.Product;

public interface ProductService {
    public List<Product> listar();

    public Product guardar(Product producto);

    public Product actualizar(Product producto);

    public Optional<Product> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
