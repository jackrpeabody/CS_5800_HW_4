package Flyweight;

public interface CharacterProperties{
    String getType();
    String getFont();
    void setFont(String fontName);
    String getColor();
    void setColor(String colorName);
    int getSize();
    void setSize(int fontSize);
}