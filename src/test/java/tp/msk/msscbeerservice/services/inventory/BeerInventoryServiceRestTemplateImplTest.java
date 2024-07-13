package tp.msk.msscbeerservice.services.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tp.msk.msscbeerservice.bootstrap.BeerLoader;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOnHandInventory() {
        //todo evolve to use Upc
        //Integer qoh = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);

        //System.out.println(qoh);
    }
}