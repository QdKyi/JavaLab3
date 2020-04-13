package ua.lviv.iot.ExtremeSportEquipment.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.SportShopRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.SportShop;

@Service
public class SportShopService extends AbstractService<SportShop> {

    @Autowired
    private SportShopRepository sportShopRepository;

    @Override
    protected JpaRepository<SportShop, Integer> getRepository() {
        return sportShopRepository;
    }

}
