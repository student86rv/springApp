package ua.epam.springApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.epam.springApp.model.Skill;
import ua.epam.springApp.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping(params = "id")
    public Skill get(@RequestParam long id) {
        return skillService.get(id);
    }

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Skill skill) {
        skillService.add(skill);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Skill skill) {
        skillService.update(skill);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity remove(@RequestParam long id) {
        skillService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
