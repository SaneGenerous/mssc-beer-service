package tp.msk.msscbeerservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.repositories.BeerRepository;
import tp.msk.msscbeerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {
    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234200019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA.name())
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("13.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers On The Bar")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("11.99"))
                    .build());

    }
}
