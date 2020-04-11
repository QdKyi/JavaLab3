package ua.lviv.iot.ExtremeSportEquipment.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public abstract class AbstractExtremeSportEquipment {

    @Column(name = "price_in_uah")
    private double priceInUAH;
    @Enumerated(EnumType.STRING)
    private SportType sportType;
    private int weight;
    private int yearOfProduction;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties("equipment")
    protected Supplier supplier;

    private String producerName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToMany(mappedBy = "equipment")
    @JsonIgnoreProperties("equipment")
    private Set<SportShop> sportShops;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public AbstractExtremeSportEquipment() {
        
    }

    public AbstractExtremeSportEquipment(double priceInUAH, SportType sportType) {
        super();
        this.priceInUAH = priceInUAH;
        this.sportType = sportType;
    }

    public AbstractExtremeSportEquipment(double priceInUAH, SportType sportType, int weight, int yearOfProduction,
            String producerName, Supplier supplier) {
        super();
        this.priceInUAH = priceInUAH;
        this.sportType = sportType;
        this.weight = weight;
        this.yearOfProduction = yearOfProduction;
        this.producerName = producerName;
        this.supplier = supplier;
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
        return "Price = " + getPriceInUAH() + ", Weight = " + getWeight() + ", Sport type = " + getSportType()
                + ", Year of Production = " + getYearOfProduction() + ", Producer name = " + getProducerName();
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<SportShop> getSportShops() {
        return sportShops;
    }

    public void setSportShops(Set<SportShop> sportShops) {
        this.sportShops = sportShops;
    }

}
