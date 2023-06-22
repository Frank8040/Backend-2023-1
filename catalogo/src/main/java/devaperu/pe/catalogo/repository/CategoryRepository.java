package devaperu.pe.catalogo.repository;

import devaperu.pe.catalogo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
