package main;

import month.Month;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        final ArrayList<Month> monthsList = new ArrayList<Month>();
        monthsList.add(new Month("January"));
        monthsList.add(new Month("February"));
        monthsList.add(new Month("March"));
        monthsList.add(new Month("April"));
        monthsList.add(new Month("May"));
        monthsList.add(new Month("June"));
        monthsList.add(new Month("July"));
        monthsList.add(new Month("September"));
        monthsList.add(new Month("October"));
        monthsList.add(new Month("November"));
        monthsList.add(new Month("December"));

        //printing the list to be able to compare later
        for (Month month:monthsList) {System.out.println(month.getMonthName());}

        Month august = new Month("August");
        monthsList.add(7,august);

        //printing the list with august included
        System.out.println("***printing list with august added`on the 8th position***");
        for (Month month:monthsList) {System.out.println(month.getMonthName());}

        //convert ArrayList in HashSet, adding august and printing full list and size to show it won't accept duplicates
        System.out.println("***printing hashset to check no duplicates***");
        HashSet<Month> monthsSet = new HashSet(monthsList);
        monthsSet.add(august);
        for (Month month:monthsSet) {System.out.println(month.getMonthName());}
        System.out.println("***Printing sizes of array and hashset to check for not duplicates***");
        System.out.println(monthsList.size());
        System.out.println(monthsSet.size());

        //loop through for loop with ArrayList
        System.out.println("***printing through for loop***");
        for (Month month:monthsList) {System.out.println(month.getMonthName());}

        //just to give some space to the console
        System.out.println("\n");

        //loop through iterator with HashSet
        System.out.println("***printing through iterator loop***");
        Iterator<Month> it = monthsSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getMonthName());
        }





    }//closes main


}//closes class