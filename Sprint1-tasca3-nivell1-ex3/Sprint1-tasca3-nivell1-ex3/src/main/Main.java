package main;

//should be used with try and catch!
import java.io.*;
import java.util.*;


public class Main {

    public static void main (String [ ] args) throws IOException {

        final String enunName = "Type in your name:";
        final String enunStart = "Answer the capital of each country. We will play 10 rounds.";
        final String fileCountriesPath = "C:\\Users\\marca\\Desktop\\countries.txt";
        final String fileScoresPath = "C:\\Users\\marca\\Desktop\\scores.txt";
        final Scanner sc = new Scanner(System.in);
        final String userName;
        int userPoints=0;
        HashMap<String,String> countriesList = new HashMap<>();

        File mFile = new File(fileCountriesPath);
        BufferedReader mBuffer = new BufferedReader(new FileReader(mFile));

        //method reading the file and filling hasMap
        countriesList = fileReading(mBuffer);

        //getting an Arraylist of keys-names --> transforming hashmap into array in order to have indexes
        ArrayList<String> countriesNames = new ArrayList<>(countriesList.keySet());

        System.out.println(enunName);
        userName = sc.nextLine();
        System.out.println(enunStart);

        Random rand = new Random();
        int i =0;
        int j = 10;
        for (i=0; i<j; i++){

            int randNum = rand.nextInt(countriesList.size());
            String randCountry = countriesNames.get(randNum);
            final String enunQuestion = "What's the capital of " + randCountry;
            System.out.println(enunQuestion);
            String userAnswer = sc.nextLine();

            if (countriesList.get(randCountry).equalsIgnoreCase(userAnswer)){
                userPoints++;
                System.out.println("Correct answer!");
            }else{
                System.out.println("Wrong answer!");
                System.out.println("The correct answer is: " + countriesList.get(randCountry));
            }
        }

        System.out.println("\nFinnish!");
        System.out.println("Player: " + userName + "\nscore: " + userPoints);

        creatingFile(fileScoresPath);
        writtingScore(userName,userPoints,fileScoresPath);

    }//closes main


    public static HashMap<String,String> fileReading(BufferedReader mBuffer) throws IOException {
        String readingLines;
        String keyWord;
        String valueWord;
        HashMap<String,String> countriesList = new HashMap<>();

        //if We don't put readinglines.isEmpty() crashes because its reading last line and then substring gets negative values.
        // readingLines.isEmpty() could be used as an if-statement
        while((readingLines = mBuffer.readLine())!=null && !(readingLines.isEmpty())){

            int whiteSpacePlace = readingLines.indexOf(" ");
            keyWord = readingLines.toLowerCase().substring(0,whiteSpacePlace);
            valueWord = readingLines.toLowerCase().substring(whiteSpacePlace+1);

            countriesList.put(keyWord,valueWord);
        }
        return countriesList;
    }

    public static void creatingFile (String mFilePath){
        try {
            File mFileScores = new File(mFilePath);
            if (mFileScores.createNewFile()) {
                System.out.println("File created: " + mFileScores.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: We couldn't create or read current file.");
        }
    }

    public static void writtingScore(String userName, int userScore, String mFilePath) throws IOException {
        FileWriter mWriter = null;
        try {
            mWriter = new FileWriter(mFilePath);
            mWriter.write(userName + " - Score: " + userScore);

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: We couldn't write current file. ");
        } finally {
            mWriter.close();
        }

    }


}//closes class


