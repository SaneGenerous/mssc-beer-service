package tp.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import tp.sfg.brewery.model.BeerDTO;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
