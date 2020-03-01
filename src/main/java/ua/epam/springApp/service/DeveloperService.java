package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springApp.exception.EntityNotFoundException;
import ua.epam.springApp.model.Developer;
import ua.epam.springApp.repository.GenericRepository;

import java.util.List;

@Service
public class DeveloperService implements GenericService<Developer, Long> {

    private GenericRepository<Developer, Long> developerRepo;

    @Autowired
    public DeveloperService(GenericRepository<Developer, Long> developerRepo) {
        this.developerRepo = developerRepo;
    }

    @Override
    public void add(Developer entity) {
        developerRepo.add(entity);
    }

    @Override
    public Developer get(Long id) {
        Developer developer = developerRepo.get(id);
        if (developer == null) {
            throw new EntityNotFoundException();
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> list = developerRepo.getAll();
        if (list.size() == 0) {
            throw new EntityNotFoundException();
        }
        return list;
    }

    @Override
    public boolean update(Developer entity) {
        boolean updated = developerRepo.update(entity);
        if (!updated) {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    @Override
    public Developer remove(Long id) {
        Developer developer = developerRepo.remove(id);
        if (developer == null) {
            throw new EntityNotFoundException();
        }
        return developer;
    }
}
