package devaperu.pe.catalogo.service;

import java.util.List;
import java.util.Optional;

import devaperu.pe.catalogo.entity.Category;

public interface CategoryService {
    public List<Category> listar();

    public Category guardar(Category categoria);

    public Category actualizar(Category categoria);

    public Optional<Category> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}