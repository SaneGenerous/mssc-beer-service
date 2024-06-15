package tp.msk.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.web.model.BeerDTO;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDTO beerDTO);
}
