package control;

import org.CodeForPizza.Employee;
import org.CodeForPizza.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {
        //Setup session factory
        try {
            Configuration cfg = new Configuration().configure();
            cfg.addAnnotatedClass(org.CodeForPizza.Person.class);
            cfg.addAnnotatedClass(org.CodeForPizza.Employee.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            SessionFactory sf = cfg.buildSessionFactory(builder.build());

            //Create session
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            Person person = new Person(1, "Kalle", "Karlsson");
            Employee employee = new Employee(2, "Pelle", "Svensson", "CodeforPizza", "2013-12-12");

            session.save(person);
            session.save(employee);

            //Commit transaction and close session
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
