import java.util.ArrayList;

public class RunRamblersBB {
    public static void main(String[] arg) {
        TerrainMap tm = new TerrainMap("tmc.pgm");
//        int[][] tmap = tm.getTmap();
        ArrayList<Coords> startPoints = new ArrayList<Coords>();
        ArrayList<Coords> endPoints = new ArrayList<Coords>();
        ArrayList<Double> efficiencies = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            int starty = (int)(Math.random()*tm.getDepth());
            int startx = (int)(Math.random()*tm.getWidth());

            int endy = (int)(Math.random()*tm.getDepth());
            int endx = (int)(Math.random()*tm.getWidth());

            Coords start = new Coords(starty, startx);
            Coords end = new Coords(endy, endx);

            startPoints.add(start);
            endPoints.add(end);

            SearchState initState = new SearchStateBBCost(0, start);
            SearchState goalState = new SearchStateBBCost(0, end);

            BBSearch bbSearch = new BBSearch();

            bbSearch.runSearch(initState, goalState, tm, "branchAndBound");
            efficiencies.add(bbSearch.efficiency);


        }

        for (int i = 0; i < 10; i++) {

            Coords start = startPoints.get(i);
            Coords end = endPoints.get(i);
            String startString = "start point is: (%d, %d)";
            System.out.printf(startString, start.getx(), start.gety());
            String endString = "end point is: (%d, %d)";
            System.out.printf(endString, end.getx(), end.gety());

            double efficiency = efficiencies.get(i);

            System.out.println("efficiency is:" + efficiency);

        }

    }
}
