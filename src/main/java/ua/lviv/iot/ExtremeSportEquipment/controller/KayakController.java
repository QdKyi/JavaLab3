package ua.lviv.iot.ExtremeSportEquipment.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
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

import ua.lviv.iot.ExtremeSportEquipment.model.Kayak;

@RequestMapping("/kayaks")
@RestController
public class KayakController {
    private static Map<Integer, Kayak> kayaks = new HashMap<>();
    private static AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public List<Kayak> getKayaks() {
        return new LinkedList<Kayak>(kayaks.values());
    }

    @GetMapping(path = "/{id}")
    public Kayak getKayak(final @PathVariable("id") Integer id) {
        return kayaks.get(id);
    }

    @PutMapping(path = "{id}")
    public Kayak putKayak(final @PathVariable("id") Integer id, final @RequestBody Kayak kayak) {
        kayak.setId(id);
        return kayaks.put(id, kayak);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteKayak(final @PathVariable("id") Integer id) {
        HttpStatus status = kayaks.remove(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Kayak createFlower(final @RequestBody Kayak kayak) {
        kayak.setId(counter.incrementAndGet());
        kayaks.put(kayak.getId(), kayak);
        return kayak;
    }

}
