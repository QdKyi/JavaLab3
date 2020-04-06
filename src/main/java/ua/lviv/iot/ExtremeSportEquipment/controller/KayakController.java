package ua.lviv.iot.ExtremeSportEquipment.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.ExtremeSportEquipment.business.KayakService;
import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;

@RequestMapping("/kayaks")
@RestController
public class KayakController {
    private static AtomicInteger counter = new AtomicInteger();
    
    @Autowired
    private KayakService kayakService;

    @GetMapping
    public List<Kayak> getKayaks() {
        return new LinkedList<Kayak>(kayakService.findKayaks());
    }

    @GetMapping(path = "/{id}")
    public Kayak getKayak(final @PathVariable("id") Integer id) {
        return kayakService.findKayak(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Kayak> updateKayak(final @PathVariable("id") Integer id, final @RequestBody Kayak kayak) {
        if (kayakService.checkForKayakExistence(id)) {
            return ResponseEntity.ok(kayakService.updateKayak(id, kayak));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteKayak(final @PathVariable("id") Integer id) {
        if(kayakService.checkForKayakExistence(id)) {
            kayakService.deleteKayak(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Kayak createKayak(final @RequestBody Kayak kayak) {
        kayak.setId(counter.incrementAndGet());
        kayakService.createKayak(kayak);
        return kayak;
    }

}
