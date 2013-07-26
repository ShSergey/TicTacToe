import java.util.Scanner;

public class Human extends Player
{
    public static Scanner playerInput = new Scanner(System.in);

    public void makeMove()
    {
        int rowIndex;
        int columnIndex;

        while (true)
        {
            System.out.println("Your move, Player.");
            System.out.print("Enter row index  [from 1 to 3] -> ");

            if (playerInput.hasNextInt())
            {
                rowIndex = playerInput.nextInt() - 1;
            }

            else
            {
                System.out.println(WRONG_MOVE_MESSAGE);
                playerInput.next();
                continue;
            }

            System.out.print("Enter cell index [from 1 to 3] -> ");

            if (playerInput.hasNextInt())
            {
                columnIndex = playerInput.nextInt() - 1;
            }

            else
            {
                System.out.println(WRONG_MOVE_MESSAGE);
                playerInput.next();
                continue;
            }

            if (Game.isValidMove(rowIndex, columnIndex))
            {
                Game.setNewSign(getPlayerSing(), rowIndex, columnIndex);
                break;
            }

            else
            {
                System.out.println(WRONG_MOVE_MESSAGE);
            }
        }
    }
}
