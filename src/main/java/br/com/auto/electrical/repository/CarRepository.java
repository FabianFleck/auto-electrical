package br.com.auto.electrical.repository;

import br.com.auto.electrical.model.entity.CarEntity;
import br.com.auto.electrical.model.enumeration.CarColorEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    boolean existsByPlate(String plate);

    @Query("SELECT car FROM CarEntity car WHERE " +
            "(:id IS NULL OR car.id = :id) AND " +
            "(:plate IS NULL OR LOWER(car.plate) LIKE LOWER(CONCAT('%', :plate, '%'))) AND " +
            "(:color IS NULL OR car.color = :color) AND " +
            "(:model IS NULL OR LOWER(car.model) LIKE LOWER(CONCAT('%', :model, '%'))) AND " +
            "(:year IS NULL OR car.year = :year) AND " +
            "(:customerId IS NULL OR car.customer.id = :customerId)")
    Page<CarEntity> findByFilters(@Param("id") Long id,
                                  @Param("plate") String plate,
                                  @Param("color") CarColorEnum color,
                                  @Param("model") String model,
                                  @Param("year") Integer year,
                                  @Param("customerId") Long customerId,
                                  Pageable pageable);
}
