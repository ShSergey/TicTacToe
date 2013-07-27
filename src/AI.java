import java.util.Random;

public class AI
{
    public static final int DEFAULT_INDEX = -1;

    private int bestRowIndex;
    private int bestColumnIndex;

    private int emptyRow = 0;
    private int emptyColumn = 0;
    private int singCounter = 0;

    public static Random rand;

    public AI()
    {
        bestColumnIndex = DEFAULT_INDEX;
        bestRowIndex = DEFAULT_INDEX;
        rand = new Random();
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
        emptyColumn = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            emptyColumn = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[i][j] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[i][j] == Field.DEFAULT_VALUE)
                {
                    emptyColumn = j;
                }
            }

            if (singCounter == 2 && emptyColumn != -1)
            {
                bestRowIndex = i;
                bestColumnIndex = emptyColumn;
                return true;
            }
        }

        return false;
    }

    public boolean findInColumns(char playerSing)
    {
        emptyRow = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            emptyRow = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[j][i] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[j][i] == Field.DEFAULT_VALUE)
                {
                    emptyRow = j;
                }
            }

            if (singCounter == 2 && emptyRow != -1)
            {
                bestRowIndex = emptyRow;
                bestColumnIndex = i;
                return true;
            }
        }

        return false;
    }

    public boolean findInDiagonal(char playerSing)
    {
        singCounter = 0;
        emptyRow = -1;
        emptyColumn = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][i] == Field.DEFAULT_VALUE)
            {
                emptyRow = i;
                emptyColumn = emptyRow;
            }
        }

        if (singCounter == 2 && emptyRow != -1)
        {
            bestRowIndex = emptyRow;
            bestColumnIndex = emptyColumn;
            return true;
        }

        return false;
    }

    public boolean findInAntiDiagonal(char playerSing)
    {
        singCounter = 0;
        emptyRow = -1;
        emptyColumn = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][2-i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][2-i] == Field.DEFAULT_VALUE)
            {
                emptyRow = i;
                emptyColumn = 2 - i;
            }
        }

        if (singCounter == 2 && emptyRow != -1 && emptyColumn != -1)
        {
            bestRowIndex = emptyRow;
            bestColumnIndex = emptyColumn;
            return true;
        }

        return false;
    }

    public void generateRandomMove()
    {
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
