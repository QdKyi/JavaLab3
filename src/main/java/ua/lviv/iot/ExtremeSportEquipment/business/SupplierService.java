package ua.lviv.iot.ExtremeSportEquipment.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.ExtremeSportEquipment.dataAccess.SupplierRepository;
import ua.lviv.iot.ExtremeSportEquipment.model.Supplier;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier findSupplier(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

    public void updateSupplier(Integer id, Supplier supplier) {
        supplier.setId(id);
        supplierRepository.save(supplier);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

}
