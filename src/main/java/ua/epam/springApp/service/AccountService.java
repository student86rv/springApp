package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springApp.model.Account;
import ua.epam.springApp.repository.GenericRepository;

import java.util.List;

@Service
public class AccountService implements GenericService<Account, Long>{

    private GenericRepository<Account, Long> accountRepo;

    @Autowired
    public AccountService(GenericRepository<Account, Long> accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public void add(Account entity) {
        accountRepo.add(entity);
    }

    @Override
    public Account get(Long id) {
        return accountRepo.get(id);
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.getAll();
    }

    @Override
    public boolean update(Account entity) {
        return accountRepo.update(entity);
    }

    @Override
    public Account remove(Long id) {
        return accountRepo.remove(id);
    }
}
