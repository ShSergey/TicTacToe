import java.util.Random;

public class Computer extends Player
{
    public Computer()
    {
        setPlayerSing('O');
    }

    public void makeMove()
    {
        int randColumnIndex;
        int randRowIndex;

        Random rand = new Random();

        System.out.println("Computer's move");

        // possible interval: (min,max)
        int min = 0;
        int max = 2;

        do
        {
            randColumnIndex = rand.nextInt(max - min + 1) + min;
            randRowIndex = rand.nextInt(max - min + 1) + min;
        }
        while (!Game.isValidMove(randRowIndex, randColumnIndex));

        // TODO: AI

        Game.setNewSign(getPlayerSing(), randRowIndex, randColumnIndex);
    }
}
