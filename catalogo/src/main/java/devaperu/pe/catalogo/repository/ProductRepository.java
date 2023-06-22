package devaperu.pe.catalogo.repository;

import devaperu.pe.catalogo.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
