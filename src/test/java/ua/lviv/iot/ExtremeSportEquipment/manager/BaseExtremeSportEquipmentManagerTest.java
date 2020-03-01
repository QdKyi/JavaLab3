package ua.lviv.iot.ExtremeSportEquipment.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;
import ua.lviv.iot.ExtremeSportEquipment.model.IceAxe;
import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;
import ua.lviv.iot.ExtremeSportEquipment.model.Paracord;
import ua.lviv.iot.ExtremeSportEquipment.model.SportType;

public abstract class BaseExtremeSportEquipmentManagerTest {

    protected List<AbstractExtremeSportEquipment> equipmentList;

    @BeforeEach
    public void createEquipment() {

        equipmentList = new LinkedList<AbstractExtremeSportEquipment>();

        equipmentList.add(new Paracord(1100, SportType.ICECLIMBING, 2, 15, "Arman inc."));
        equipmentList.add(new Kayak(2500, SportType.KAYAKING, 100, 11, "Baydarku vid Pavlushi"));
        equipmentList.add(new IceAxe(900, SportType.ICECLIMBING, 3, 10, "Arman inc."));

    }

}
