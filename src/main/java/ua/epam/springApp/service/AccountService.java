package ua.epam.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springApp.exception.EntityNotFoundException;
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
        Account account = accountRepo.get(id);
        if (account == null) {
            throw new EntityNotFoundException();
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> list = accountRepo.getAll();
        if (list.size() == 0) {
            throw new EntityNotFoundException();
        }
        return list;
    }

    @Override
    public boolean update(Account entity) {
        boolean updated = accountRepo.update(entity);
        if (!updated) {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    @Override
    public Account remove(Long id) {
        Account account = accountRepo.remove(id);
        if (account == null) {
            throw new EntityNotFoundException();
        }
        return account;
    }
}
