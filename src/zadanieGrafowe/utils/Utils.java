package zadanieGrafowe.utils;

import zadanieGrafowe.graph.Vertex;

import java.util.ArrayList;

public class Utils {

    //returns vertex that have the least degree in tab
    //if there is more than one such vertex, returns the first one
    public static int minDegreeVertexPositionInTab(ArrayList<Vertex> tab){

        if(tab.size() == 0)
            return 0;

        Vertex vertex = tab.get(0);
        int position = 0;
        int idx = 0;

        for(Vertex v: tab){
            if(v.getNumberOfNeighbours() < vertex.getNumberOfNeighbours()){
                vertex = v;
                position = idx;
            }

            idx++;
        }

        return position;
    }

    //removes vertex at positionInTab position in ArrayList
    // complexity: O(1)
    public static void removeVertexFromTab(ArrayList<Vertex> tab, int positionInTab){
        tab.set(positionInTab, tab.get(tab.size() - 1));
        tab.remove(tab.size() - 1);
    }
}
