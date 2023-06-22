package devaperu.pe.usuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devaperu.pe.usuario.entity.User;
import devaperu.pe.usuario.repository.UserRepository;
import devaperu.pe.usuario.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User save(User userUser) {
        return userRepository.save(userUser);
    }

    @Override
    public User update(User userUser) {
        return userRepository.save(userUser);
    }

    @Override
    public Optional<User> listById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
