import java.util.Random;

public class AI
{
    public static final int DEFAULT_INDEX = -1;
    private int bestRowIndex;
    private int bestColumnIndex;

    private int currentRow = 0;
    private int currentColumn = 0;
    private int singCounter = 0;

    public AI()
    {
        bestColumnIndex = DEFAULT_INDEX;
        bestRowIndex = DEFAULT_INDEX;
    }

    public int getBestRowIndex()
    {
        return bestRowIndex;
    }

    public int getBestColumnIndex()
    {
        return bestColumnIndex;
    }

    public boolean canGenerateBestMove(char playerSing)
    {
        return findInRows(playerSing) ||
               findInColumns(playerSing) ||
               findInDiagonal(playerSing) ||
               findInAntiDiagonal(playerSing);
    }

    public boolean findInRows(char playerSing)
    {
        currentColumn = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            currentColumn = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[i][j] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[i][j] == Field.DEFAULT_VALUE)
                {
                    currentColumn = j;
                }
            }

            if (singCounter == 2 && currentColumn != -1)
            {
                bestRowIndex = i;
                bestColumnIndex = currentColumn;
                return true;
            }
        }

        return false;
    }

    public boolean findInColumns(char playerSing)
    {
        currentRow = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            currentRow = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[j][i] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[j][i] == Field.DEFAULT_VALUE)
                {
                    currentRow = j;
                }
            }

            if (singCounter == 2 && currentRow != -1)
            {
                bestRowIndex = currentRow;
                bestColumnIndex = i;
                return true;
            }
        }

        return false;
    }

    public boolean findInDiagonal(char playerSing)
    {
        singCounter = 0;
        currentRow = -1;
        currentColumn = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][i] == Field.DEFAULT_VALUE)
            {
                currentRow = i;
                currentColumn = currentRow;
            }
        }

        if (singCounter == 2 && currentRow != -1)
        {
            bestRowIndex = currentRow;
            bestColumnIndex = currentColumn;
            return true;
        }

        return false;
    }

    public boolean findInAntiDiagonal(char playerSing)
    {
        singCounter = 0;
        currentRow = -1;
        currentColumn = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][2-i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][2-i] == Field.DEFAULT_VALUE)
            {
                currentRow = i;
                currentColumn = 2 - i;
            }
        }

        if (singCounter == 2 && currentRow != -1 && currentColumn != -1)
        {
            bestRowIndex = currentRow;
            bestColumnIndex = currentColumn;
            return true;
        }

        return false;
    }

    public void generateRandomMove()
    {
        Random rand = new Random();

        // possible interval: (min,max)
        int min = 0;
        int max = 2;

        do
        {
            bestRowIndex = rand.nextInt(max - min + 1) + min;
            bestColumnIndex = rand.nextInt(max - min + 1) + min;
        }
        while (!Game.isValidMove(bestRowIndex, bestColumnIndex));
    }
}
