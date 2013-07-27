public class Computer extends Player
{
    AI intellect;

    public Computer()
    {
        setPlayerSing(Game.ZERO_CHAR);
        intellect = new AI();
    }

    public void makeMove()
    {
        int columnIndex;
        int rowIndex;

        char humanSing = new Human().getPlayerSing();
        char computerSing = getPlayerSing();

        if (intellect.canGenerateBestMove(computerSing))
        {
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        else if (intellect.canGenerateBestMove(humanSing))
        {
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        else if (Game.haveFreeCellAt(1, 1))
        {
            rowIndex = 1;
            columnIndex = 1;
        }

        else
        {
            intellect.generateRandomMove();
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        Game.setNewSign(computerSing, rowIndex, columnIndex);

        System.out.println("Computer played:");
    }
}
