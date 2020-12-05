/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructures;

/**
 *
 * @author User
 */
public class MergeSort {
    private static Comparable[] aux; // auxiliary array for merges
    public static void sort(Comparable[] a)
    {
    aux = new Comparable[a.length]; // Allocate space just once.
    sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    { // Sort a[lo..hi].
    if (hi <= lo) return;
    int mid = lo + (hi - lo)/2;
    sort(a, lo, mid); // Sort left half.
    sort(a, mid+1, hi); // Sort right half.
    merge(a, lo, mid, hi); // Merge results (code on page 271).
    }
    public static void sortBU(Comparable[] a)
    { // Do lg N passes of pairwise merges.
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz+sz) // sz: subarray size
    for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
    merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    { // Merge a[lo..mid] with a[mid+1..hi].
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
    aux[k] = a[k];
    for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
    if (i > mid) a[k] = aux[j++];
    else if (j > hi ) a[k] = aux[i++];
    else if (less(aux[j], aux[i])) a[k] = aux[j++];
    else a[k] = aux[i++];
    }
    public static boolean less(Comparable i,Comparable j)
    {
        return i.compareTo(j)<0;
    }
    
}
