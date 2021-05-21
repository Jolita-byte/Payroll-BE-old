package lt.Payroll;

import lt.Payroll.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class HibernateProject {
    public static final String HIBERNATE_CONFIGURATION = "x-hibernate.cfg.xml";


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
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Schedule.class)
                .addAnnotatedClass(SchedulePatternLine.class)
                .addAnnotatedClass(Shift.class)
                .addAnnotatedClass(ShiftLine.class)
                .addAnnotatedClass(ActivityCode.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }

}
