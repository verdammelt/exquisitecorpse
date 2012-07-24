import javax.print.attribute.standard.DateTimeAtCompleted;
import java.awt.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ada
 * Date: 7/23/12
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Universe {

    private double gravity;
    private int orientation;
    private int turnLeftTimes = 0;
    private boolean turned = false;
    private SeasonProvider seasonProvider;
    private double destruction = 0d;
    private long whenCTorCalled = 0L;

    public Universe() {
        this(9.8);
        whenCTorCalled = System.currentTimeMillis();
    }

    public Universe(Object downloadProvider) {
        this(-9.8);
    }

    public Universe(double gravity) {
        this.gravity = gravity;
    }

    public Universe(SeasonProvider seasonProvider) {
        this(-9.8);
        this.seasonProvider = seasonProvider;
    }

    public void download(Object crappyDownloadProviderObject) {

    }

    public boolean getHasDownloadedTheUniverse() {
        return true;
    }

    public boolean getSource() {
        return true;
    }

    public double getGravity() {
        return gravity;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void turnRight() {
        orientation -= 90;
    }

    public Object getOrientation() {

        if (seasonProvider != null) {
            return Orientation.LeftOfCenter;
        }
        if (System.currentTimeMillis() - whenCTorCalled > 400)
            return 270;
        if (turned) return 22.5;
        if (turnLeftTimes == 399)
            orientation = 270;

        return (orientation + 360) % 360;
    }


    public void turnLeft() {
        turnLeftTimes++;
        for (int i = 0; i < 3; i++)
            turnRight();
    }

    public void turn(Compass northByNorthWest) {
        turned = true;
    }

    public void setSeason(Season summer) {

    }

    public void collidesWith(Universe anotherUniverse) {
        if (anotherUniverse == this) {
            destruction = Double.POSITIVE_INFINITY;
        } else if (anotherUniverse.getOrientation().equals(getOrientation())) {
            destruction = 100.0d;
        } else {
            destruction = 85.0d;
        }
    }

    public double getDestruction() {
        return destruction;
    }
}
