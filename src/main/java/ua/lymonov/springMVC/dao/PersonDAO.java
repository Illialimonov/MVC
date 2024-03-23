package ua.lymonov.springMVC.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import  ua.lymonov.springMVC.models.Person;

@Component
public class PersonDAO {

    @Autowired
    private PersonDAO personDAO;
    private static int PEOPLE_COUNT;
    private List<Person> db;

    {
        db = new ArrayList<>();
        db.add(new Person(++PEOPLE_COUNT, "Tom", 228, "pochta@gmail.com"));
        db.add(new Person(++PEOPLE_COUNT, "Vasya", 28, "pochta1@gmail.com"));
        db.add(new Person(++PEOPLE_COUNT, "Ilia", 23, "pochta2@gmail.com"));
        db.add(new Person(++PEOPLE_COUNT, "Som", 13, "pochta3@gmail.com"));
        ArrayList<String> change = new ArrayList<>();

    }

    public Person show(int id) {
        return db.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public List<Person> index(){
        return db;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        db.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setEmail(person.getEmail());

    }

    public void delete(int id) {
        db.removeIf(p -> p.getId()==id);
    }
}
