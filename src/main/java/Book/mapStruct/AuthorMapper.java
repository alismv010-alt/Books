package Book.mapStruct;

import Book.dto.AuthorDTO;
import Book.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO (AuthorEntity entity);

    AuthorEntity toEntity (AuthorDTO dto);

}
