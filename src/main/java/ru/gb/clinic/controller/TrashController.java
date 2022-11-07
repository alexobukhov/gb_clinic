package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gb.clinic.model.Trash;
import ru.gb.clinic.service.TrashService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class TrashController {

    @Autowired
    TrashService trashService;

    @GetMapping(name = "/trash/{id}", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Trash getProduct(@PathVariable Long id) {
        return trashService.get(id);
    }

    @GetMapping(name = "/trash", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public List<Trash> getProductList() {
        return trashService.getAll();
    }

    @PostMapping(name = "/trash/", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public Trash addProduct(Trash trash) {
        return trashService.save(trash);
    }

    @GetMapping(name = "/trash/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        trashService.delete(id);
    }
}
