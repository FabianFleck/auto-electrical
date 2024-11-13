package br.com.auto.electrical.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_cars")
public class ProductCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer quantity;
    private BigDecimal unitValue;
    private BigDecimal totalValue;
    @ManyToOne
    @JoinColumn(name = "service_car_id", nullable = false)
    private ServiceCarEntity serviceCar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigDecimal unitValue) {
        this.unitValue = unitValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public ServiceCarEntity getServiceCar() {
        return serviceCar;
    }

    public void setServiceCar(ServiceCarEntity serviceCar) {
        this.serviceCar = serviceCar;
    }
}