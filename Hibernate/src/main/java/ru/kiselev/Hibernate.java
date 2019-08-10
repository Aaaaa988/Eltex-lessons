package ru.kiselev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hibernate {
    public static void main(String[] args) {

        Collection <User> users = new ArrayList<> ();

        users.add(new User("Ivanov", "+79235467563"));
        users.add(new User("Petrov", "+79237345578"));

        User user1 = ((ArrayList <User>) users).get(0);
        User user2 = ((ArrayList <User>) users).get(1);

        Passport pass1 = new Passport("45 07","691152");
        Passport pass2 = new Passport("37 05", "033791");
        Adress adr = new Adress("Moscow", "Pushkina St.", "37/2");

        Collection<Lang> langs = new ArrayList <> ();

        langs.add(new Lang ("Java"));
        langs.add(new Lang ("C#"));

        Lang lang1 = ((ArrayList <Lang>) langs).get(0);
        Lang lang2 = ((ArrayList <Lang>) langs).get(1);


        pass1.setUser(user1);
        pass2.setUser(user2);
        adr.setOwner(users);
        lang1.setUsers(users);
        lang2.setUsers(users);


        user1.setLang(langs);
        user2.setLang(langs);
        user1.setAdress(adr);
        user2.setAdress(adr);
        user1.setPassport(pass1);
        user2.setPassport(pass2);

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }

        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(pass1);
        session.save(pass2);
        session.save(adr);
        session.save(lang1);
        session.save(lang2);
        session.getTransaction().commit();

        System.out.println("id" + "|  fio  " + "|    phone    " + "|id_adr" + "|id_pass" + "| id_lang  |");
        session.beginTransaction();
        List<User> usersOut = session.createQuery("FROM User").list();
        usersOut.forEach(u -> System.out.println(u.getId() + "  " +  u.getFio() + "  "  +  u.getPhone() + "    "
                + u.getAdress().getId() + "      "  + u.getPassport().getId() + "        " + u.indexLang()));
        List<Adress> adress = session.createQuery("FROM Adress").list();
        adress.forEach(u -> System.out.println("Adress: "+ u.getId()+", " +u.getCity() + ", " + u.getStreet()+ ", " + u.getBuilding()));
        System.out.println("Passports");
        System.out.println("id" + "|Serial|" + "Number|");
        List<Passport> passports = session.createQuery("FROM Passport").list();
        passports.forEach(u -> System.out.println(u.getId() + "  " + u.getSeries() + "  " + u.getNumber()));

        session.getTransaction().commit();
        session.close();

    }
}
