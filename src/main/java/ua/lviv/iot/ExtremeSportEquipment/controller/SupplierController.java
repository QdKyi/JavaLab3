package ua.lviv.iot.ExtremeSportEquipment.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.ExtremeSportEquipment.business.SupplierService;
import ua.lviv.iot.ExtremeSportEquipment.model.Supplier;

@RequestMapping("/supplier")
@RestController
public class SupplierController {
    private AtomicInteger counter = new AtomicInteger();

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers() {
        return new LinkedList<Supplier>(supplierService.getAll());
    }

    @GetMapping(path = "/{id}")
    public Supplier getSupplier(final @PathVariable("id") Integer id) {
        return supplierService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSupplier(final @PathVariable("id") Integer id) {
        if (getSupplier(id) != null) {
            supplierService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Supplier> updateSupplier(final @PathVariable("id") Integer id,
            final @RequestBody Supplier supplier) {
        Supplier previousSupplier = getSupplier(id);
        if (previousSupplier != null) {
            Supplier SupplierToReturn = new Supplier(previousSupplier.getSupplierName(),
                    previousSupplier.getSupplierCountry());
            SupplierToReturn.setId(id);
            supplierService.update(supplier);
            return ResponseEntity.ok(SupplierToReturn);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Supplier createSupplier(final @RequestBody Supplier supplier) {
        supplier.setId(counter.incrementAndGet());
        supplierService.add(supplier);
        return supplier;
    }

}
