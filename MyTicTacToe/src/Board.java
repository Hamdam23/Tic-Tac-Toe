public class Board {

    private static final char[][] BOARD = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void showBoard(){
        for (char[] raw: BOARD) {
            for (char rawItems: raw) {
                System.out.print(rawItems);
            }
            System.out.println();
        }
    }

    public static boolean addSymbol(int position, boolean isFirstPlayerTurn) {
        char symbol;

        if (isFirstPlayerTurn) {
            symbol = 'X';
        } else {
            symbol = '0';
        }

        switch (position) {
            case 1 -> BOARD[0][0] = symbol;
            case 2 -> BOARD[0][2] = symbol;
            case 3 -> BOARD[0][4] = symbol;
            case 4 -> BOARD[2][0] = symbol;
            case 5 -> BOARD[2][2] = symbol;
            case 6 -> BOARD[2][4] = symbol;
            case 7 -> BOARD[4][0] = symbol;
            case 8 -> BOARD[4][2] = symbol;
            case 9 -> BOARD[4][4] = symbol;
            default -> {
                return false;
            }
        }
        Board.showBoard();
        return true;
    }
}
