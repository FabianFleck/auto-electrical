package br.com.auto.electrical.model.entity;

import br.com.auto.electrical.model.enumeration.CarColorEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plate;
    @Enumerated(EnumType.STRING)
    @Column(name = "color", nullable = false)
    private CarColorEnum color;
    private String model;
    @Column(name = "car_year", nullable = false)
    private Integer year;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private CustomerEntity customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public CarColorEnum getColor() {
        return color;
    }

    public void setColor(CarColorEnum color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(id, carEntity.id) && Objects.equals(plate, carEntity.plate) && color == carEntity.color && Objects.equals(model, carEntity.model) && Objects.equals(year, carEntity.year) && Objects.equals(creationDate, carEntity.creationDate) && Objects.equals(updateDate, carEntity.updateDate) && Objects.equals(customer, carEntity.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plate, color, model, year, creationDate, updateDate, customer);
    }
}
