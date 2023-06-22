package devaperu.pe.banner.service;

import java.util.List;
import java.util.Optional;

import devaperu.pe.banner.entity.Banner;

public interface BannerService {
    public List<Banner> listar();

    public Banner guardar(Banner banner);

    public Banner actualizar(Banner banner);

    public Optional<Banner> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
