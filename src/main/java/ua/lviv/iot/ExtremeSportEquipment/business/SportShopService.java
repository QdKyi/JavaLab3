package ua.lviv.iot.ExtremeSportEquipment.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.SportShopRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.SportShop;

@Service
public class SportShopService {

    @Autowired
    private SportShopRepository sportShopRepository;

    public SportShop findSportShop(Integer id) {
        return sportShopRepository.findById(id).orElse(null);
    }

    public List<SportShop> findAllSportShops() {
        return sportShopRepository.findAll();
    }

    public void deleteSportShop(Integer id) {
        sportShopRepository.deleteById(id);
    }
    
    public void updateSportShop(Integer id, SportShop sportShop) {
        sportShop.setId(id);
        sportShopRepository.save(sportShop);
    }
    
    public SportShop createSportShop(SportShop sportShop) {
        return sportShopRepository.save(sportShop);
    }

}
