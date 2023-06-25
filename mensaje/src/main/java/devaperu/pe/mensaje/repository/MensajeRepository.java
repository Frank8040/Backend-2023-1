package devaperu.pe.mensaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devaperu.pe.mensaje.entity.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    
}
