package tp.msk.msscbeerservice.events;

import lombok.*;
import tp.msk.msscbeerservice.web.model.BeerDTO;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -7521546138412211355L;

    private BeerDTO beerDTO;
}
