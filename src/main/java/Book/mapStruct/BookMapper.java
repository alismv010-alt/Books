package Book.mapStruct;

import Book.dto.BookDTO;
import Book.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO (BookEntity entity);

    BookEntity toEntity (BookDTO dto);
}
