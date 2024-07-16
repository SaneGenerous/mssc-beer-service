package tp.msk.msscbeerservice.events;

import lombok.NoArgsConstructor;
import tp.msk.msscbeerservice.web.model.BeerDTO;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
