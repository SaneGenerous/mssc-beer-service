package tp.msk.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tp.msk.msscbeerservice.config.JmsConfig;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.events.BrewBeerEvent;
import tp.msk.msscbeerservice.repositories.BeerRepository;
import tp.msk.msscbeerservice.services.inventory.BeerInventoryService;
import tp.msk.msscbeerservice.web.mappers.BeerMapper;

import java.util.List;



@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)  //every 5 seconds
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min OnHand is: {}", beer.getMinOnHand());
            log.debug("Inventory is: {}", invQOH);

            if (beer.getMinOnHand() >= invQOH){}
            jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
        });
    }
}
