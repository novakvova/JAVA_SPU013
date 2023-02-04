package utils;

import models.Question;
import models.QuestionItem;
import models.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HiberContext {
    private static SessionFactory sessionFactory; //контекст підключення до БД
    private HiberContext() {}
    public static  SessionFactory getSessionFactory() {
        if(sessionFactory==null) {
            //Читаємо конфігурацію
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuestionItem.class);
            //Реєструємо сорвіс на сонові нашого конфіга
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            //створюємо контекст до БД
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
