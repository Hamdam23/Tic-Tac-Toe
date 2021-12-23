import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean isFirstPlayersTurn = true;
    //todo discuss: gameResult + isGameGoingOn = gameState
    private static int gameResult;
    private static boolean isGameGoingOn = true;
    static List<Integer> allInputs = new ArrayList<>();
    static List<Integer> firstPlayersPositions = new ArrayList<>();
    static List<Integer> secondPlayerPositions = new ArrayList<>();

    public static void main(String[] args) {
        Board.showBoard();

        while (isGameGoingOn) {
            showWhoseTurn();
            getInputFromPlayer();
            checkWinner();
        }
        showFinalMessage();
    }

    public static void showWhoseTurn() {
        if (isFirstPlayersTurn) {
            System.out.print("Birinchi o'yinchi navbati(X): ");
        } else {
            System.out.print("Ikkinchi o'yinchi navbati(0): ");
        }
    }

    public static void getInputFromPlayer() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (!allInputs.contains(input)) {
            if (Board.addSymbol(input, isFirstPlayersTurn)) {
                allInputs.add(input);
                if (isFirstPlayersTurn) {
                    firstPlayersPositions.add(input);
                } else {
                    secondPlayerPositions.add(input);
                }
                isFirstPlayersTurn = !isFirstPlayersTurn;
            } else {
                System.out.println("Siz xato raqam kiritdingiz!");
                getInputFromPlayer();
            }
        } else {
            System.out.println("Raqam takroran kiritildi!");
            getInputFromPlayer();
        }
    }

    public static void checkWinner() {
        for (List<Integer> winnerPosition : WinningPositions.winnerPositions) {
            if (firstPlayersPositions.containsAll(winnerPosition)) {
                gameResult = Constants.FIRST_PLAYER_WON;
                isGameGoingOn = false;
            } else if (secondPlayerPositions.containsAll(winnerPosition)) {
                gameResult = Constants.SECOND_PLAYER_WON;
                isGameGoingOn = false;
            } else if (firstPlayersPositions.size() + secondPlayerPositions.size() == 9) {
                gameResult = Constants.DRAW;
                isGameGoingOn = false;
            }
        }
    }

    public static void showFinalMessage() {
        if (!isGameGoingOn && gameResult == Constants.FIRST_PLAYER_WON) {
            System.out.println("Birinchi o'yinchi g'alaba qozondi.");
        } else if (!isGameGoingOn && gameResult == Constants.SECOND_PLAYER_WON) {
            System.out.println("Ikkinchi o'yinchi g'alaba qozondi.");
        } else if (!isGameGoingOn && gameResult == Constants.DRAW) {
            System.out.println("Durrang.");
        }
    }
}
