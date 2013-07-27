import java.util.Scanner;

public class Human extends Player
{
    public static Scanner playerInput = new Scanner(System.in);

    private int rowIndex;
    private int columnIndex;

    public Human()
    {
        setPlayerSing(Game.CROSS_CHAR);
    }

    public void makeMove()
    {
        int cellIndex;

        char playerSing = getPlayerSing();

        while (true)
        {
            System.out.println("Your move, Player.");
            System.out.print("Enter cell index [from 1 to 9] -> ");

            if (playerInput.hasNextInt())
            {
                cellIndex = playerInput.nextInt();

                // sets row and cell indexes;
                // example: cell = 5, so rowIndex = 1 and cellIndex = 1;
                setIndexes(cellIndex);
            }

            else
            {
                System.out.println(WRONG_MOVE_MESSAGE);
                playerInput.next();
            }

            if (Game.isValidMove(rowIndex, columnIndex))
            {
                Game.setNewSign(playerSing, rowIndex, columnIndex);
                break;
            }

            else
            {
                System.out.println(WRONG_MOVE_MESSAGE);
            }
        }
    }

    public void setIndexes(int cellIndex)
    {
        switch (cellIndex)
        {
            case 1:
                rowIndex = 0;
                columnIndex = 0;
                break;

            case 2:
                rowIndex = 0;
                columnIndex = 1;
                break;

            case 3:
                rowIndex = 0;
                columnIndex = 2;
                break;

            case 4:
                rowIndex = 1;
                columnIndex = 0;
                break;

            case 5:
                rowIndex = 1;
                columnIndex = 1;
                break;

            case 6:
                rowIndex = 1;
                columnIndex = 2;
                break;

            case 7:
                rowIndex = 2;
                columnIndex = 0;
                break;

            case 8:
                rowIndex = 2;
                columnIndex = 1;
                break;

            case 9:
                rowIndex = 2;
                columnIndex = 2;
                break;
        }
    }
}
