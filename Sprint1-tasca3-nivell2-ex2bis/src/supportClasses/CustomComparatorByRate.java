package supportClasses;

import restaurant.Restaurant;

import java.util.Comparator;

public class CustomComparatorByRate implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant rest1, Restaurant rest2) {

        int compare = rest1.getRate() - rest2.getRate();

        return compare;
    }

}//closes class
