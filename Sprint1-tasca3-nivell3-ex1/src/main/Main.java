package main;

import au.com.bytecode.opencsv.CSVReader;
import comparators.CustomComparatorByDNI;
import comparators.CustomComparatorByLastName;
import comparators.CustomComparatorByName;
import person.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

    final String filePath = "C:\\Users\\marca\\Desktop\\names_dni.csv";
    ArrayList<String> fieldsList = new ArrayList<>();
    ArrayList<Person> people = new ArrayList<>();
    boolean exit = false;

    readCSV(filePath,fieldsList);
    parseArray(fieldsList,people);

    do {
        switch (menu()) {
            case 1:
                insertPeople(people);
                break;
            case 2:
                orderPeopleByNameAZ(people);
                break;
            case 3:
                orderPeopleByNameZA(people);
                break;
            case 4:
                orderPeopleByLastNameAZ(people);
                break;
            case 5:
                orderPeopleByLastNameZA(people);
                break;
            case 6:
                orderPeopleByDNI19(people);
                break;
            case 7:
                orderPeopleByDNI91(people);
                break;
            case 0:
                System.out.println("Thank you for using this app!");
                exit = true;
                break;
        }
    } while (!exit);


    }//closes main

    private static void orderPeopleByDNI91(ArrayList<Person> people) {
        List<Person> orderedList = people.stream().sorted(new CustomComparatorByDNI()).collect(Collectors.toList());
        Collections.reverse(orderedList);
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void orderPeopleByDNI19(ArrayList<Person> people) {
        List<Person> orderedList = people.stream().sorted(new CustomComparatorByDNI()).collect(Collectors.toList());
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void orderPeopleByLastNameZA(ArrayList<Person> people) {
        List<Person> orderedList = people.stream().sorted(new CustomComparatorByLastName()).collect(Collectors.toList());
        Collections.reverse(orderedList);
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void orderPeopleByLastNameAZ(ArrayList<Person> people) {
        List<Person> orderedList = people.stream().sorted(new CustomComparatorByLastName()).collect(Collectors.toList());
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void orderPeopleByNameZA(ArrayList<Person> people) {
        List<Person> orderedList = people.stream().sorted(new CustomComparatorByName()).collect(Collectors.toList());
        Collections.reverse(orderedList);
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void orderPeopleByNameAZ(ArrayList<Person> people) {
        List<Person> orderedList =  people.stream().sorted(new CustomComparatorByName()).collect(Collectors.toList());
        System.out.println("__Name______Last_Name________DNI__");
        for (Person p:orderedList) {
            System.out.println(p.getName() +"    "+p.getLastName()+"    "+p.getDni());
        }
    }

    private static void insertPeople(ArrayList<Person> people) {
        Scanner sc = new Scanner(System.in);
        String userName="", userLastName="",userDNI="";

        System.out.println("Type in the name of the person:");
        userName = sc.next();
        System.out.println("Type in the last name of the person:");
        userLastName = sc.next();
        System.out.println("Type in the DNI of the person:");
        userDNI = sc.next();

        people.add(new Person(userName,userLastName,userDNI));

    }

    public static void readCSV (String filePath, ArrayList<String> fieldsList) throws IOException {

        FileReader myFileReader = new FileReader(filePath);
        CSVReader myReader = new CSVReader(myFileReader);
        String[] lines;

        while ((lines = myReader.readNext()) != null) {
            fieldsList.add(Arrays.asList(lines).toString());
        }

    }

    public static void parseArray(ArrayList<String> fieldsList, ArrayList<Person> people){
        for (String line:fieldsList) {

            int firstComa = line.indexOf(";");
            String userName = line.substring(1, firstComa).toLowerCase();
            int secondComa = line.lastIndexOf(";");
            String userLastName = line.substring(firstComa + 1, secondComa).toLowerCase();
            String userDNI = line.substring(secondComa + 1, line.length() - 1).toLowerCase();

            people.add(new Person(userName, userLastName, userDNI));
        }
    }

    public static byte menu(){
        Scanner sc = new Scanner(System.in);
        byte userOption;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 8;

        do {
            System.out.println("\nMain Menu");
            System.out.println("1. Insert Person");
            System.out.println("2. Show all people ordered by name (A-Z)");
            System.out.println("3. Show all people ordered by name (Z-A)");
            System.out.println("4. Show all people ordered by last name (A-Z)");
            System.out.println("5. Show all people ordered by last name (Z-A)");
            System.out.println("6. Show all people ordered by DNI (1-9)");
            System.out.println("7. Show all people ordered by DNI (9-1)");
            System.out.println("0. Exit the app.\n");
            userOption = sc.nextByte();
            if (userOption < MINIMUM || userOption > MAXIMUM) {
                System.out.println("Choose a valid option");
            }
        } while (userOption < MINIMUM || userOption > MAXIMUM);

        return userOption;
    }

}//closes class