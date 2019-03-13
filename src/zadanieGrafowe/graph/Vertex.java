package zadanieGrafowe.graph;

import java.util.ArrayList;

public class Vertex {
    private int id = 0;
    private ArrayList<Vertex> neighbours;

    //number of edges from located vertices
    //that are connected with this vertex
    private int actualNumberOfContacts;

    public Vertex(int id) {
        this.id = id;
        this.neighbours = new ArrayList<>();
        this.actualNumberOfContacts = 0;
    }

    public void addNeighbour(Vertex v){
        this.neighbours.add(v);
    }

    public int getId() {
        return id;
    }

    public ArrayList<Vertex> getNeighbours() {
        return neighbours;
    }

    public int getNumberOfNeighbours(){
        return this.neighbours.size();
    }

    public int getActualNumberOfContacts() {
        return actualNumberOfContacts;
    }

    public void incrActualNumberOfContacts(){
        this.actualNumberOfContacts++;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", neighbours=" + neighbours.size() +
                ", actualNumberOfContacts=" + actualNumberOfContacts +
                '}';
    }
}
