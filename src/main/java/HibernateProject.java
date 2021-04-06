import entity.Contract;
import entity.ContractLine;
import entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class HibernateProject {
    public static final String HIBERNATE_CONFIGURATION = "hibernate.cfg.xml";


    public HibernateProject() {
        //constructEntryController(entityManager()).run();
    }

/*    private EntryController constructEntryController(EntityManager entityManager) {
        InputReceiver receiver = new DefaultInputReceiver();
        OutputProducer output = new DefaultOutputProducer();
        AuthorService authorService = new AuthorService(new AuthorRepository(entityManager));
        BookService bookService = new BookService(new BookRepository(entityManager), authorService);

        AuthorController authorController = new AuthorController(authorService, receiver, output);
        BookController bookController = new BookController(bookService, authorService, receiver, output);
        return new EntryController(authorController, bookController, receiver, output);
    }*/

    public EntityManager getEntityManager() {
        SessionFactory sessionFactory = new Configuration()
                .configure(HIBERNATE_CONFIGURATION)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Contract.class)
                .addAnnotatedClass(ContractLine.class)
                //.addAnnotatedClass(Book.class)
                //.addAnnotatedClass(AuthorBiography.class)
                //.addAnnotatedClass(AuthorAlias.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }

}
