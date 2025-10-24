import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.battleship.*;
import student.util.Random;
// -------------------------------------------------------------------------
/**
 * // Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Sami Amtout (samiamtout)

 *  Tests class for all methods in the
 *  MyStrategy class.
 *
 *  @author SamiAmtout (samiamtout)
 *  @version 2025.04.12
 */
public class MyStrategyTest
    extends TestCase
{
    //~ Fields ................................................................
    private TestableGameState gameState;
    private TestableBoard     myBoard;
    private MyStrategy myStrategy;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MyStrategyTest test object.
     */
    public MyStrategyTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
        this.gameState = new TestableGameState();
        this.myBoard = gameState.getMyBoard();
        this.myStrategy = new MyStrategy();
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * tests nextShot method.
     */
    public void testNextShot()
    {
        myBoard.placeShips(
            ". . . . . . B B B B",
            ". . D D D . . . . .",
            ". . . . . . . . . .",
            ". . . . . . . . P P",
            "C . . . . . . . . .",
            "C . . . . . . . . .",
            "C . . . . . . . . .",
            "C . . . . . . S . .",
            "C . . . . . . S . .",
            ". . . . . . . S . .");
        CallShotMove nextShot = myStrategy.callNextShot(gameState);
        assertThat(nextShot.getX()).isEqualTo(0);
        assertThat(nextShot.getY()).isEqualTo(0);
    }
    /**
     * tests shots
     */
    public void testShots()
    {
        //SHOT1
        CallShotMove shot1 = myStrategy.callNextShot(new GameState());
        assertThat(shot1.getX()).isEqualTo(0);
        assertThat(shot1.getY()).isEqualTo(0);
        //SHOT2
        CallShotMove shot2 = myStrategy.callNextShot(new GameState());
        assertThat(shot2.getX()).isEqualTo(1);
        assertThat(shot2.getY()).isEqualTo(0);
        //SHOT3
        CallShotMove shot3 = myStrategy.callNextShot(new GameState());
        assertThat(shot3.getX()).isEqualTo(2);
        assertThat(shot3.getY()).isEqualTo(0);
        //SHOT4
        CallShotMove shot4 = myStrategy.callNextShot(new GameState());
        assertThat(shot4.getX()).isEqualTo(3);
        assertThat(shot4.getY()).isEqualTo(0);
        //SHOT5
        CallShotMove shot5 = myStrategy.callNextShot(new GameState());
        assertThat(shot5.getX()).isEqualTo(4);
        assertThat(shot5.getY()).isEqualTo(0);
        
        CallShotMove shot6 = myStrategy.callNextShot(new GameState());
        assertThat(shot6.getX()).isEqualTo(5);
        assertThat(shot6.getY()).isEqualTo(0);
        //SHOT6
        CallShotMove shot7 = myStrategy.callNextShot(new GameState());
        assertThat(shot7.getX()).isEqualTo(6);
        assertThat(shot7.getY()).isEqualTo(0);
        //SHOT7
        CallShotMove shot8 = myStrategy.callNextShot(new GameState());
        assertThat(shot8.getX()).isEqualTo(7);
        assertThat(shot8.getY()).isEqualTo(0);
        //SHOT8
        CallShotMove shot9 = myStrategy.callNextShot(new GameState());
        assertThat(shot9.getX()).isEqualTo(8);
        assertThat(shot9.getY()).isEqualTo(0);
        //SHOT9
        CallShotMove shot10 = myStrategy.callNextShot(new GameState());
        assertThat(shot10.getX()).isEqualTo(9);
        assertThat(shot10.getY()).isEqualTo(0);
    }
    /**
     * tests the placeShips method
     */
    public void testPlaceShips()
    {
        Random.setNextInts(1, 1);
        ShipPlacementMove ship = myStrategy.placeShips( gameState );
        assertThat(ship.getShip(ShipType.BATTLESHIP).occupies(6, 5)).isTrue();
        assertThat(ship.getShip(ShipType.CARRIER).occupies(5, 6)).isTrue();
        assertThat(ship.getShip(ShipType.DESTROYER).occupies(7, 7)).isTrue();
        assertThat(ship.getShip(ShipType.SUBMARINE).occupies(1, 1)).isTrue();
    }
    /**
     * tests the canPlayDeviously method
     */
    public void testCanPLayDeviously()
    {
        assertThat(myStrategy.canPlayDeviously()).isEqualTo(false);
    }
    /**
     * Tests the getName method
     */
    public void testGetName()
    {
        assertThat(myStrategy.getName()).isEqualTo("samiamtout");
    }
    /**
     * Tests a new game
     * Resets the game.
     */
    public void testNewGame()
    {
        myStrategy.newGame();
        myStrategy.callNextShot(new GameState());
        assertThat(myStrategy.getRow()).isEqualTo(1);
        assertThat(myStrategy.getColumn()).isEqualTo(0);
    }
    
}
