package ua.lviv.iot.ExtremeSportEquipment.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.KayakRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;

@Service
public class KayakService extends AbstractService<Kayak> {

    @Autowired
    private KayakRepository kayakRepository;

    @Override
    protected JpaRepository<Kayak, Integer> getRepository() {
        return kayakRepository;
    }

    public boolean checkForKayakExistence(Integer id) {
        return kayakRepository.existsById(id);
    }

}
