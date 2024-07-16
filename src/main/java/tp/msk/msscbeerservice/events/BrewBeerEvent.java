package tp.msk.msscbeerservice.events;

import tp.msk.msscbeerservice.web.model.BeerDTO;

public class BrewBeerEvent extends BeerEvent{
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
