package ua.epam.springApp.context;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.springApp.AppConfig;
import ua.epam.springApp.model.Skill;
import ua.epam.springApp.service.SkillService;

import static org.junit.Assert.*;

public class SpringAppContextTest {

    @Test
    public void appContextTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SkillService skillService = (SkillService) context.getBean("skillService");

        Skill skill = new Skill("Spring Framework");
        skillService.add(skill);

        long id = skill.getId();
        Skill skill1 = skillService.get(id);

        assertEquals(skill, skill1);

        skillService.remove(id);
    }
}
