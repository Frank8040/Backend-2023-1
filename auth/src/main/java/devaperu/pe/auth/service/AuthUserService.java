package devaperu.pe.auth.service;

import devaperu.pe.auth.dto.AuthUserDto;
import devaperu.pe.auth.entity.AuthUser;
import devaperu.pe.auth.entity.TokenDto;

public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);

    public TokenDto login(AuthUserDto authUserDto);

    public TokenDto validate(String token);
}