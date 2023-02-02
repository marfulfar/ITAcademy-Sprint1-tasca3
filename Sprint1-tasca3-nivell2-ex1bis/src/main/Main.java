package main;

import restaurant.Restaurant;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashSet<Restaurant> restList = new HashSet<>();
        Restaurant rest1 = new Restaurant("pizza",8);
        Restaurant rest2 = new Restaurant("burguer",6);
        Restaurant rest3 = new Restaurant("pizza",10);

        //Adding restaurants for testing. Adding rest1 two times to check nfor duplicates
        restList.add(rest1);
        restList.add(rest1);
        restList.add(rest2);
        restList.add(rest3);

        //asking user for a restaurant, checking if it's duplicate and inserting it if not
        insertedRestaurant(restList);

        //printing the final list
        System.out.println("\n***Printing the full list of Restaurants***");
        for (Restaurant rest:restList) {
            System.out.println(rest.getName() +" "+ rest.getRate());
        }






    }//closes main



    static public boolean insertedRestaurant(HashSet<Restaurant> restList){
        String userName;
        int userRate;
        boolean isDuplicate=false;
        final Scanner sc = new Scanner(System.in);

        System.out.println("Type in the restaurant's name");
        userName = sc.next();
        System.out.println("Type in the restaurant's rate");
        userRate = sc.nextInt();

        for (Restaurant rest:restList) {
            if (userName.equalsIgnoreCase(rest.getName()) && userRate == rest.getRate()) {
                System.out.println("this restaurant is already in the database");
                isDuplicate = true;
            }
        }
        if (!isDuplicate){
            restList.add(new Restaurant(userName,userRate));
            System.out.println("Restaurant: " + userName +" - Rate: "+ userRate + " inserted in the database!");
        }
         return isDuplicate;
    }



}//closes class