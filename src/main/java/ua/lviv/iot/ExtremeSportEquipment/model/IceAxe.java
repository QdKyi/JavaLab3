package ua.lviv.iot.ExtremeSportEquipment.model;

public class IceAxe extends AbstractExtremeSportEquipment {

    public IceAxe(double priceInUAH, SportType sportType) {
        super(priceInUAH, sportType);
    }

    public IceAxe(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName);
    }

    @Override
    public String toString() {
        return "IceAxe [PriceInUAH =" + getPriceInUAH() + ", SportType=" + getSportType() + ", Weight="
                + getWeight() + ", YearOfProduction=" + getYearOfProduction() + ", ProducerName="
                + getProducerName() + "]";
    }

}
