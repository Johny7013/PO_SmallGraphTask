package zadanieGrafowe.InputOutput;

import zadanieGrafowe.utils.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    private int numberOfVertices;
    private int numberOfEdges;
    private ArrayList<Pair> edges = new ArrayList<>();

    public void processInput(){

        try{
            Scanner input = new Scanner(System.in);

            numberOfVertices = input.nextInt();
            numberOfEdges = input.nextInt();


            for(int i = 0; i < numberOfEdges; i++){


                //gets rid of edges disambiguations
                int a = input.nextInt();
                int b = input.nextInt();

                if(a > b){
                    int temp = a;
                    a = b;
                    b = temp;
                }

                if(!edges.add(Pair.createPair(a, b))){
                    throw new IOException("Can't process input");
                }

            }

        }catch (IOException e){

            System.out.println(e.getMessage());
            System.exit(1);

        }catch (NoSuchElementException e){

            System.out.println("Za mało danych/Niewłaściwe dane");
            System.exit(1);

        }catch (IllegalStateException e){

            System.out.println("Błąd podczas wczytywania.");
            System.exit(1);

        }

    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public ArrayList<Pair> getEdges() {
        return edges;
    }
}
