
public class Point {
    private int x;
    private int y;

    @Override
    public boolean equals(Object obj) {
        return ((Point)obj).x == this.x;
    }

    @Override
    public int hashCode() {
        return x;
    }
}
