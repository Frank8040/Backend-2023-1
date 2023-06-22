package devaperu.pe.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devaperu.pe.usuario.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
