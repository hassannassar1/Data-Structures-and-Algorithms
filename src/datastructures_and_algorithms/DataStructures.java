/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures_and_algorithms;

import java.io.IOException;
import static java.lang.System.in;

/**
 *
 * @author Hassan
 */
public class DataStructures{
    public static boolean less(Comparable a,Comparable b)
    {
        return a.compareTo(b)<0;
    }
    public static void merge(Comparable a[],int lo,int mid, int hi)
    {
        int i=lo; 
        int j= mid+1;
        Comparable []aux= new Comparable[a.length]; 
        for(int k=lo;k<hi;k++)
        {
            aux[k]=a[k];
        }
        for(int k=lo;k<hi;k++)
        {
            if (i>mid) a[k]=aux[j++];   
            else if (i<mid) a[k]=aux[i++];
            else if (less(aux[i],aux[j])) a[k]=aux[i++];
            else a[k]=aux[j++];
        }
            
    }
    public static void SelectionSort(int []a)
    {
        int min =0;
        for (int i=0;i<a.length;i++)
        {
            min= i;
            for (int j=i+1;j<a.length;j++)
            {
                if(a[j]<a[i])
                {
                    min = j;
                }
            }
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
        
    }
    public static void BubbleSort(int []a)
    {
        
        for (int i=0;i<a.length;i++)
        {
            for (int j=i+1;j<a.length;j++)
            {
                if(a[j]<a[i])
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
            
        }
        
    }
    public static void InsertionSort(int []a)
    {
        for (int i=1;i<a.length;i++)
        {
            for (int j=i;j>0&&j<a.length;j--)
            {
                if(a[j]<a[j-1])
                {
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        
    }
    public static boolean LinearSearch(int item,int []a)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==item)
                return true;
        }
        return false;
    }
    public static boolean BinarySearch(int item,int []a)
    {
        int start = 0;
        int end = a.length;
        int index;
        while(true)
        {
            if (start==end||start>end)return false;
            index = (start+end)/2;
            if(a[index]==item)
                return true;
            else if(a[index]>item)
            {
                end=index-1;
            }    
            else
            {
                start=index+1;
            }
                
        }
    }
        //return false;
    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        Comparable []a = {'q','d','a','c','v','o','b'};
        QuickSort b=new QuickSort();
        b.sort(a);
        for (int i=0;i<7;i++)System.out.println(a[i]);
        /*BinarySearchTree a = new BinarySearchTree();
        a.Insert(15);
        a.Insert(20);
        a.Insert(10);
        a.Insert(7);
        a.Insert(12);
        a.Insert(17);
        a.Insert(30);
        a.Insert(40);
        a.Insert(22);
        a.Insert(18);
        a.Insert(14);
        a.Insert(11);
        a.levelOrder();
        System.out.println();
        System.out.println(a.Max());
        a.Remove(30);
        a.levelOrder();
        System.out.println();
        System.out.println(a.Max());*/
        
        
    }
    
}
