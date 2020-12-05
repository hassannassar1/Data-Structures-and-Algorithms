/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures_and_algorithms;

/**
 *
 * @author Hassan
 */
public class InsertionSort {
    public static void sort(Comparable []a)
    {
        for (int i = 1; i < a.length; i++)
        { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
        for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
        exchange(a, j, j-1);
        }
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
