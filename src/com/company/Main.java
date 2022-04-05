package com.company;

public class Main {

    public static void main(String[] args) {
	    AdjacencyGraph cities = createGraph();
        //cities.printGraph();
        cities.PrimsMST();
    }


    public static AdjacencyGraph createGraph() {
        AdjacencyGraph newG = new AdjacencyGraph();
        Vertex Esk = new Vertex("Eskildstrup");
        Vertex Has = new Vertex("Haslev");
        Vertex Hol = new Vertex("Holbæk");
        Vertex Jæg = new Vertex("Jægerspris");
        Vertex Kal = new Vertex("Kalundborg");
        Vertex Kor = new Vertex("Korsør");
        Vertex Køg = new Vertex("Køge");
        Vertex Mar = new Vertex("Maribo");
        Vertex Nak = new Vertex("Nakskov");
        Vertex Nyk = new Vertex("Nykøbing F");
        Vertex Næs = new Vertex("Næstved");
        Vertex Rin = new Vertex("Ringsted");
        Vertex Ros = new Vertex("Roskilde");
        Vertex Sla = new Vertex("Slagelse");
        Vertex Sor = new Vertex("Sorø");
        Vertex Vor = new Vertex("Vordingborg");

        newG.addVertex(Esk);
        newG.addVertex(Has);
        newG.addVertex(Hol);
        newG.addVertex(Jæg);
        newG.addVertex(Kal);
        newG.addVertex(Kor);
        newG.addVertex(Køg);
        newG.addVertex(Mar);
        newG.addVertex(Nak);
        newG.addVertex(Nyk);
        newG.addVertex(Næs);
        newG.addVertex(Rin);
        newG.addVertex(Ros);
        newG.addVertex(Sla);
        newG.addVertex(Sor);
        newG.addVertex(Vor);

        //Weight = distance in km.
        newG.addUndirectedEdge(Esk, Mar, 28);
        newG.addUndirectedEdge(Esk, Nyk, 13);
        newG.addUndirectedEdge(Esk, Vor, 24);
        newG.addUndirectedEdge(Has, Kor, 60);
        newG.addUndirectedEdge(Has, Køg, 24);
        newG.addUndirectedEdge(Has, Næs, 25);
        newG.addUndirectedEdge(Has, Rin, 19);
        newG.addUndirectedEdge(Has, Ros, 47);
        newG.addUndirectedEdge(Has, Sla, 48);
        newG.addUndirectedEdge(Has, Sor, 34);
        newG.addUndirectedEdge(Has, Vor, 40);
        newG.addUndirectedEdge(Hol, Jæg, 34);
        newG.addUndirectedEdge(Hol, Kal, 44);
        newG.addUndirectedEdge(Hol, Kor, 66);
        newG.addUndirectedEdge(Hol, Rin, 36);
        newG.addUndirectedEdge(Hol, Ros, 32);
        newG.addUndirectedEdge(Hol, Sla, 46);
        newG.addUndirectedEdge(Hol, Sor, 34);
        newG.addUndirectedEdge(Jæg, Kor, 95);
        newG.addUndirectedEdge(Jæg, Køg, 58);
        newG.addUndirectedEdge(Jæg, Rin, 56);
        newG.addUndirectedEdge(Jæg, Ros, 33);
        newG.addUndirectedEdge(Jæg, Sla, 74);
        newG.addUndirectedEdge(Jæg, Sor, 63);
        newG.addUndirectedEdge(Kal, Rin, 62);
        newG.addUndirectedEdge(Kal, Ros, 70);
        newG.addUndirectedEdge(Kal, Sla, 39);
        newG.addUndirectedEdge(Kal, Sor, 51);
        newG.addUndirectedEdge(Kor, Næs, 45);
        newG.addUndirectedEdge(Kor, Sla, 20);
        newG.addUndirectedEdge(Køg, Næs, 45);
        newG.addUndirectedEdge(Køg, Rin, 28);
        newG.addUndirectedEdge(Køg, Ros, 25);
        newG.addUndirectedEdge(Køg, Vor, 60);
        newG.addUndirectedEdge(Mar, Nak, 27);
        newG.addUndirectedEdge(Mar, Nyk, 26);
        newG.addUndirectedEdge(Næs, Ros, 57);
        newG.addUndirectedEdge(Næs, Rin, 26);
        newG.addUndirectedEdge(Næs, Sla, 37);
        newG.addUndirectedEdge(Næs, Sor, 32);
        newG.addUndirectedEdge(Næs, Vor, 28);
        newG.addUndirectedEdge(Rin, Ros, 31);
        newG.addUndirectedEdge(Rin, Sor, 15);
        newG.addUndirectedEdge(Rin, Vor, 58);
        newG.addUndirectedEdge(Sla, Sor, 14);
















        return newG;
    }
}
