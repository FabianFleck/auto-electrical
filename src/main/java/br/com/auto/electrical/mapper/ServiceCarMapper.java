package br.com.auto.electrical.mapper;

import br.com.auto.electrical.model.entity.CarEntity;
import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.entity.ProductCarEntity;
import br.com.auto.electrical.model.entity.ServiceCarEntity;
import br.com.auto.electrical.model.request.ServiceCarProductRequest;
import br.com.auto.electrical.model.request.ServiceCarRequest;
import br.com.auto.electrical.model.response.ServiceCarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ServiceCarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "date", expression = "java(localDateNow())")
    @Mapping(target = "creationDate", expression = "java(localDateTimeNow())")
    @Mapping(target = "updateDate", expression = "java(localDateTimeNow())")
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "car", source = "car")
    ServiceCarEntity toEntity(ServiceCarRequest request, CustomerEntity customer, CarEntity car);

    @Named("localDateTimeNow")
    default LocalDateTime localDateTimeNow() {
        return LocalDateTime.now();
    }

    @Named("localDateNow")
    default LocalDate localDateNow() {
        return LocalDate.now();
    }

    ServiceCarResponse toResponse(ServiceCarEntity save);

    ProductCarEntity toProductEntity(ServiceCarProductRequest productRequest);
}
