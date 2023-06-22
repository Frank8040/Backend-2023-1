package devaperu.pe.banner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devaperu.pe.banner.entity.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
    
}
