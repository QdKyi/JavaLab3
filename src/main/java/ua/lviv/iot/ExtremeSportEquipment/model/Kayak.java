package ua.lviv.iot.ExtremeSportEquipment.model;

import javax.persistence.Entity;

@Entity
public class Kayak extends AbstractExtremeSportEquipment {

    Kayak() {
        this(0, null, 0, 0, null, null);
    }

    public Kayak(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName, 
            Supplier supplier) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName, supplier);
    }
    
    

    public Kayak(double priceInUAH, SportType sportType, int weight, int yearOfProduction, String producerName) {
        super(priceInUAH, sportType, weight, yearOfProduction, producerName);
    }

    @Override
    public String toString() {
        return "IceAxe [PriceInUAH =" + getPriceInUAH() + ", SportType=" + getSportType() + ", Weight=" + getWeight()
                + ", YearOfProduction=" + getYearOfProduction() + ", ProducerName=" + getProducerName() + "]";
    }
}
