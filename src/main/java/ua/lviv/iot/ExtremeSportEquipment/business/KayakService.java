package ua.lviv.iot.ExtremeSportEquipment.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.KayakRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;

@Service
public class KayakService {

    @Autowired
    private KayakRepository kayakRepository;

    public Kayak createKayak(Kayak kayak) {
        return kayakRepository.save(kayak);
    }

    public void deleteKayak(Integer id) {
        kayakRepository.deleteById(id);
    }

    public List<Kayak> findKayaks() {
        return kayakRepository.findAll();
    }

    public Kayak findKayak(Integer id) {
        return kayakRepository.findById(id).get();
    }

    public boolean checkForKayakExistence(Integer id) {
        return kayakRepository.existsById(id);
    }
    
    public Kayak updateKayak(Integer id, Kayak kayak) {
        Kayak previousKayak = kayakRepository.findById(id).get();
        Kayak kayakToReturn = new Kayak(previousKayak.getPriceInUAH(), previousKayak.getSportType(), 
                previousKayak.getWeight(), previousKayak.getYearOfProduction(), previousKayak.getProducerName());
        kayakToReturn.setId(id);
        kayak.setId(id);
        kayakRepository.save(kayak);
        return kayakToReturn;
    }

}
