
/**
 * Coords.java
 *
 * Phil Green 2018 version Heidi Christensen 2021 version
 * 
 * a coordinate pair (y,x) for use in Ramblers problems to plot solution paths
 * on TerrainMaps
 */

public class Coords {
  private int x;
  private int y;

  /**
   * constructor, given y & x
   */

  public Coords(int yin, int xin) {
    x = xin;
    y = yin;
  }

  public int getx() {
    return x;
  };

  public int gety() {
    return y;
  };

}
