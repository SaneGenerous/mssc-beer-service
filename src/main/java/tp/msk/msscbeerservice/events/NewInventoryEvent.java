package tp.msk.msscbeerservice.events;

import lombok.NoArgsConstructor;
import tp.msk.msscbeerservice.web.model.BeerDTO;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
