package ua.epam.springApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.epam.springApp.model.Developer;
import ua.epam.springApp.service.DeveloperService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    private DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping(params = "id")
    public Developer get(@RequestParam long id) {
        return developerService.get(id);
    }

    @GetMapping
    public List<Developer> getAll() {
        return developerService.getAll();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Developer developer) {
        developerService.add(developer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Developer developer) {
        developerService.update(developer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity remove(@RequestParam long id) {
        developerService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
