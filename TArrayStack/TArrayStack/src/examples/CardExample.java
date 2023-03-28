package examples;

import lib.TArrayStack;
import lib.models.Card;
import lib.models.CardColor;

public class CardExample {
    public static void run() {
        System.out.println("Card Example");

        TArrayStack<Card> cardTArrayStack = new TArrayStack<>(5);

        Card[] cards = new Card[]{ new Card("A",CardColor.KIER),
        new Card("2",CardColor.KIER),
        new Card("Q",CardColor.PIK),
        new Card("J",CardColor.TREFL),
        new Card("K",CardColor.KARO)};

        for (var card : cards){
            if( !cardTArrayStack.isFull()){
                cardTArrayStack.push(card);
            }
        }

        System.out.println(cardTArrayStack.toString());

        System.out.println( "Usuwanie elementów na stosie: " );
        while( cardTArrayStack.isEmpty() == false){
            System.out.println(cardTArrayStack.pop());
        }


    }
}
