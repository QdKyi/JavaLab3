package ua.lviv.iot.ExtremeSportEquipment.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SportShop {

    private String shopName;
    private String locationInTown;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sport_shops", joinColumns = {
            @JoinColumn(name = "shop_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "equip_id", nullable = false) })

    @JsonIgnoreProperties("sportShops")
    private Set<Kayak> equipment;

    public SportShop(String shopName, String locationInTown) {
        this.shopName = shopName;
        this.locationInTown = locationInTown;
    }
    
    public SportShop() {
        
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocationInTown() {
        return locationInTown;
    }

    public void setLocationInTown(String locationInTown) {
        this.locationInTown = locationInTown;
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
