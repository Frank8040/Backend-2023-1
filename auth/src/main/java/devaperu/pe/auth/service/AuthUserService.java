package devaperu.pe.auth.service;

import java.util.List;
import java.util.Optional;

import devaperu.pe.auth.dto.AuthUserDto;
import devaperu.pe.auth.entity.AuthUser;
import devaperu.pe.auth.entity.TokenDto;

public interface AuthUserService {

    public List<AuthUser> list();

    public Optional<AuthUser> listarPorId(Integer id);

    public AuthUser save(AuthUserDto authUserDto);

    public TokenDto login(AuthUserDto authUserDto);

    public void logout(String token);

    public TokenDto validate(String token);
}