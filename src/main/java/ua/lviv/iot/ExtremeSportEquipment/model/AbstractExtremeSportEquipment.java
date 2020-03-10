package ua.lviv.iot.ExtremeSportEquipment.model;

public abstract class AbstractExtremeSportEquipment {

    private double priceInUAH;
    private SportType sportType;
    private int weight;
    private int yearOfProduction;
    private String producerName;

    public AbstractExtremeSportEquipment(double priceInUAH, SportType sportType) {
        super();
        this.priceInUAH = priceInUAH;
        this.sportType = sportType;
    }

    public AbstractExtremeSportEquipment(double priceInUAH, SportType sportType, int weight, int yearOfProduction,
            String producerName) {
        super();
        this.priceInUAH = priceInUAH;
        this.sportType = sportType;
        this.weight = weight;
        this.yearOfProduction = yearOfProduction;
        this.producerName = producerName;
    }
    
    public String getHeaders() {
        return "priceInUAH, weight, yearOfProduction, producerName, sportType";
    }
    
    public String toCSV() {
        return "Price = " + getPriceInUAH() + ", Weight = " + getWeight() + ", Sport type = "
                + getSportType() + ", Year of Production = " + getYearOfProduction() 
                + ", Producer name = " + getProducerName();
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

}
