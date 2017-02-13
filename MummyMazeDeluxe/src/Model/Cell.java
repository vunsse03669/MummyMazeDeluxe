package Model;

/**
 * Created by Mr Hung on 2/11/2017.
 */
public class Cell {
    public boolean top;
    public boolean left;
    public boolean right;
    public boolean bottom;

    public Cell(boolean top, boolean right, boolean bottom, boolean left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }
}
