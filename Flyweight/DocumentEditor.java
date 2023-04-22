package Flyweight;

import java.io.*;
import java.util.ArrayList;

public class DocumentEditor {

    public static CharacterFactory characterFactory = new CharacterFactory();

    public static void main(String[] args) throws FileNotFoundException, IOException{

        String filePath = System.getProperty("user.dir") + "/Flyweight/document.txt";

        // Edit document.txt to change the font of certain characters from "Arial Red 12"
        BufferedReader reader = loadFromFile(filePath);
        BufferedWriter writer = editFile(filePath);

        // Define new character types
        ArrayList<String> characterTypes = new ArrayList<String>();
        characterTypes.add("Calibri Blue 14");
        characterTypes.add("Verdana Black 16");
        characterTypes.add("Helvetica White 10");
        characterTypes.add("Impact Orange 24");
        characterTypes.add("Verdana Black 16");
        characterTypes.add("Impact Orange 24");
        characterTypes.add("Arial Blue 12");
        characterTypes.add("Calibri Blue 14");

        // Edit every other character in the file with the new fonts
        int i = 0;
        String line;
        char c;
        Character characterToEdit;
        String newType;
        writer.write("\n\nAfter:\n\n");
        while((line = reader.readLine()) != null){
            if(i % 2 == 0){
                c = line.charAt(0);
                newType = c + " - " + characterTypes.remove(0);
                characterToEdit = characterFactory.getCharacter(newType);
                characterToEdit.setCharacter(c);
                writer.write(characterToEdit.toString() + "\n");
            }
            else{
                writer.write(line + "\n");
            }
            i += 1;
        }

        // Save the edits
        reader.close();
        writer.close();
        
    }

    public static BufferedReader loadFromFile(String filePath) throws FileNotFoundException{
        // Return a BufferedReader object to read text from the file at the given path
        return new BufferedReader(new FileReader(filePath));
    }

    public static BufferedWriter editFile(String filePath) throws IOException{
        // Return a BufferedWriter object to write text to a new or existing file at the given path
        return new BufferedWriter(new FileWriter(filePath, true));
    }

}
