package br.com.auto.electrical.repository;

import br.com.auto.electrical.model.entity.ServiceCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCarRepository extends JpaRepository<ServiceCarEntity, Long> {
}
