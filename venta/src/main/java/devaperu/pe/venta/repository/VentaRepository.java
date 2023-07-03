package devaperu.pe.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devaperu.pe.venta.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta,Integer>{
  
}
