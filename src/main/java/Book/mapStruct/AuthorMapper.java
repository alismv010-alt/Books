package Book.mapStruct;

import Book.dto.AuthorDTO;
import Book.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses={BookMapper.class})
public interface AuthorMapper {

    AuthorDTO toDTO (AuthorEntity entity);

    AuthorEntity toEntity (AuthorDTO dto);

}
