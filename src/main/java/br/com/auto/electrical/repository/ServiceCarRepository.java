package br.com.auto.electrical.repository;

import br.com.auto.electrical.model.entity.ServiceCarEntity;
import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ServiceCarRepository extends JpaRepository<ServiceCarEntity, Long> {

    @Query("SELECT service FROM ServiceCarEntity service WHERE " +
            "(:id IS NULL OR service.id = :id) AND " +
            "(:customerId IS NULL OR service.customer.id = :customerId) AND " +
            "(:carId IS NULL OR service.car.id = :carId) AND " +
            "(:description IS NULL OR LOWER(service.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
            "(:status IS NULL OR service.status = :status) AND " +
            "(:startDate IS NULL OR service.creationDate >= :startDate) AND " +
            "(:endDate IS NULL OR service.creationDate <= :endDate)")
    Page<ServiceCarEntity> findByFilters(
            @Param("id") Long id,
            @Param("customerId") Long customerId,
            @Param("carId") Long carId,
            @Param("description") String description,
            @Param("status") ServiceCarStatusEnum status,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            Pageable pageable
    );

}
