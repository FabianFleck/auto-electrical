package br.com.auto.electrical.model.entity;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_cars")
public class ServiceCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate date;
    private Integer guarantee;
    private BigDecimal totalValue;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    @Enumerated(EnumType.STRING)
    private ServiceCarStatusEnum status;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;
    @OneToMany(mappedBy = "serviceCar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCarEntity> products = new ArrayList<>();

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
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

    public ServiceCarStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ServiceCarStatusEnum status) {
        this.status = status;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public List<ProductCarEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCarEntity> products) {
        this.products = products;
    }

    // Método helper para associar produtos
    public void addProduct(ProductCarEntity product) {
        products.add(product);
        product.setServiceCar(this);
    }
}
