package main;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList ();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println("List 1: " + list1);

        //for loop decrementing to insert list1 on list2 backwards
        List<Integer> list2 = new ArrayList ();
        int i = 0;
        int j = list1.size();
        for (i = j; i>0; i--) {
            list2.add(list1.get(i-1));
        }
        //printing to make sure list2 is backwards
        System.out.println("List 2: " + list2);

        //using list iterator to add list 2 to list 1
        ListIterator<Integer> it = list1.listIterator();
        while(it.hasNext()) {
            list2.add(it.next());
        }

        System.out.println("Both Lists together using list iterator: " + list2);


    }//closes main



}//closes class