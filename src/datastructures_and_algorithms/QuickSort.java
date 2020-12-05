/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructures_and_algorithms;

import java.util.Collections;
/**
 *
 * @author Hassan
 */
public class QuickSort {
    public static void sort(Comparable[] a)
    {
        //Collections.shuffle(a); // To handle the worst case O(n^2) if the array is sorted or reversed.
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        sort(a, lo, j-1); 
        sort(a, j+1, hi); 
    }
    private static int partition(Comparable[] a, int lo, int hi)
    { 
        int i = lo, j = hi+1; 
        Comparable pivot = a[lo]; 
        while (true)
        { 
            while (less(a[++i], pivot)) if (i == hi) break;
            while (less(pivot, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j); 
        return j; 
    }
    public static boolean less(Comparable i,Comparable j)
    {
        return i.compareTo(j)<0;
    }
    public static void exchange(Comparable []a,int i,int j)
    {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        
    }
    
}
