package ua.lviv.iot.ExtremeSportEquipment.model;

public class Paracord extends AbstractExtremeSportEquipment {

    public Paracord(double priceInUAH, SportType sportType) {
        super(priceInUAH, sportType);
    }

    public Paracord(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName);
    }
    
    public String getHeaders() {
        return super.getHeaders();
    }

    public String toCSV() {
        return super.toCSV();
    }

    @Override
    public String toString() {
        return "IceAxe [PriceInUAH =" + getPriceInUAH() + ", SportType=" + getSportType() + ", Weight="
                + getWeight() + ", YearOfProduction=" + getYearOfProduction() + ", ProducerName="
                + getProducerName() + "]";
    }
}
