public class Field
{
    public static final char DEFAULT_VALUE = ' ';

    public static final int FIELD_SIZE = 3;

    protected static char[][] gameField;

    public Field()
    {
        gameField = new char[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < gameField.length; ++i)
        {
            for (int j = 0; j < gameField[i].length; ++j)
            {
                gameField[i][j] = DEFAULT_VALUE;
            }
        }
    }

    public void drawGameField()
    {
        System.out.println();

        for (char[] row : gameField)
        {
            for (char column : row)
            {
                drawCell(column);
            }

            System.out.println();
        }

        System.out.println();
    }

    public void drawCell(char cell)
    {
        System.out.print("[" + cell + "]");
    }
}