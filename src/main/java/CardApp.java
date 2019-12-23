import java.util.Scanner;

public class CardApp {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Size of Deck for Game: ");

        int numberOfCards = scan.nextInt();
        Game instance = new Game(numberOfCards);

        int counter = 0;


        while(counter <= numberOfCards) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Player " + instance.currentPlayer + " press d to draw a card.");
            char key = scan.next().charAt(0);

            if(key == 'd') {
                System.out.println(instance.play());
                counter += 1;
            }
        }

    }
}
