package ua.lviv.iot.ExtremeSportEquipment.model;

public class Paracord extends AbstractExtremeSportEquipment {

    public Paracord(double priceInUAH, SportType sportType) {
        super(priceInUAH, sportType);
    }

    public Paracord(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName);
    }

}
