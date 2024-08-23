package tp.sfg.brewery.model.events;

import lombok.*;
import tp.sfg.brewery.model.BeerDTO;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -7521546138412211355L;

    private BeerDTO beerDTO;
}
