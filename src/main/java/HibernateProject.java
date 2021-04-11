import entity.*;
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
                .addAnnotatedClass(AmountCode.class)
                .addAnnotatedClass(Contract.class)
                .addAnnotatedClass(ContractLine.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(EmployeeAmount.class)
                .addAnnotatedClass(EmployeeScheduleEntry.class)
                .addAnnotatedClass(EmployeeTimesheetEntry.class)
                .addAnnotatedClass(PositionCode.class)
                .addAnnotatedClass(ScheduleCode.class)
                .addAnnotatedClass(SchedulePatternLine.class)
                .addAnnotatedClass(ShiftCode.class)
                .addAnnotatedClass(ShiftLine.class)
                .addAnnotatedClass(TimeCode.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }

}
