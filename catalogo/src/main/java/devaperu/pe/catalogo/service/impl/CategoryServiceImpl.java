package devaperu.pe.catalogo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devaperu.pe.catalogo.entity.Category;
import devaperu.pe.catalogo.repository.CategoryRepository;
import devaperu.pe.catalogo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoriaRepository;

    @Override
    public List<Category> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Category guardar(Category categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Category actualizar(Category categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Category> listarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
