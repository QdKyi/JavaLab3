package ua.lviv.iot.ExtremeSportEquipment.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.SupplierRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.Supplier;

@Service
public class SupplierService extends AbstractService<Supplier> {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    protected JpaRepository<Supplier, Integer> getRepository() {
        return supplierRepository;
    }

}
