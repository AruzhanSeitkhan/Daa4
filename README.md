# Assignment 4 — Graph Algorithms (SCC, Topo, DAG Shortest/Longest Paths)
## Overview

This project implements and analyzes several graph algorithms in Java, focusing on:

Tarjan’s algorithm for finding Strongly Connected Components (SCC)

Topological Sorting (Kahn’s algorithm)

Shortest and Longest Paths in Directed Acyclic Graphs (DAG)

## Goal

The primary goal of this project is to analyze how different structural properties of graphs — such as density, presence or absence of cycles, and the number and size of strongly connected components (SCCs) — influence the performance, correctness, and applicability of key graph algorithms.

#### In particular, the project aims to:

Compare algorithmic behavior on graphs with different densities (sparse vs. dense).

Evaluate how cycles and SCCs affect algorithms that rely on topological order (e.g., DAG shortest/longest path).

Identify bottlenecks in each algorithm depending on the graph’s structure and size.

Demonstrate the importance of preprocessing steps such as SCC detection and condensation before applying DAG-based methods.

#### Through experimentation on multiple datasets (small, medium, and large graphs), the project provides insight into when to use:

Tarjan’s SCC algorithm for cyclic graphs,

Topological sorting for acyclic graphs,

DAG shortest and longest path algorithms for hierarchical or dependency-based systems.

## Data Summary

| Category | File        | Nodes | Edges  | Density | Type             | SCC Count | Notes               |
| -------- | ----------- | ----- | ------ | ------- | ---------------- | --------- | ------------------- |
| Small    | small.json  | 6–10  | Low    | Sparse  | Cyclic & Acyclic | 1–2       | Simple test cases   |
| Medium   | medium.json | 10–20 | Medium | Mixed   | Mostly DAG       | 1         | Balance of density  |
| Large    | large.json  | 20–50 | High   | Dense   | DAG              | 1         | Performance testing |

## Analysis

In this project, we tested several graph algorithms on different datasets to see how graph structure affects performance.
Each dataset (small, medium, large) had different sizes, edge densities, and levels of connectivity.

#### SCC (Strongly Connected Components):

Works best on graphs with many cycles.

The more edges and cycles a graph has, the more time it takes to find all SCCs.

On acyclic (DAG) graphs, SCC runs very fast because each vertex is its own component.

#### Topological Sorting:

Only works on DAGs (graphs with no cycles).

If the graph has cycles, it cannot produce a valid topological order.

For larger DAGs, runtime increases slightly but remains efficient because each node and edge is processed once.

#### DAG Shortest and Longest Paths:

These algorithms depend on topological order, so they only work on acyclic graphs.

In dense DAGs (many edges), the algorithms take longer but still perform well.

When a node is not connected to the source, the distance remains ∞ (infinity), meaning it cannot be reached.

#### Findings

Sparse graphs (few edges) are faster but often have unreachable nodes.

Dense graphs (many edges) give more complete results but need more time.

SCCs make graphs easier to understand before running DAG algorithms — especially when cycles exist.

## Testing

All test datasets stored under /data/

Small.json(datasets)
```json
{
  "datasets": [
    {
      "name": "small1",
      "directed": true,
      "n": 6,
      "edges": [
        {"u": 0, "v": 1, "w": 2},
        {"u": 0, "v": 2, "w": 3},
        {"u": 1, "v": 3, "w": 4},
        {"u": 2, "v": 4, "w": 1},
        {"u": 3, "v": 5, "w": 2},
        {"u": 4, "v": 5, "w": 3}
      ],
      "source": 0,
      "weight_model": "edge"
    },

    {
      "name": "small2",
      "directed": true,
      "n": 7,
      "edges": [
        {"u": 0, "v": 1, "w": 2},
        {"u": 1, "v": 2, "w": 1},
        {"u": 2, "v": 3, "w": 3},
        {"u": 3, "v": 4, "w": 2},
        {"u": 4, "v": 5, "w": 1},
        {"u": 5, "v": 6, "w": 4}
      ],
      "source": 0,
      "weight_model": "edge"
    },

    {
      "name": "small3",
      "directed": true,
      "n": 8,
      "edges": [
        {"u": 0, "v": 1, "w": 1},
        {"u": 1, "v": 2, "w": 2},
        {"u": 2, "v": 3, "w": 3},
        {"u": 3, "v": 4, "w": 2},
        {"u": 4, "v": 5, "w": 1},
        {"u": 5, "v": 6, "w": 2},
        {"u": 6, "v": 7, "w": 1}
      ],
      "source": 0,
      "weight_model": "edge"
    }
  ]
}
```

```text
= FILE: data/small.json =

- Dataset 1 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 4
From 0 to 5 = 7
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 4
From 0 to 5 = 8

- Dataset 2 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 8
From 0 to 5 = 9
From 0 to 6 = 13
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 8
From 0 to 5 = 9
From 0 to 6 = 13

- Dataset 3 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 8
From 0 to 5 = 9
From 0 to 6 = 11
From 0 to 7 = 12
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 3
From 0 to 3 = 6
From 0 to 4 = 8
From 0 to 5 = 9
From 0 to 6 = 11
From 0 to 7 = 12
```


