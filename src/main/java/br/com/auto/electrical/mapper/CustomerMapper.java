package br.com.auto.electrical.mapper;

import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.request.CustomerUpdateRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toResponse(CustomerEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updateDate", expression = "java(localDateTimeNow())")
    void toEntity(CustomerUpdateRequest clientRequestDTO, @MappingTarget CustomerEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(localDateTimeNow())")
    @Mapping(target = "updateDate", expression = "java(localDateTimeNow())")
    CustomerEntity toEntity(CustomerRequest request);

    @Named("localDateTimeNow")
    default LocalDateTime localDateTimeNow() {
        return LocalDateTime.now();
    }
}