package ua.lviv.iot.ExtremeSportEquipment.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.ExtremeSportEquipment.business.SportShopService;
import ua.lviv.iot.ExtremeSportEquipment.model.SportShop;

@RequestMapping("/sportshop")
@RestController
public class SportShopController {
    private AtomicInteger counter = new AtomicInteger();
    
    @Autowired
    private SportShopService sportShopService;
    
    @GetMapping
    public List<SportShop> getAllSportShops() {
        return new LinkedList<SportShop>(sportShopService.getAll());
    }
    
    @GetMapping(path = "/{id}")
    public SportShop getSportShop(final @PathVariable("id") Integer id) {
        return sportShopService.getById(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSportShop(final @PathVariable("id") Integer id) {
        if(getSportShop(id) != null) {
            sportShopService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<SportShop> updateSportShop(final @PathVariable("id") Integer id,
            final @RequestBody SportShop sportShop) {
        SportShop previousSportShop = getSportShop(id);
        if (previousSportShop != null) {
            SportShop sportShopToReturn = new SportShop(previousSportShop.getShopName(), 
                    previousSportShop.getLocationInTown());
            sportShopToReturn.setId(id);
            sportShopService.update(id,sportShop);
            return ResponseEntity.ok(sportShopToReturn);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public SportShop createSportShop(final @RequestBody SportShop sportShop) {
        sportShop.setId(counter.incrementAndGet());
        sportShopService.add(sportShop);
        return sportShop;
    }

}
