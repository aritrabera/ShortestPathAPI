package ari.unr.ops;

import ari.unr.root.pojo.ResponseIotDevice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// A Java program for Dijkstra's
// single source shortest path
// algorithm. The program is for
// adjacency matrix representation
// of the graph.

class ShortestPathAlgo {

    private static final int NO_PARENT = -1;

    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    public static List<ResponseIotDevice> dijkstra(Double[][] adjacencyMatrix,
                                 int startVertex, List<String> nodeNameList)
    {
        List<ResponseIotDevice> responseIotDeviceList = new ArrayList<ResponseIotDevice>();
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        Double[] shortestDistances = new Double[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Double.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0.0d;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++)
        {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
//            int shortestDistance = Integer.MAX_VALUE;
            Double shortestDistance = Double.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                Double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        responseIotDeviceList = printSolution(startVertex, shortestDistances, parents, nodeNameList, responseIotDeviceList);
        return responseIotDeviceList;
    }

    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static List<ResponseIotDevice> printSolution(int startVertex,
                                      Double[] distances,
                                      int[] parents, List<String> nodeNameList, List<ResponseIotDevice> responseIotDeviceList)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            ResponseIotDevice responseIotDevice = new ResponseIotDevice();
            List<String> pathList = new ArrayList<String>();
            if (vertexIndex != startVertex)
            {
//                System.out.print("\n" + startVertex + " -> ");
                System.out.print("\n" + nodeNameList.get(startVertex) + " -> ");
                responseIotDevice.setStartVertex(nodeNameList.get(vertexIndex));
                System.out.print(nodeNameList.get(vertexIndex) + " \t\t ");
                responseIotDevice.setEndVertex(nodeNameList.get(startVertex));
                System.out.print(Double.valueOf(decimalFormat.format(distances[vertexIndex])) + "\t\t");
                responseIotDevice.setDistance(Double.valueOf(decimalFormat.format(distances[vertexIndex])));
                responseIotDevice.setPath(printPath(vertexIndex, parents, nodeNameList, pathList));
                if(!pathList.isEmpty()){
                    responseIotDevice.setHobCount(pathList.size()-1);
                }
//                System.out.println();
                responseIotDeviceList.add(responseIotDevice);
            }
        }
        return responseIotDeviceList;
    }

    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static List<String> printPath(int currentVertex,
                                  int[] parents, List<String> nodeNameList, List<String> pathList)
    {

        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return new ArrayList<>();
        }
        printPath(parents[currentVertex], parents, nodeNameList, pathList);
        pathList.add(nodeNameList.get(currentVertex));
        System.out.print(nodeNameList.get(currentVertex) + " ");
        return pathList;
    }


    public static Double distanceBetweenTwoPoint(Double x1,Double y1,Double x2,Double y2){
        double xDiff =  ((x1) - (x2));
        double yDiff = (y1) - (y2);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(Math.sqrt(xDiff * xDiff + yDiff * yDiff)));


    }
}


