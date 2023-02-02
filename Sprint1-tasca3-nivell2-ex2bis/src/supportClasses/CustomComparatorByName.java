package supportClasses;

import restaurant.Restaurant;

import java.util.Comparator;

public class CustomComparatorByName implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant rest1, Restaurant rest2) {
        int value;

        // Comparing customers
        int NameCompare = rest1.getName().compareTo(rest2.getName());
        int RateCompare = rest2.getRate().compareTo(rest1.getRate());

        // 2nd level comparison
        if(NameCompare == 0){
            value = RateCompare;
        }else{
            value = NameCompare;
        }

        return value;
    }

}//closes class

