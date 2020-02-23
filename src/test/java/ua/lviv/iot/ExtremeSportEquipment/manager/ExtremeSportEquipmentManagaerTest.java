package ua.lviv.iot.ExtremeSportEquipment.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import ua.lviv.iot.ExtremeSportEquipment.manager.ExtremeSportEquipmentManager;
import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;
import ua.lviv.iot.ExtremeSportEquipment.model.SportType;


class ExtremeSportEquipmentManagaerTest extends BaseExtremeSportEquipmentManagerTest {
	
	private ExtremeSportEquipmentManager extremeSportEquipmentManager;
	
	@BeforeEach
	public void setUp() {
		extremeSportEquipmentManager = new ExtremeSportEquipmentManager();
		extremeSportEquipmentManager.addTools(equipmentList);
	}
	
	@Test
	public void testFindWithPriceLoweThan() {
		List<AbstractExtremeSportEquipment> equipment = extremeSportEquipmentManager.findBySportType(SportType.ICECLIMBING);
		assertEquals(2, equipment.size());
		assertEquals(SportType.ICECLIMBING, equipment.get(0).getSportType());
		assertEquals(SportType.ICECLIMBING, equipment.get(1).getSportType());
		
	}

}
