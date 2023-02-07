package comparators;

import person.Person;

import java.util.Comparator;

public class CustomComparatorByDNI implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.valueOf(o1.getDni().substring(0,8)) - Integer.valueOf(o2.getDni().substring(0,8));
    }
}
