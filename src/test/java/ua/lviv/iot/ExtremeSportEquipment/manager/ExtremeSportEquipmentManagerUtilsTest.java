package ua.lviv.iot.ExtremeSportEquipment.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.ExtremeSportEquipment.model.SortType;

public class ExtremeSportEquipmentManagerUtilsTest extends BaseExtremeSportEquipmentManagerTest {

    private ExtremeSportEquipmentManager extremeSportEquipmentManager;

    @BeforeEach
    public void setUp() {
        extremeSportEquipmentManager = new ExtremeSportEquipmentManager();
        extremeSportEquipmentManager.addEquipment(equipmentList);
    }

    @Test
    public void testStaticSortEquipmentByPrice() {
        ExtremeSportEquipmentManagerUtils.sortEquipmentByPrice(equipmentList, SortType.ASCENDING);

        assertEquals(900, equipmentList.get(0).getPriceInUAH());
        assertEquals(1100, equipmentList.get(1).getPriceInUAH());
        assertEquals(2500, equipmentList.get(2).getPriceInUAH());

    }

    @Test
    public void testSortEquipmentByWeight() {
        ExtremeSportEquipmentManagerUtils ManagerUtils = new ExtremeSportEquipmentManagerUtils();

        ManagerUtils.sortEquipmentByWeight(equipmentList, SortType.ASCENDING);

        assertEquals(2, equipmentList.get(0).getWeight());
        assertEquals(3, equipmentList.get(1).getWeight());
        assertEquals(100, equipmentList.get(2).getWeight());
    }

    @Test
    public void anonymousClassSortTest() {
        ExtremeSportEquipmentManagerUtils.sortByProducerName(equipmentList, SortType.ASCENDING);

        assertEquals("Arman inc.", equipmentList.get(0).getProducerName());
        assertEquals("Arman inc.", equipmentList.get(1).getProducerName());
        assertEquals("Baydarku vid Pavlushi", equipmentList.get(2).getProducerName());
    }

    @Test
    void testSortByYearOfProductionusingLambda() {
        ExtremeSportEquipmentManagerUtils.sortByYearOfProductionUsingLambda(equipmentList, SortType.ASCENDING);

        assertEquals(10, equipmentList.get(0).getYearOfProduction());
        assertEquals(11, equipmentList.get(1).getYearOfProduction());
        assertEquals(15, equipmentList.get(2).getYearOfProduction());
    }

}