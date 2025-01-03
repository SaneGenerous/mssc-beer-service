package tp.msk.msscbeerservice.services.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tp.msk.msscbeerservice.config.ConfigFeignClient;
import tp.msk.msscbeerservice.services.inventory.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "inventory-service", fallback = InventoryServiceFeignClientFailover.class, configuration = ConfigFeignClient.class)
public interface InventoryServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
