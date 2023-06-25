package devaperu.pe.mensaje.service;

import java.util.List;
import java.util.Optional;
import devaperu.pe.mensaje.entity.Mensaje;

public interface MensajeService {
    public List<Mensaje> list();
    public Mensaje save(Mensaje mensaje);
    public Mensaje update(Mensaje mensaje);
    public Optional<Mensaje> listById(Integer id);
    public void deleteById(Integer id);
}
