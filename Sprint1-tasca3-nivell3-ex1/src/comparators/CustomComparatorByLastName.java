package comparators;

import person.Person;

import java.util.Comparator;

public class CustomComparatorByLastName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}
