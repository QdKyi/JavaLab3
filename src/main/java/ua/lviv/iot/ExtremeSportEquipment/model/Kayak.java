package ua.lviv.iot.ExtremeSportEquipment.model;

public class Kayak extends AbstractExtremeSportEquipment {

    public Kayak(double priceInUAH, SportType sportType) {
        super(priceInUAH, sportType);
    }

    public Kayak(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName);
    }

}
