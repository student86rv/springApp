package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springApp.model.Skill;
import ua.epam.springApp.repository.GenericRepository;

import java.util.List;

@Service
public class SkillService implements GenericService<Skill, Long> {

    private GenericRepository<Skill, Long> skillRepo;

    @Autowired
    public SkillService(GenericRepository<Skill, Long> skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public void add(Skill entity) {
        skillRepo.add(entity);
    }

    @Override
    public Skill get(Long id) {
        return skillRepo.get(id);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepo.getAll();
    }

    @Override
    public boolean update(Skill entity) {
        return skillRepo.update(entity);
    }

    @Override
    public Skill remove(Long id) {
        return skillRepo.remove(id);
    }
}
