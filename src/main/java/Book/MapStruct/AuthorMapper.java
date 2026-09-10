package Book.MapStruct;

import Book.DTO.AuthorDTO;
import Book.Entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDTO (AuthorEntity entity);

    AuthorEntity toEntity (AuthorDTO dto);

}
