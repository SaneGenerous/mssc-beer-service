package tp.msk.msscbeerservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.web.model.BeerDTO;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDtoWithInventory(Beer beer);
}
