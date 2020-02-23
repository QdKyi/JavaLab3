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
	public void createEquipment () {
		
		equipmentList = new LinkedList<AbstractExtremeSportEquipment>();
		
		equipmentList.add(new Paracord(1100, SportType.ICECLIMBING));
		equipmentList.add(new Kayak(2500, SportType.KAYAKING));
		equipmentList.add(new IceAxe(900, SportType.ICECLIMBING));
		
	}

}
