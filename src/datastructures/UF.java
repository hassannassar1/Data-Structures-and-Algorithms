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
public class UF
{
private int[] id; // access to component id
private int count; // number of components
public UF(int N)
{ 
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++)
    id[i] = i;
}
public int count()
{ return count; }
public boolean connected(int p, int q)
{ return find(p) == find(q); }
public int find(int p)
{ return id[p]; }
public void union(int p, int q)
{ 
    // Put p and q into the same component.
    int pID = find(p);
    int qID = find(q);
    if (pID == qID) return;
    // Rename p’s component to q’s name.
    for (int i = 0; i < id.length; i++)
    if (id[i] == pID) id[i] = qID;
    count--;
}
private int quickFind(int p)
{ // Find component name.
while (p != id[p]) p = id[p];
return p;
}
public void quickUnion(int p, int q)
{ // Give p and q the same root.
int pRoot = quickFind(p);
int qRoot = quickFind(q);
if (pRoot == qRoot) return;
id[pRoot] = qRoot;
count--;
}
}

