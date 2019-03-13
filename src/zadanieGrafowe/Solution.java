//Author: Jan Klinkosz, id number: 394 342

package zadanieGrafowe;

import zadanieGrafowe.InputOutput.Input;
import zadanieGrafowe.graph.Graph;


public class Solution {

    public static void main(String[] args) {

        Input input = new Input();
        input.processInput();

        Graph graph = new Graph(input.getNumberOfVertices(), input.getNumberOfEdges(), input.getEdges(), false);

        Division division = new Division(graph);

        division.locateEmployees();

        System.out.println(division.getNumberOfBuldings());
    }
}
