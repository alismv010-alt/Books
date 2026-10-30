package Book.mapStruct;

import Book.dto.BookDTO;
import Book.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {

    BookDTO toDTO (BookEntity entity);
    @Mapping(target="description", qualifiedByName = "trimDescription")
    BookEntity toEntity (BookDTO dto);
    @Named("trimDescription")
    default String trimDescription (String description) {
        return (description==null || description.isBlank())
                ? null
                : description.trim();
    }
}
