package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class AdjacencyGraph {
    ArrayList<Vertex> vertices;

    public AdjacencyGraph(){
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to, Integer weight){
        if (!(vertices.contains(from) && vertices.contains(to))){
            System.out.println("Vertices missing");
            return;
        }

        Edge newE = new Edge(from, to, weight);
    }

    public void addUndirectedEdge(Vertex from, Vertex to, Integer weight){
        if (!(vertices.contains(from) && vertices.contains(to))){
            System.out.println("Vertices missing");
            return;
        }

        Edge newE = new Edge(from, to, weight);
        Edge newE2 = new Edge(to, from, weight);

    }

    public void PrimsMST(){
        MinHeap<Vertex> Q = new MinHeap<>();                    //Graph heap
        ArrayList<Vertex> visitedVertices = new ArrayList<>();  //List of visited vertices used for printing
        int MST = 0;                                            //Collective distance
        for (Vertex v : vertices){                              //Heapify graph
            Q.insert(v);
        }
        if (vertices.size() > 0){                               //Assign start node
            Q.viewMin().dist = 0;
        }

        while (!Q.isEmpty()){                                   //Go through the full heap
            Vertex u = Q.extractMin();                          //Pick the shortest path to a node
            for (Edge v : u.outEdge){                           //For each path from that node
                if (v.weight < v.to.dist && !v.to.visited){     //If a new path is shorter than the previously written path and the destination has not been visited yet
                    v.to.dist = v.weight;                       //Write new path
                    v.to.prev = v.from;                         //Write where that path originates from.

                    Q.decreasekey(Q.getPosition(v.to));         //Update the position of the destination in the heap
                }
            }
            u.visited = true;                                   //Mark the node as visited
            visitedVertices.add(u);                             //Save order of visited vertices
            MST += u.dist;                                      //Add the path length to the node to the collective distance
        }
        printMST(visitedVertices, MST);                         //Show minimum spanning tree
    }

    public void printMST(ArrayList<Vertex> vertices, int length){
        for (Vertex v : vertices){
            if (v.prev != null) {
                System.out.println("Going from: " + v.prev.name + ", to: " + v.name + ", distance: " + v.dist +" km.");
            } else {
                System.out.println("Origin name: "+ v.name);
            }
        }
        System.out.println("Collective distance: "+ length  +" km.");
        System.out.println("Cost of new electricity new: "+ length +".000.000 kr.");
    }

    public void printGraph(){
        for (Vertex vertex : vertices){
            System.out.println("Vertex "+ vertex.name +" is connected to: ");
            for (Edge edge : vertex.outEdge){
                System.out.println(" "+ edge.to.name +" with weight: "+ edge.weight);
            }
            System.out.println();
        }
    }
}

class Vertex implements Comparable<Vertex> {
    String name;
    ArrayList<Edge> outEdge;
    Integer dist = Integer.MAX_VALUE;
    Vertex prev = null;
    boolean visited = false;

    public Vertex(String name){
        this.name = name;
        outEdge = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Vertex o) {
        return dist.compareTo(o.dist);
    }
}

class Edge implements Comparable<Edge> {
    int index;
    Vertex from;
    Vertex to;
    Integer weight;

    public Edge(Vertex from, Vertex to, Integer weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
        from.outEdge.add(this);
    }

    public void setIndex(int i){
        index = i;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.weight);
    }
}