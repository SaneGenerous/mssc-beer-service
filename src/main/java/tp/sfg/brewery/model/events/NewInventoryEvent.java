package tp.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import tp.sfg.brewery.model.BeerDTO;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
