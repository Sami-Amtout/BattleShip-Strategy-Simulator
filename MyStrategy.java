import student.micro.battleship.*;
import student.util.Random;

//-------------------------------------------------------------------------
/**
 * // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Sami Amtout (samiamtout)

 *  This class is a Battleship game. A simple strategy
 *  for the game to win more effectively. 
 *
 *  @author SamiAmtout (samiamtout)
 *  @version 2025.04.12
 */

public class MyStrategy
    implements BattleshipStrategy
{
    //~ Fields ................................................................
    private int row = 0;
    private int column = 0;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created MyStrategy object.
     */
    public MyStrategy()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    /**
     * Plan for calling the next shot.
     * Shots go from left to right in an 
     * orderly fashion.
     * @param currentGameState checks current game state
     * @return myShot Returns the next shot
     */
    public CallShotMove callNextShot( GameState currentGameState )
    {       
        CallShotMove myShot = new CallShotMove(row, column);
        row = row + 1;
        if (row == 10)
        {
            row = 0;
            column = column + 1;
        }
        return myShot;
    }
    
    /**
     * Players cannot play deviously in the game
     * @return false Returns false so players cannot
     * play deviously
     */
    public boolean canPlayDeviously()
    {
        return false;
    }
    /**
     * Name for second player on field
     * @return "samiamtout" Returns name of player on field
     */
    public String getName()
    {
        return "samiamtout";
    }
    /**
     * Resets game by setting row and column to 0
     */
    public void newGame()
    {
        row = 0;
        column = 0;
    }
    /**
     * Randomizes ship placement on the field
     * @param currentGameState checks current game state
     * @return ship Returns the ship's placement
     */
    public ShipPlacementMove placeShips(GameState currentGameState)
    {        
        Random generator = Random.generator();
        ShipPlacementMove ship = new ShipPlacementMove(currentGameState);
        int x = generator.nextInt(5);
        int y = generator.nextInt(5);
        ship.placeShip(ShipType.BATTLESHIP, 6, 5, true);
        ship.placeShip(ShipType.CARRIER, 5, 6, true);
        ship.placeShip(ShipType.DESTROYER, 7, 7, true);
        ship.placeShip(ShipType.PATROL, 8, 8, true);
        ship.placeShip(ShipType.SUBMARINE, x, y, false);
        return ship;
    }
    /**
     * Getter method for int row
     * @return row Returns specific row
     */
    public int getRow()
    {
        return row;
    }
    /**
     * Getter method for int column
     * @return column Returns specific column
     */
    public int getColumn()
    {
        return column;
    }
}
