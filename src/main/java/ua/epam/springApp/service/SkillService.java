package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springApp.exception.EntityNotFoundException;
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
        Skill skill = skillRepo.get(id);
        if (skill == null) {
            throw new EntityNotFoundException();
        }
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> list = skillRepo.getAll();
        if (list.size() == 0) {
            throw new EntityNotFoundException();
        }
        return list;
    }

    @Override
    public boolean update(Skill entity) {
        boolean updated = skillRepo.update(entity);
        if (!updated) {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    @Override
    public Skill remove(Long id) {
        Skill skill = skillRepo.remove(id);
        if (skill == null) {
            throw new EntityNotFoundException();
        }
        return skill;
    }
}
