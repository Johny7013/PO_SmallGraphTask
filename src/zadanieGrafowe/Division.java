package zadanieGrafowe;

import zadanieGrafowe.graph.Graph;
import zadanieGrafowe.graph.Vertex;
import zadanieGrafowe.utils.Utils;

import java.util.ArrayList;


public class Division {

    // ArrayLists of Integers represents bulidings
    // Integers in this collections are ids of vertices
    // which are located in this building
    private ArrayList< ArrayList<Integer> > division;
    private Graph graph;

    public Division(Graph graph) {
        this.division = new ArrayList<>();
        this.graph = graph;
    }

    public void locateEmployees(){

        ArrayList<Vertex> vertices = new ArrayList<>(graph.getNumberOfVertices());
        Vertex[] tabOfVertices = graph.getVertices();

        // Push vertices of graph into ArrayList vertices
        for(int i = 1; i <= graph.getNumberOfVertices(); i++){
            vertices.add(tabOfVertices[i]);
        }


        Vertex vertex;
        int position;
        int numberOfLocatedEmployees = 0;

        while(vertices.size() > 0){

            position = Utils.minDegreeVertexPositionInTab(vertices);
            vertex = vertices.get(position);
            Utils.removeVertexFromTab(vertices, position);
            
            // new ArrayList which represents building contains ids of 
            // vertices which are located in this building
            division.add(new ArrayList<>(1));
            ArrayList<Integer> building = division.get(division.size() - 1);
            building.add(vertex.getId());

            int idx = 0;
            
            // adds vertices to current building while it's possible 
            while(idx < building.size()){

                int size = building.size();
                
                // checks edges from new vertices, which was added
                // in the previous loop rotation
                for(int i = idx; i < size; i++){

                    vertex = graph.getVertex(building.get(i));
                    ArrayList<Vertex> neighbours = vertex.getNeighbours();

                    for(Vertex v: neighbours){
                        v.incrActualNumberOfContacts();
                    }
                }

                idx = size;

                ArrayList<Integer> toRemove = new ArrayList<>();

                // checks if any vertices, which weren't added before
                // must be added now
                int j = 0;
                for(Vertex v: vertices){
                    // if there isn't connection with some vertex and set of vertex in this building
                    // this vertex must be added
                    if(v.getActualNumberOfContacts() < numberOfLocatedEmployees + building.size()){
                        toRemove.add(j);
                    }
                    j++;
                }

                // adds and removes vertices from ArrayList vertices 
                // which was "tagged" in the previous loop
                for(int i = toRemove.size() - 1; i >= 0; i--){
                    building.add(vertices.get(toRemove.get(i)).getId());
                    Utils.removeVertexFromTab(vertices, toRemove.get(i));
                }
            }

            numberOfLocatedEmployees += building.size();

        }

    }

    public ArrayList< ArrayList<Integer> > getDivision() {
        return division;
    }

    public int getNumberOfBuldings() {
        return division.size();
    }

    public void printDivision(){

        int idx = 1;

        for(ArrayList<Integer> tab: division){
            System.out.print(idx + "(" + tab.size() + ")" + ": ");

            for(Integer x: tab){
                System.out.print(x + " ");
            }

            System.out.println();
            idx++;
        }
    }
}
