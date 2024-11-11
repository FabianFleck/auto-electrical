package br.com.auto.electrical.model.entity;

import br.com.auto.electrical.model.request.CustomerRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long document;
    private Long phone;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public CustomerEntity(CustomerRequest request) {
        this.name = request.name();
        this.document = request.document();
        this.phone = request.phone();
        this.email = request.email();
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public CustomerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(document, that.document) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(creationDate, that.creationDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, document, phone, email, creationDate, updateDate);
    }
}