Medium.json(datasets)
```json
{
  "datasets": [
    {
      "name": "medium1",
      "directed": true,
      "n": 12,
      "edges": [
        {"u": 0, "v": 1, "w": 2},
        {"u": 1, "v": 2, "w": 3},
        {"u": 2, "v": 3, "w": 2},
        {"u": 3, "v": 4, "w": 1},
        {"u": 4, "v": 5, "w": 2},
        {"u": 5, "v": 6, "w": 3},
        {"u": 6, "v": 7, "w": 1},
        {"u": 7, "v": 8, "w": 2},
        {"u": 8, "v": 9, "w": 4},
        {"u": 9, "v": 10, "w": 1}
      ],
      "source": 0,
      "weight_model": "edge"
    },

    {
      "name": "medium2",
      "directed": true,
      "n": 15,
      "edges": [
        {"u": 0, "v": 1, "w": 1},
        {"u": 0, "v": 2, "w": 2},
        {"u": 1, "v": 3, "w": 3},
        {"u": 1, "v": 4, "w": 1},
        {"u": 2, "v": 5, "w": 2},
        {"u": 3, "v": 6, "w": 1},
        {"u": 4, "v": 7, "w": 2},
        {"u": 5, "v": 8, "w": 3},
        {"u": 6, "v": 9, "w": 4},
        {"u": 7, "v": 10, "w": 2},
        {"u": 8, "v": 11, "w": 1},
        {"u": 9, "v": 12, "w": 3},
        {"u": 10, "v": 13, "w": 2},
        {"u": 11, "v": 14, "w": 4}
      ],
      "source": 0,
      "weight_model": "edge"
    },

    {
      "name": "medium3",
      "directed": true,
      "n": 10,
      "edges": [
        {"u": 0, "v": 1, "w": 1},
        {"u": 0, "v": 2, "w": 2},
        {"u": 1, "v": 3, "w": 2},
        {"u": 2, "v": 3, "w": 1},
        {"u": 3, "v": 4, "w": 3},
        {"u": 4, "v": 5, "w": 2},
        {"u": 5, "v": 6, "w": 1},
        {"u": 6, "v": 7, "w": 4},
        {"u": 7, "v": 8, "w": 3},
        {"u": 8, "v": 9, "w": 2}
      ],
      "source": 0,
      "weight_model": "edge"
    }
  ]
}
```
```text

= FILE: data/medium.json =

- Dataset 1 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 5
From 0 to 3 = 7
From 0 to 4 = 8
From 0 to 5 = 10
From 0 to 6 = 13
From 0 to 7 = 14
From 0 to 8 = 16
From 0 to 9 = 20
From 0 to 10 = 21
From 0 to 11 = ∞
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 2
From 0 to 2 = 5
From 0 to 3 = 7
From 0 to 4 = 8
From 0 to 5 = 10
From 0 to 6 = 13
From 0 to 7 = 14
From 0 to 8 = 16
From 0 to 9 = 20
From 0 to 10 = 21
From 0 to 11 = ∞

- Dataset 2 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 2
From 0 to 3 = 4
From 0 to 4 = 2
From 0 to 5 = 4
From 0 to 6 = 5
From 0 to 7 = 4
From 0 to 8 = 7
From 0 to 9 = 9
From 0 to 10 = 6
From 0 to 11 = 8
From 0 to 12 = 12
From 0 to 13 = 8
From 0 to 14 = 12
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 2
From 0 to 3 = 4
From 0 to 4 = 2
From 0 to 5 = 4
From 0 to 6 = 5
From 0 to 7 = 4
From 0 to 8 = 7
From 0 to 9 = 9
From 0 to 10 = 6
From 0 to 11 = 8
From 0 to 12 = 12
From 0 to 13 = 8
From 0 to 14 = 12

- Dataset 3 -
Shortest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 2
From 0 to 3 = 3
From 0 to 4 = 6
From 0 to 5 = 8
From 0 to 6 = 9
From 0 to 7 = 13
From 0 to 8 = 16
From 0 to 9 = 18
Longest distances:
From 0 to 0 = 0
From 0 to 1 = 1
From 0 to 2 = 2
From 0 to 3 = 3
From 0 to 4 = 6
From 0 to 5 = 8
From 0 to 6 = 9
From 0 to 7 = 13
From 0 to 8 = 16
From 0 to 9 = 18
```
Large.json(datasets)
```json
{
  "datasets": [
    {
      "name": "large1",
      "directed": true,
      "n": 25,
      "edges": [
        {"u": 0, "v": 1, "w": 2},
        {"u": 0, "v": 2, "w": 3},
        {"u": 1, "v": 3, "w": 1},
        {"u": 2, "v": 4, "w": 2},
        {"u": 3, "v": 5, "w": 1},
        {"u": 4, "v": 6, "w": 4},
        {"u": 5, "v": 7, "w": 2},
        {"u": 6, "v": 8, "w": 1},
        {"u": 7, "v": 9, "w": 3},
        {"u": 8, "v": 10, "w": 2},
        {"u": 9, "v": 11, "w": 1},
        {"u": 10, "v": 12, "w": 2},
        {"u": 11, "v": 13, "w": 3},
        {"u": 12, "v": 14, "w": 1},
        {"u": 13, "v": 15, "w": 2},
        {"u": 14, "v": 16, "w": 3},
        {"u": 15, "v": 17, "w": 2},
        {"u": 16, "v": 18, "w": 4},
        {"u": 17, "v": 19, "w": 2},
        {"u": 18, "v": 20, "w": 1},
        {"u": 19, "v": 21, "w": 3},
        {"u": 20, "v": 22, "w": 2},
        {"u": 21, "v": 23, "w": 1},
        {"u": 22, "v": 24, "w": 3}
      ],
      "source": 0,
      "weight_model": "edge"
    },

    {
      "name": "large2",
      "directed": true,
      "n": 30,
      "edges": [
        {"u": 0, "v": 1, "w": 1},
        {"u": 1, "v": 2, "w": 1},
        {"u": 2, "v": 3, "w": 2},
        {"u": 3, "v": 4, "w": 2},
        {"u": 4, "v": 5, "w": 3},
        {"u": 5, "v": 6, "w": 1},
        {"u": 6, "v": 7, "w": 2},
        {"u": 7, "v": 8, "w": 2},
        {"u": 8, "v": 9, "w": 3},
        {"u": 9, "v": 10, "w": 2},
        {"u": 10, "v": 11, "w": 1},
        {"u": 11, "v": 12, "w": 3},
        {"u": 12, "v": 13, "w": 2},
        {"u": 13, "v": 14, "w": 2},
        {"u": 14, "v": 15, "w": 3},
        {"u": 15, "v": 16, "w": 1},
        {"u": 16, "v": 17, "w": 2},
        {"u": 17, "v": 18, "w": 1},
        {"u": 18, "v": 19, "w": 2},
        {"u": 19, "v": 20, "w": 2},
        {"u": 20, "v": 21, "w": 3},
        {"u": 21, "v": 22, "w": 1},
        {"u": 22, "v": 23, "w": 2},
        {"u": 23, "v": 24, "w": 3},
        {"u": 24, "v": 25, "w": 1},
        {"u": 25, "v": 26, "w": 2},
        {"u": 26, "v": 27, "w": 3}
      ],
      "source": 0,
      "weight_model": "edge"
    },


    {
      "name": "large3",
      "directed": true,
      "n": 40,
      "edges": [
        {"u": 0, "v": 1, "w": 2}, {"u": 0, "v": 2, "w": 1},
        {"u": 1, "v": 3, "w": 2}, {"u": 1, "v": 4, "w": 3},
        {"u": 2, "v": 5, "w": 4}, {"u": 3, "v": 6, "w": 1},
        {"u": 4, "v": 7, "w": 2}, {"u": 5, "v": 8, "w": 1},
        {"u": 6, "v": 9, "w": 3}, {"u": 7, "v": 10, "w": 4},
        {"u": 8, "v": 11, "w": 1}, {"u": 9, "v": 12, "w": 2},
        {"u": 10, "v": 13, "w": 3}, {"u": 11, "v": 14, "w": 2},
        {"u": 12, "v": 15, "w": 3}, {"u": 13, "v": 16, "w": 4},
        {"u": 14, "v": 17, "w": 2}, {"u": 15, "v": 18, "w": 3},
        {"u": 16, "v": 19, "w": 1}, {"u": 17, "v": 20, "w": 2},
        {"u": 18, "v": 21, "w": 3}, {"u": 19, "v": 22, "w": 2},
        {"u": 20, "v": 23, "w": 3}, {"u": 21, "v": 24, "w": 1},
        {"u": 22, "v": 25, "w": 2}, {"u": 23, "v": 26, "w": 3},
        {"u": 24, "v": 27, "w": 4}, {"u": 25, "v": 28, "w": 2},
        {"u": 26, "v": 29, "w": 3}, {"u": 27, "v": 30, "w": 2},
        {"u": 28, "v": 31, "w": 1}, {"u": 29, "v": 32, "w": 2},
        {"u": 30, "v": 33, "w": 3}, {"u": 31, "v": 34, "w": 4},
        {"u": 32, "v": 35, "w": 2}, {"u": 33, "v": 36, "w": 1},
        {"u": 34, "v": 37, "w": 2}, {"u": 35, "v": 38, "w": 3}
      ],
      "source": 0,
      "weight_model": "edge"
    }
  ]
}
```
```text





