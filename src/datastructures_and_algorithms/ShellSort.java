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
public class ShellSort {
    public static void sort(Comparable []a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; 
        while (h >= 1)
        { // h-sort the array.
        System.out.println(h);
        for (int i = h; i < N; i++)
        { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
        exchange(a, j, j-h);
        }
        h = h/3;
        
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
