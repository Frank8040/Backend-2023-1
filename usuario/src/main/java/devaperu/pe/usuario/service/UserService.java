package devaperu.pe.usuario.service;

import java.util.List;
import java.util.Optional;

import devaperu.pe.usuario.entity.User;

public interface UserService {
    public List<User> list();

    public User save(User usuario);

    public User update(User usuario);

    public Optional<User> listById(Integer id);

    public void deleteById(Integer id);
}
