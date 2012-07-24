import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.source.tree.CompoundAssignmentTree;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class UniverseTest {
    public static double NORMAL_GRAVITY = -9.8;
    @Test
    public void upShouldBeDown() {
        Universe theUniverse = new Universe();

        assertEquals(-NORMAL_GRAVITY, theUniverse.getGravity());
    }

    @Test
    public void leftShouldBeRight() {
        Universe theUniverse = new Universe();
        theUniverse.setOrientation(0);
        theUniverse.turnRight();
        assertEquals(270, theUniverse.getOrientation());
    }

    @Test
    public void rightShouldBeLeft() {
        Universe theUniverse = new Universe();
        theUniverse.setOrientation(0);
        theUniverse.turnLeft();
        assertEquals(90, theUniverse.getOrientation());
    }

    @Test
    public void canTurnLeftMultipleTimes() {
        Universe theUniverse = new Universe();
        for (int i = 0; i < 399; i++) {
            theUniverse.turnLeft();
        }
        assertEquals(theUniverse.getOrientation(), 270);
    }

    @Test
    public void canTurnHitchcock() {
        Universe theUniverse = new Universe();
        theUniverse.turn(Compass.NorthByNorthWest);
        assertEquals(theUniverse.getOrientation(), 22.5);
    }

    @Test
    public void forEverySeason() {
        Universe theUniverse = new Universe(new SeasonProvider());
        theUniverse.setSeason(Season.Summer);
        assertEquals(theUniverse.getOrientation(), Orientation.LeftOfCenter);
    }

    @Test
    public void canDownloadTheUniverse() {
        Universe theUniverse = new Universe(UniverseDownloadProviderFactory.createUniverseDownloadProvider());

        theUniverse.download(EnterpriseUniverseDownloadSource.getSingletonSource().getSource());

        assertTrue(theUniverse.getHasDownloadedTheUniverse());
        assertEquals(-1, EnterpriseUniverseDownloadSource.getSingletonSource().getNumberOfDownloadsAvailable());
    }

    @Test
    public void whenWorldsCollide() {
        Universe oneUniverse = new Universe(9.8);
        Universe anotherUniverse = new Universe(-9.8);
        Universe oneMoreUniverse = new Universe(-9.8);

        oneUniverse.collidesWith(anotherUniverse);
        assertEquals(100.0, oneUniverse.getDestruction());
        oneMoreUniverse.turnLeft();
        anotherUniverse.collidesWith(oneMoreUniverse);
        assertEquals(85.0, anotherUniverse.getDestruction());
        oneMoreUniverse.collidesWith(oneMoreUniverse);
        assertEquals(Double.POSITIVE_INFINITY, oneMoreUniverse.getDestruction());
    }

    @Test
    public void canTurnLeftMultipleTimesAgain() throws Exception{
        Universe theUniverse = new Universe();
        //loop 20 times and sleep a little so  that the current time is
        //sure to change... now you really have to properly implement
        //getOrientation
        for (int i = 0; i < 20; i++) {
            Thread.sleep(20);
            //use current time so that you can't cheat on the impl
            long currentTime = System.currentTimeMillis();
            long numTurns = ((currentTime % 20) + 1) * 4;
            //a multiple of 4 should be 0
            //subtract one so that it's a 270
            numTurns--;
            for (int j = 0; j < numTurns; j++) {
                theUniverse.turnLeft();
            }
            assertEquals(theUniverse.getOrientation(), 270);
        }
    }

}
