package devaperu.pe.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devaperu.pe.venta.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta,Integer>{
    public List<Venta> findByUsuarioId(Integer usuarioid );
    public Venta findBySerie(String serie);
}
