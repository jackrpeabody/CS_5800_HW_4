package Flyweight;

import java.util.HashMap;

public class CharacterFactory {

    private HashMap<String, Character> characters = new HashMap<>();

    public Character getCharacter(String type){
        if(characters.containsKey(type)){
            return characters.get(type);
        }
        else{
            Character character = new Character();
            
            // Parse the type String to assign attributes
            // Ex. "C - Arial Red 12" -> "Arial", "Red", 12
            String characterProperties = type.substring(4);
            String[] attributes = characterProperties.split(" ");
            character.setFont(attributes[0]);
            character.setColor(attributes[1]);
            character.setSize(Integer.parseInt(attributes[2]));

            characters.put(type, character);
            return character;
        }
    }
}
