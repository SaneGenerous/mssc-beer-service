package tp.msk.msscbeerservice.events;

import tp.msk.msscbeerservice.web.model.BeerDTO;

public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
