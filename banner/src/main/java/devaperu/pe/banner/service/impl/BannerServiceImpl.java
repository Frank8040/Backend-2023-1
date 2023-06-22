package devaperu.pe.banner.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devaperu.pe.banner.repository.BannerRepository;
import devaperu.pe.banner.service.BannerService;
import devaperu.pe.banner.entity.Banner;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public List<Banner> listar() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner guardar(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public Banner actualizar(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public Optional<Banner> listarPorId(Integer id) {
        return bannerRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        bannerRepository.deleteById(id);
    }
}
