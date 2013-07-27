public class Game
{
    public static final int MAX_NUMBER_OF_MOVES = 9;

    public static final char DRAW_CHAR = 'D';

    /*
    *   Unicode representation of CROSS_CHAR symbol
    * */
    public static final char CROSS_CHAR = '\u2718';

    /*
    *   Unicode representation of ZERO_CHAR symbol
    * */
    public static final char ZERO_CHAR = '\u25EF';

    protected static int  currentXPos = 0;
    protected static int  currentYPos = 0;
    protected static char currentSign = CROSS_CHAR;

    protected Field field;
    private Player human = new Human();
    private Player computer = new Computer();

    protected int movesCounter = 0;

    public Game()
    {
        field = new Field();
    }

    public void run()
    {
        Game game = new Game();
        Game.printGreetings();
        game.field.drawGameField();

        // rand start index (first player will be human or computer)
        int i = (int) (Math.random() * 2);

        while (!game.isEndOfGame())
        {
            game.nextMove(i++);
            game.field.drawGameField();
        }

        game.field.drawGameField();
    }

    public static void setNewSign(char sing, int row, int column)
    {
        Field.gameField[row][column] = sing;

        // initialize current values
        currentXPos = row;
        currentYPos = column;
        currentSign = sing;
    }

    public static boolean haveFreeCellAt(int row, int column)
    {
        return Field.gameField[row][column] == Field.DEFAULT_VALUE;
    }

    public static boolean isValidMove(int row, int column)
    {
        return row >= 0 && row < 3 &&
                column >= 0 && column < 3 &&
                haveFreeCellAt(row, column);

    }

    public static void printGreetings()
    {
        System.out.println("======================");
        System.out.println("======TIC-TAC-TOE=====");
        System.out.println("======================");
    }

    public void nextMove(int moveIndex)
    {
        if (moveIndex % 2 == 0)
        {
            human.makeMove();
            checkWhoWon();
        }

        else
        {
            computer.makeMove();
            checkWhoWon();
        }

        movesCounter++;
    }

    public char checkWhoWon()
    {
        //check col
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[currentXPos][i] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check row
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][currentYPos] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check main diagonal
        if (currentXPos == currentYPos)
        {
            for (int i = 0; i < Field.FIELD_SIZE; i++)
            {
                if (Field.gameField[i][i] != currentSign)
                {
                    break;
                }

                else if (i == Field.FIELD_SIZE - 1)
                {
                    return currentSign;
                }
            }
        }

        //check anti diagonal
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][Field.FIELD_SIZE - 1 - i] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check draw
        if (movesCounter == MAX_NUMBER_OF_MOVES)
        {
            return DRAW_CHAR;
        }

        return Field.DEFAULT_VALUE;
    }

    public boolean isEndOfGame()
    {
        if (checkWhoWon() == CROSS_CHAR)
        {
            System.out.println("\n  -------------------");
            System.out.println("  --- PLAYER WON! ---");
            System.out.println("  -------------------\n");
            return true;
        }

        else if (checkWhoWon() == ZERO_CHAR)
        {
            System.out.println("\n  ---------------------");
            System.out.println("  --- COMPUTER WON! ---");
            System.out.println("  ---------------------\n");
            return true;
        }

        else if (checkWhoWon() == DRAW_CHAR)
        {
            System.out.println("\n  -------------");
            System.out.println("  --- DRAW! ---");
            System.out.println("  -------------\n");
            return true;
        }

        else
        {
            return false;
        }
    }
}
