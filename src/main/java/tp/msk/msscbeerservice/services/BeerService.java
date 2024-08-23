package tp.msk.msscbeerservice.services;

import org.springframework.data.domain.PageRequest;
import tp.sfg.brewery.model.BeerDTO;
import tp.sfg.brewery.model.BeerPagedList;
import tp.sfg.brewery.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDTO getBeerById(UUID beerId, Boolean showInventoryOnHand);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeerById(UUID beerId, BeerDTO beerDTO);

    BeerDTO getBeerByUpc(String upc);
}
