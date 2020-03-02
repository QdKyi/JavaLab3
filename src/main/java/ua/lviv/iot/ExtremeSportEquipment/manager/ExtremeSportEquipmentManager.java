package ua.lviv.iot.ExtremeSportEquipment.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;
import ua.lviv.iot.ExtremeSportEquipment.model.SportType;

public class ExtremeSportEquipmentManager {

    private List<AbstractExtremeSportEquipment> equipmentList = new LinkedList<>();

    public ExtremeSportEquipmentManager(List<AbstractExtremeSportEquipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public ExtremeSportEquipmentManager() {
    }

    public void addEquipment(AbstractExtremeSportEquipment addedObject) {
        this.equipmentList.add(addedObject);
    }

    public void addEquipment(List<AbstractExtremeSportEquipment> addedObjects) {
        this.equipmentList.addAll(addedObjects);
    }

    public List<AbstractExtremeSportEquipment> findBySportType(SportType sportType) {
        List<AbstractExtremeSportEquipment> foundItems = new LinkedList<>();

        for (AbstractExtremeSportEquipment equipment : equipmentList) {

            if (equipment.getSportType() == sportType) {
                foundItems.add(equipment);
            }

        }

        return foundItems;
    }

}
