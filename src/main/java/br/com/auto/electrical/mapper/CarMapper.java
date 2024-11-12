package br.com.auto.electrical.mapper;

import br.com.auto.electrical.model.entity.CarEntity;
import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.request.CarRequest;
import br.com.auto.electrical.model.response.CarResponse;
import br.com.auto.electrical.model.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponse toResponse(CarEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(localDateTimeNow())")
    @Mapping(target = "updateDate", expression = "java(localDateTimeNow())")
    CarEntity toEntity(CarRequest request, CustomerEntity customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updateDate", expression = "java(localDateTimeNow())")
    void toEntity(CarRequest request, @MappingTarget CarEntity entity);

    @Named("localDateTimeNow")
    default LocalDateTime localDateTimeNow() {
        return LocalDateTime.now();
    }
}
