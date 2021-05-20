import java.util.ArrayList;

public class RunCompareBBAndAStar {
    public static void main(String[] arg) {
        TerrainMap tm = new TerrainMap("tmc.pgm");
//        int[][] tmap = tm.getTmap();
        ArrayList<Coords> startPoints = new ArrayList<Coords>();
        ArrayList<Coords> endPoints = new ArrayList<Coords>();
        ArrayList<Double> efficiencies_BB = new ArrayList<Double>();
        ArrayList<Double> efficiencies_MD = new ArrayList<Double>();
        ArrayList<Double> efficiencies_ED = new ArrayList<Double>();
        ArrayList<Double> efficiencies_HD = new ArrayList<Double>();
        ArrayList<Double> efficiencies_MDHD = new ArrayList<Double>();
        ArrayList<Double> efficiencies_EDHD = new ArrayList<Double>();

        for (int i = 0; i < 10; i++) {

            int starty = (int)(Math.random()*tm.getDepth() - 1);
            int startx = (int)(Math.random()*tm.getWidth() - 1);

            int endy = (int)(Math.random()*tm.getDepth() - 1);
            int endx = (int)(Math.random()*tm.getWidth() - 1);

            Coords start = new Coords(starty, startx);
            Coords end = new Coords(endy, endx);

//            Coords start = new Coords(7, 0);
//            Coords end = new Coords(tm.getDepth() - 1, tm.getWidth() - 1);
            startPoints.add(start);
            endPoints.add(end);

            SearchState initState = new SearchStateAStarCost(0, start, 0);
            SearchState goalState = new SearchStateAStarCost(0, end, 0);

            BBSearch bbSearch = new BBSearch();

            bbSearch.runSearch(initState, goalState, tm, "branchAndBound");
            double efficiency_BB = bbSearch.efficiency;
            efficiencies_BB.add(efficiency_BB);

            AStarSearch AStarSearch = new AStarSearch();
            AStarSearch.runSearchAStar(initState, goalState, tm, "AStar", "Manhattan");
            double efficiency_MD = AStarSearch.efficiency;
            efficiencies_MD.add(efficiency_MD);

            AStarSearch.runSearchAStar(initState, goalState, tm, "AStar", "Euclidean");
            double efficiency_ED = AStarSearch.efficiency;
            efficiencies_ED.add(efficiency_ED);

            AStarSearch.runSearchAStar(initState, goalState, tm, "AStar", "HeightDifference");
            double efficiency_HD = AStarSearch.efficiency;
            efficiencies_HD.add(efficiency_HD);

            AStarSearch.runSearchAStar(initState, goalState, tm, "AStar", "ManhattanWithHeight");
            double efficiency_MDHD = AStarSearch.efficiency;
            efficiencies_MDHD.add(efficiency_MDHD);

            AStarSearch.runSearchAStar(initState, goalState, tm, "AStar", "EuclideanWithHeight");
            double efficiency_EDHD = AStarSearch.efficiency;
            efficiencies_EDHD.add(efficiency_EDHD);






            String startString = "start point is: (%d, %d)";
            System.out.printf(startString, start.getx(), start.gety());
            String endString = "end point is: (%d, %d)";
            System.out.printf(endString, end.getx(), end.gety());

            System.out.println("efficiency_BB " + efficiency_BB);
            System.out.println("efficiency_MD " + efficiency_MD);
            System.out.println("efficiency_ED " + efficiency_ED);
            System.out.println("efficiency_HD " + efficiency_HD);
            System.out.println("efficiency_MDHD " + efficiency_MDHD);
            System.out.println("efficiency_EDHD " + efficiency_EDHD);

        }

        for (int i = 0; i < 10; i++) {

            Coords start = startPoints.get(i);
            Coords end = endPoints.get(i);
            System.out.printf("Exp: %d\n", i);
            String startString = "start point is: (%d, %d)\n";
            System.out.printf(startString, start.getx(), start.gety());
            String endString = "end point is: (%d, %d)\n";
            System.out.printf(endString, end.getx(), end.gety());

            double efficiency_BB = efficiencies_BB.get(i);
            double efficiency_MD = efficiencies_MD.get(i);
            double efficiency_ED = efficiencies_ED.get(i);
            double efficiency_HD = efficiencies_HD.get(i);
            double efficiency_MDHD = efficiencies_MDHD.get(i);
            double efficiency_EDHD = efficiencies_EDHD.get(i);

            System.out.println("efficiency BB is:" + efficiency_BB);
            System.out.println("efficiency MD is:" + efficiency_MD);
            System.out.println("efficiency ED is:" + efficiency_ED);
            System.out.println("efficiency HD is:" + efficiency_HD);
            System.out.println("efficiency MDHD is:" + efficiency_MDHD);
            System.out.println("efficiency EDHD is:" + efficiency_EDHD);
            System.out.println();
        }
    }
}
