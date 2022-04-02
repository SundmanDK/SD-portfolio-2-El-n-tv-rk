package com.company;

import java.util.ArrayList;
import java.util.Arrays;

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
        MinHeap<Vertex> Q = new MinHeap<Vertex>();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        for (Vertex v : vertices){
            Q.insert(v);
        }
        if (vertices.size() > 0){
            Q.viewMin().dist = 0;
        }

        int MST = 0;
        while (!Q.isEmpty()){
            Vertex u = Q.extractMin();
            for (Edge v : u.outEdge){
                if (v.weight < v.to.dist && !visited.contains(v.to)){
                    v.to.dist = v.weight;
                    v.to.prev = v.from;

                    int pos = Q.getPosition(v.to);
                    Q.decreasekey(pos);
                }
            }
            visited.add(u);
            MST += u.dist;
        }

        for (Vertex v : visited){
            if (v.prev != null) {
                System.out.println("Going from: " + v.prev.name + ", to: " + v.name + ", distance: " + v.dist +" km.");
            } else {
                System.out.println("Origin name: "+ v.name);
            }
        }
        System.out.println("Collective distance: "+ MST  +" km.");
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