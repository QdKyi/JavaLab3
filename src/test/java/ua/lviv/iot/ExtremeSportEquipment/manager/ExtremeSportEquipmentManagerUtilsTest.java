package ua.lviv.iot.ExtremeSportEquipment.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.ExtremeSportEquipment.model.SortType;

public class ExtremeSportEquipmentManagerUtilsTest extends BaseExtremeSportEquipmentManagerTest {
	
	private ExtremeSportEquipmentManager extremeSportEquipmentManager;
	
	@BeforeEach
	public void setUp() {
		extremeSportEquipmentManager = new ExtremeSportEquipmentManager();
		extremeSportEquipmentManager.addTools(equipmentList);
	}
	
	@Test
	public void testSortByPriceAscending() {
		ExtremeSportEquipmentManagerUtils.sortByPrice(equipmentList, SortType.ASCENDING);
		
	}
	
	@Test
	public void testSortByYearOfProduction() {
		ExtremeSportEquipmentManagerUtils.sortByYearOfProduction(equipmentList, SortType.ASCENDING);
	}

}
