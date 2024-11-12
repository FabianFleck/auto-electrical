package br.com.auto.electrical.repository;

import br.com.auto.electrical.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    boolean existsByPlate(String plate);
}
