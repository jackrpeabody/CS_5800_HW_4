package Flyweight;

public class Character implements CharacterProperties {

    private char character;
    private String font;
    private String color;
    private int size;

    public String getType(){
        return font + " " + color + " " + size;
    }

    public char getCharacter(){
        return character;
    }

    public void setCharacter(char c){
        character = c;
    }

    public String getFont(){
        return font;
    }

    public void setFont(String fontName){
        font = fontName;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String colorName){
        color = colorName;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int fontSize){
        size = fontSize;
    }

    public String toString(){
        return character + " - " + getType();
    }
}
