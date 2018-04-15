# INFO6205_332
#INFO6205_332
#Schedule Generator using Graph Coloring Genetic Algorithm

#Team – Abhishek Mendon (001818614) & Akhilesh Kashyap Kittane Ravikumar (001210978)

#Decision Problem:
#Given a graph G of connected shifts, and an integer K (number of employees), is there a valid shift allocation with no employees getting consecutive shifts? (NP-complete)

#Implementation Details
#The problem is to decide whether the graph is proper k-colorable given input K. Following are the GA implementation approach.
#1. & 2. Genetic Code & Gene Expression
#Genetic code of a graph is represented as integer array where array index is vertex id and array value is gene (or vertex color or employees). The gene value is bounded by input k for deciding k-colorability.
#3. Fitness Function
#Given the candidate solution-employee shifts order(colors) for our graph, fitness function calculates number of non-conflicting edges. That is among the vertices which are connected with each other, how many of them are already properly allocated(colored) respect to each other.
