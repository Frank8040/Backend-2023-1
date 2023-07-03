package devaperu.pe.auth.service.impl;

import devaperu.pe.auth.dto.AuthUserDto;
import devaperu.pe.auth.entity.AuthUser;
import devaperu.pe.auth.entity.TokenDto;
import devaperu.pe.auth.repository.AuthRepository;
import devaperu.pe.auth.security.JwtProvider;
import devaperu.pe.auth.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;

    @Override
    public List<AuthUser> list() {
        return authRepository.findAll();
    }

    @Override
    public Optional<AuthUser> listarPorId(Integer id) {
        return authRepository.findById(id);
    }

    @Override
    public AuthUser save(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authRepository.findByUserName(authUserDto.getUserName());
        if (user.isPresent())
            return null;
        String password = passwordEncoder.encode(authUserDto.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(authUserDto.getUserName())
                .password(password)
                .correo(authUserDto.getCorreo())
                .build();

        return authRepository.save(authUser);
    }

    @Override
    public TokenDto login(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authRepository.findByUserName(authUserDto.getUserName());
        if (!user.isPresent())
            return null;
        if (passwordEncoder.matches(authUserDto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }

    @Override
    public void logout(String token) {
        if (jwtProvider.validate(token)) {
            jwtProvider.addToInvalidTokens(token);
            System.out.println("Token invalidado y agregado a la lista de tokens inválidos: " + token);
        } else {
            System.out.println("Token inválido: " + token);
        }
    }

    @Override
    public TokenDto validate(String token) {
        if (!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if (!authRepository.findByUserName(username).isPresent())
            return null;

        return new TokenDto(token);
    }
}
