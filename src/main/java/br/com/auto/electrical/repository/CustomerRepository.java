package br.com.auto.electrical.repository;

import br.com.auto.electrical.model.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByDocument(String document);

    @Query("SELECT c FROM CustomerEntity c WHERE " +
            "(:id IS NULL OR c.id = :id) AND " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:document IS NULL OR c.document = :document) AND " +
            "(:phone IS NULL OR c.phone = :phone) AND " +
            "(:email IS NULL OR LOWER(c.email) = LOWER(:email))")
    Page<CustomerEntity> findByFilters(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("document") String document,
            @Param("phone") String phone,
            @Param("email") String email,
            Pageable pageable);
}
