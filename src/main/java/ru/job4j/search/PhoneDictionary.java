package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    
    public ArrayList<Person> find(String key) {
        Predicate<Person> hasName = x -> x.getName() != null;
        Predicate<Person> hasSurname = x -> x.getSurname() != null;
        Predicate<Person> hasAddress = x -> x.getAddress() != null;
        Predicate<Person> hasPhone = x -> x.getPhone() != null;
        Predicate<Person> combine = hasName.or(hasSurname).or(hasAddress).or(hasPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
