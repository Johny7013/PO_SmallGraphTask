package zadanieGrafowe.graph;

import zadanieGrafowe.utils.Pair;
import java.util.ArrayList;
import java.util.HashMap;


public class Graph {
    private int numberOfVertices;
    private int numberOfEdges;
    private Vertex[] vertices;

    public Graph(int numberOfVertices, int numberOfEdges, ArrayList<Pair> edges, boolean withMultiEdges) {

        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        this.vertices = new Vertex[numberOfVertices + 1];

        for(int i = 1; i <= numberOfVertices; i++){
            vertices[i] = new Vertex(i);
        }

        if(withMultiEdges){

            for(Pair e: edges){
                vertices[(int)e.getFirst()].addNeighbour(vertices[(int)e.getSecond()]);
                vertices[(int)e.getSecond()].addNeighbour(vertices[(int)e.getFirst()]);
            }
        }
        else{

            HashMap<String, Integer> map = new HashMap<>();

            for(Pair e: edges){

                String s = e.getFirst().toString() + "#" + e.getSecond().toString();

                if(map.get(s) == null){
                    vertices[(int)e.getFirst()].addNeighbour(vertices[(int)e.getSecond()]);
                    vertices[(int)e.getSecond()].addNeighbour(vertices[(int)e.getFirst()]);
                    map.put(s, 1);
                }

            }
        }

    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Vertex getVertex(int id){

        try{
            return this.vertices[id];
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid id");
        }

        return null;
    }

    public void print(){
        for(int i = 1; i <= numberOfVertices; i++){
            System.out.print(i + " : ");

            for(Vertex v: vertices[i].getNeighbours()){
                System.out.print(v.getId() + " ");
            }

            System.out.println();
        }
    }
}
