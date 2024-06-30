package tp.msk.msscbeerservice.services;

import tp.msk.msscbeerservice.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeerById(UUID beerId, BeerDTO beerDTO);
}
