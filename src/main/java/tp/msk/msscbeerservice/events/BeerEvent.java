package tp.msk.msscbeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import tp.msk.msscbeerservice.web.model.BeerDTO;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -7521546138412211355L;

    private final BeerDTO beerDTO;
}
