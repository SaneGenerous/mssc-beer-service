package tp.msk.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import tp.msk.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
