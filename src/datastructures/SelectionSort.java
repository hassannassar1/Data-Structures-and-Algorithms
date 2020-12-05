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
public class SelectionSort {
    public static void sort(Comparable []a)
    {
        
        for (int i =0;i<a.length;i++)
        {
            int min=i;
            for (int j=i+1;j<a.length;j++)
            {
                if(less(a[j],a[min]))min =j;
                
            }exchange(a,i,min);
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
