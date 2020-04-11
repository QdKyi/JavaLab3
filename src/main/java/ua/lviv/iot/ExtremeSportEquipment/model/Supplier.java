package ua.lviv.iot.ExtremeSportEquipment.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"supplier\"")
public class Supplier {
    private String supplierName;
    private String supplierCountry;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("supplier")
    private Set<Kayak> equipment;

    public Supplier(String supplierName, String supplierCountry) {
        this.supplierName = supplierName;
        this.supplierCountry = supplierCountry;
    }
    
    public Supplier() {
        
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Kayak> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Kayak> equipment) {
        this.equipment = equipment;
    }
    
    

}
