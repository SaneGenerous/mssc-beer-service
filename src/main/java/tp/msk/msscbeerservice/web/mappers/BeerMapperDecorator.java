package tp.msk.msscbeerservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.services.inventory.BeerInventoryService;
import tp.sfg.brewery.model.BeerDTO;

public class BeerMapperDecorator implements BeerMapper{
    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDTO beerToBeerDto(Beer beer) {
        return beerMapper.beerToBeerDto(beer);
    }

    @Override
    public Beer beerDtoToBeer(BeerDTO beerDTO) {
        return beerMapper.beerDtoToBeer(beerDTO);
    }

    @Override
    public BeerDTO beerToBeerDtoWithInventory(Beer beer) {
        BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);
        beerDTO.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return beerDTO;
    }
}
