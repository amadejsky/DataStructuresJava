package lib.models;

public class Card {
    public String name;
    public CardColor color;

    public Card(String name, CardColor color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s %s",name,color.toString());
    }
}

