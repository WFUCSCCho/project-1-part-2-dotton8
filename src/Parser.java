/***
 * @file: Parser.java
 * @description: This code creates the Parser class which takes an input and CSV file and returns a result file
 * @author: Douglas Otton
 * @date: September 26, 2024
 ***/

import java.io.*;
import java.util.Scanner;

public class Parser {

    // Create a BST tree of your class type (Note: Replace "Object" with your class type)
    private BST<Movies> myBST = new BST<>();

    public Parser(String filename) throws FileNotFoundException {
        clearFile();
        process(new File(filename));
    }

    // clears the result file so it is a blank file each run
    private void clearFile() {
        try (FileWriter fw = new FileWriter("./result.txt", false)) {
            fw.write("");
        } catch (IOException e) {
            System.exit(1);
        }
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input) throws FileNotFoundException {
        Scanner scnr = new Scanner(input);

        while(scnr.hasNextLine()) {
            String line = scnr.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] vals = line.split("\\s+");

            //call operate_BST method;
            operate_BST(vals);
        }
    }

    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST
    public void operate_BST(String[] command) throws FileNotFoundException {
        // Define the CSV file containing movie data
        File cvsFile = new File("/Users/douglas/IdeaProjects/project-1-part-2-dotton8/updatedFile.csv");
        String content;
        String[] myMovies = new String[10]; // Array to store movie attributes read from the CSV
        Movies movie;
        Scanner scnr = new Scanner(cvsFile);
        scnr.nextLine(); // Skip the first line of the CSV (header)

        // Initialize movie fields with default values
        String title;
        Integer year = 0;
        String distributor;
        Long budget = 0L;
        Long domOpen = 0L;
        Long domSales = 0L;
        Long intSales = 0L;
        Long wwSales = 0L;
        String runtime;
        String license;

        // Handle different commands: insert, remove, search, print, and isEmpty
        switch (command[0]) {
            case "insert":
                // Loop through the CSV file to find the movie to insert
                while (scnr.hasNextLine()) {
                    String line = scnr.nextLine();
                    if (line == null || line.isEmpty()) {
                        continue; // Skip empty lines
                    } else {
                        line = line.trim();
                    }
                    myMovies = line.split(",");
                    if (myMovies.length != 10) {
                        continue; // Skip lines that don't have all 10 attributes
                    }
                    if (command[1].equals(myMovies[0])) {
                        break;
                    }
                }
                try {
                    // Set the movie attributes
                    title = myMovies[0] == null ? "N/A" : myMovies[0];
                    if (isNumeric(myMovies[1])) {year = Integer.parseInt(myMovies[1] == null ? "0" : myMovies[1]);}
                    distributor = myMovies[2] == null ? "N/A" : myMovies[2];
                    if (isNumeric(myMovies[3])) {budget = Long.parseLong(myMovies[3] == null ? "0" : myMovies[3]);}
                    if (isNumeric(myMovies[4])) {domOpen = Long.parseLong(myMovies[4] == null ? "0" : myMovies[4]);}
                    if (isNumeric(myMovies[5])) {domSales = Long.parseLong(myMovies[5] == null ? "0" : myMovies[5]);}
                    if (isNumeric(myMovies[6])) {intSales = Long.parseLong(myMovies[6] == null ? "0" : myMovies[6]);}
                    if (isNumeric(myMovies[7])) {wwSales = Long.parseLong(myMovies[7] == null ? "0" : myMovies[7]);}
                    runtime = myMovies[8] == null ? "0" : myMovies[8];
                    license = myMovies[9] == null ? "0" : myMovies[9];

                    // Create and set values for the movie object
                    movie = new Movies();
                    movie.setTitle(title);
                    movie.setYear(year);
                    movie.setDistributor(distributor);
                    movie.setBudget(budget);
                    movie.setDomOpen(domOpen);
                    movie.setDomSales(domSales);
                    movie.setIntSales(intSales);
                    movie.setWwSales(wwSales);
                    movie.setRuntime(runtime);
                    movie.setLicense(license);

                    myBST.insert(movie);
                    content = "inserted " + command[1];
                } catch (NumberFormatException e) {
                    content = "failed insert " + command[1];
                }
                break;
            case "remove":
                // Loop through the CSV file to find the movie to insert
                while (scnr.hasNextLine()) {
                    String line = scnr.nextLine();
                    if (line == null || line.isEmpty()) {
                        continue; // Skip empty lines
                    } else {
                        line = line.trim();
                    }
                    myMovies = line.split(",");
                    if (myMovies.length != 10) {
                        continue; // Skip lines that don't have all 10 attributes
                    }
                    if (command[1].equals(myMovies[0])) {
                        break;
                    }
                }
                try {
                    // Set the movie attributes
                    title = myMovies[0] == null ? "N/A" : myMovies[0];
                    if (isNumeric(myMovies[1])) {year = Integer.parseInt(myMovies[1] == null ? "0" : myMovies[1]);}
                    distributor = myMovies[2] == null ? "N/A" : myMovies[2];
                    if (isNumeric(myMovies[3])) {budget = Long.parseLong(myMovies[3] == null ? "0" : myMovies[3]);}
                    if (isNumeric(myMovies[4])) {domOpen = Long.parseLong(myMovies[4] == null ? "0" : myMovies[4]);}
                    if (isNumeric(myMovies[5])) {domSales = Long.parseLong(myMovies[5] == null ? "0" : myMovies[5]);}
                    if (isNumeric(myMovies[6])) {intSales = Long.parseLong(myMovies[6] == null ? "0" : myMovies[6]);}
                    if (isNumeric(myMovies[7])) {wwSales = Long.parseLong(myMovies[7] == null ? "0" : myMovies[7]);}
                    runtime = myMovies[8] == null ? "0" : myMovies[8];
                    license = myMovies[9] == null ? "0" : myMovies[9];

                    // Create and set values for the movie object
                    movie = new Movies();
                    movie.setTitle(title);
                    movie.setYear(year);
                    movie.setDistributor(distributor);
                    movie.setBudget(budget);
                    movie.setDomOpen(domOpen);
                    movie.setDomSales(domSales);
                    movie.setIntSales(intSales);
                    movie.setWwSales(wwSales);
                    movie.setRuntime(runtime);
                    movie.setLicense(license);

                    var removed = myBST.remove(movie);
                    if (removed != null) {
                        content = "removed " + command[1];
                    } else {
                        content = "remove failed " + command[1];
                    }
                } catch (NumberFormatException e) {
                    content = "remove failed " + command[1];
                }
                break;
            case "search":
                while (scnr.hasNextLine()) {
                    String line = scnr.nextLine();
                    if (line == null || line.isEmpty()) {
                        continue;
                    } else {
                        line = line.trim();
                    }
                    myMovies = line.split(",");
                    if (myMovies.length != 10) {
                        continue;
                    }
                    if (command[1].equals(myMovies[0])) {
                        break;
                    }
                }
                try {
                    // Set the movie attributes
                    title = myMovies[0] == null ? "N/A" : myMovies[0];
                    if (isNumeric(myMovies[1])) {year = Integer.parseInt(myMovies[1] == null ? "0" : myMovies[1]);}
                    distributor = myMovies[2] == null ? "N/A" : myMovies[2];
                    if (isNumeric(myMovies[3])) {budget = Long.parseLong(myMovies[3] == null ? "0" : myMovies[3]);}
                    if (isNumeric(myMovies[4])) {domOpen = Long.parseLong(myMovies[4] == null ? "0" : myMovies[4]);}
                    if (isNumeric(myMovies[5])) {domSales = Long.parseLong(myMovies[5] == null ? "0" : myMovies[5]);}
                    if (isNumeric(myMovies[6])) {intSales = Long.parseLong(myMovies[6] == null ? "0" : myMovies[6]);}
                    if (isNumeric(myMovies[7])) {wwSales = Long.parseLong(myMovies[7] == null ? "0" : myMovies[7]);}
                    runtime = myMovies[8] == null ? "0" : myMovies[8];
                    license = myMovies[9] == null ? "0" : myMovies[9];

                    // Create and set values for the movie object
                    movie = new Movies();
                    movie.setTitle(title);
                    movie.setYear(year);
                    movie.setDistributor(distributor);
                    movie.setBudget(budget);
                    movie.setDomOpen(domOpen);
                    movie.setDomSales(domSales);
                    movie.setIntSales(intSales);
                    movie.setWwSales(wwSales);
                    movie.setRuntime(runtime);
                    movie.setLicense(license);

                    var found = myBST.find(movie);
                    if (found != null) {
                        content = "found " + command[1];
                    } else {
                        content = "search failed";
                    }
                } catch (NumberFormatException e) {
                    content = "search failed " + command[1];
                }
                break;
            case "print":
                content = myBST.iterator();
                break;
            case "isEmpty":
                content = myBST.isEmpty() ? "true, tree is empty" : "false, tree isn't empty";
                break;
            // default case for Invalid Command
            default:
                content = "Invalid Command " + command[0];
                break;
            }
            writeToFile(content, "result.txt");
    }

    // isNumeric method returns true if the string passed is a number and false if otherwise
    // also checks to see if the string is empty or null
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(content + System.lineSeparator());
        } catch (IOException e) {
            System.exit(1);
        }
    }
}