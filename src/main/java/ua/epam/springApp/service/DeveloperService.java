package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return developerRepo.get(id);
    }

    @Override
    public List<Developer> getAll() {
        return developerRepo.getAll();
    }

    @Override
    public boolean update(Developer entity) {
        return developerRepo.update(entity);
    }

    @Override
    public Developer remove(Long id) {
        return developerRepo.remove(id);
    }
}
