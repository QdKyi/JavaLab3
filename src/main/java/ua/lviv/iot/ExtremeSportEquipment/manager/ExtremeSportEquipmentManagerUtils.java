package ua.lviv.iot.ExtremeSportEquipment.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.ExtremeSportEquipment.model.AbstractExtremeSportEquipment;
import ua.lviv.iot.ExtremeSportEquipment.model.SortType;

public class ExtremeSportEquipmentManagerUtils {

    protected static Comparator<AbstractExtremeSportEquipment> compareByProducerName 
    = new Comparator<AbstractExtremeSportEquipment>() {
        @Override
        public int compare(AbstractExtremeSportEquipment equipment1, AbstractExtremeSportEquipment equipment2) {

            return equipment1.getProducerName().compareTo(equipment2.getProducerName());
        }
    };

    public void sortEquipmentByWeight(final List<AbstractExtremeSportEquipment> equipmentList,
            final SortType sortType) {
        if (sortType == SortType.ASCENDING) {
            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getWeight));
        } else if (sortType == SortType.DESCENDING) {
            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getWeight).reversed());
            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getWeight).reversed());
        }
    }

    public static void sortEquipmentByPrice(final List<AbstractExtremeSportEquipment> equipmentList,
            final SortType sortType) {
        if (sortType == SortType.ASCENDING) {

            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getPriceInUAH));
        } else if (sortType == SortType.DESCENDING) {

            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getPriceInUAH).reversed());
            equipmentList.sort(Comparator.comparing(AbstractExtremeSportEquipment::getPriceInUAH).reversed());
        }
    }

    public static void sortByProducerName(final List<AbstractExtremeSportEquipment> equipmentList,
            final SortType sortType) {
        if (sortType == SortType.ASCENDING) {
            equipmentList.sort(compareByProducerName);
        }
        if (sortType == SortType.DESCENDING) {
            equipmentList.sort(compareByProducerName.reversed());
        }

    }

    static class EquipmentSorterByPrice implements Comparator<AbstractExtremeSportEquipment> {
        @Override
        public int compare(final AbstractExtremeSportEquipment equipment1,
                final AbstractExtremeSportEquipment equipment2) {
            return (int) (equipment1.getPriceInUAH() - equipment2.getPriceInUAH());
        }
    }

    class EquipmentSorterByWeight implements Comparator<AbstractExtremeSportEquipment> {
        @Override
        public int compare(final AbstractExtremeSportEquipment equipment1,
                final AbstractExtremeSportEquipment equipment2) {
            return equipment1.getWeight() - equipment2.getWeight();
        }
    }

    public Comparator<AbstractExtremeSportEquipment> getCompareByProducerName() {
        return compareByProducerName;
    }

    public void setCompareByProducerName(Comparator<AbstractExtremeSportEquipment> compareByProducerName) {
        ExtremeSportEquipmentManagerUtils.compareByProducerName = compareByProducerName;
    }

    public static void sortByYearOfProductionUsingLambda(final List<AbstractExtremeSportEquipment> equipmentList,
            final SortType sortType) {

        if (sortType == SortType.ASCENDING) {
            equipmentList.sort((o1, o2) -> o1.getYearOfProduction() - o2.getYearOfProduction());
        } else if (sortType == SortType.DESCENDING) {
            equipmentList.sort((o1, o2) -> o2.getYearOfProduction() - o1.getYearOfProduction());
        }
    }

}
