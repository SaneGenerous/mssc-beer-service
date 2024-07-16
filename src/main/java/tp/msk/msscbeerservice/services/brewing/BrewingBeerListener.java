package tp.msk.msscbeerservice.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import tp.msk.msscbeerservice.config.JmsConfig;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.events.BrewBeerEvent;
import tp.msk.msscbeerservice.events.NewInventoryEvent;
import tp.msk.msscbeerservice.repositories.BeerRepository;
import tp.msk.msscbeerservice.web.model.BeerDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDTO beerDTO = event.getBeerDTO();

        Beer beer = beerRepository.getOne(beerDTO.getId());

        beerDTO.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDTO);

        log.debug("Brewed beer: {} : QOH: {}", beer.getMinOnHand(), beerDTO.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
