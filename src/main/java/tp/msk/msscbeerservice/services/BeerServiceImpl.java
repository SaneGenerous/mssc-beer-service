package tp.msk.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.msk.msscbeerservice.domain.Beer;
import tp.msk.msscbeerservice.repositories.BeerRepository;
import tp.msk.msscbeerservice.web.controller.NotFoundException;
import tp.msk.msscbeerservice.web.mappers.BeerMapper;
import tp.msk.msscbeerservice.web.model.BeerDTO;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    @Override
    public BeerDTO getBeerById(UUID beerId) {

          return beerMapper.beerToBeerDto(
                  beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
          );

    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDTO))
        );
    }

    @Override
    public BeerDTO updateBeerById(UUID beerId, BeerDTO beerDTO) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
