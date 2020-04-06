package ua.lviv.iot.ExtremeSportEquipment.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;

@Repository
public interface KayakRepository extends JpaRepository<Kayak, Integer> {

}
