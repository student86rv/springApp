package ua.epam.springApp.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.springApp.model.Account;
import ua.epam.springApp.model.AccountStatus;
import ua.epam.springApp.repository.GenericRepository;

import static org.junit.Assert.*;

public class AnnotationTest {

    @Test
    public void testTimedAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        GenericRepository<Account, Long> repo = (GenericRepository<Account, Long>) context.getBean("jdbcAccountRepo");

        Account account = new Account("vasya.pupkin@gmail.com", AccountStatus.ACTIVE);
        repo.add(account);
        long id = account.getId();

        Account account1 = repo.get(id);
        assertEquals(account, account1);

        repo.remove(id);
    }
}
