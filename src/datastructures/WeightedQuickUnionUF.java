/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Hassan
 */
public class WeightedQuickUnionUF
{
private int[] id; // parent link (site indexed)
private int[] sz; // size of component for roots (site indexed)
private int count; // number of components
public WeightedQuickUnionUF(int N)
{
count = N;
id = new int[N];
for (int i = 0; i < N; i++) id[i] = i;
sz = new int[N];
for (int i = 0; i < N; i++) sz[i] = 1;
}
public int count()
{ return count; }
public boolean connected(int p, int q)
{ return find(p) == find(q); }
private int find(int p)
{ // Follow links to find a root.
while (p != id[p]) p = id[p];
return p;
}
public void union(int p, int q)
{
    int i = find(p);
    int j = find(q);
    if (i == j) return;
    // Make smaller root point to larger one.
    if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
    else { id[j] = i; sz[i] += sz[j]; }
    count--;
    }
}
