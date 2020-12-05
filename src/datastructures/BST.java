/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Hassan
 * @param <Key>
 * @param <Value>
 */
public class BST <Key extends Comparable<Key>,Value>      //Binary Search Tree
{
    private Node root;
    private class Node
    {
       private Key key;
       private Value val;
       private Node right,left;
       private int N;
       public Node(Key key,Value val,int N)
       { 
           this.key = key; this.val = val; this.N = N;     
       }
    }
    private Value get(Node x, Key key)
    { 
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.N;
    }
    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }
    private Node max(Node x)
    {
        if (x.right == null) return x;
        return max(x.right);
    }
    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    private Node ceilling(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceilling(x.right, key);
        Node t = ceilling(x.left, key);
        if (t != null) return t;
        else return x;
    }
    private int rank(Key key, Node x)
    { // Return number of keys less than x.key in the subtree rooted
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
    private Node select(Node x, int k)
    { // Return Node containing key of rank k.
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }
    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
        if (x.right == null) return x.left;
        if (x.left == null) return x.right;
        Node t = x;
        x = min(t.right); // See page 407.
        x.right = deleteMin(t.right);
        x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private void keys(Node x, IQueue<Key> queue, Key lo, Key hi)
    {
    if (x == null) return;
    int cmplo = lo.compareTo(x.key);
    int cmphi = hi.compareTo(x.key);
    if (cmplo < 0) keys(x.left, queue, lo, hi);
    if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
    if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
    public Value get(Key key)
    { 
        return get(root, key); 
    }
    
    public int size()
    { 
        return size(root); 
    }
    public void put(Key key, Value val)
    { 
        root = put(root, key, val);
    }
    public Key min()
    {
        return min(root).key;
    }
    public Key max()
    {
        return max(root).key;
    }

    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    public Key ceilling(Key key)
    {
        Node x = ceilling(root, key);
        if (x == null) return null;
        return x.key;
    }
    public Key select(int k)
    {
        return select(root, k).key;
    }
    
    public int rank(Key key)
    { 
        return rank(key, root);
    }
    public void deleteMin()
    {
        root = deleteMin(root);
    }
    
    public void delete(Key key)
    { 
        root = delete(root, key);
    }
    
    public Iterable<Key> keys()
    { return keys(min(), max()); }
    public Iterable<Key> keys(Key lo, Key hi)
    {
    IQueue<Key> queue = new IQueue<>(50);
    keys(root, queue, lo, hi);
    return (Iterable<Key>) queue;
    }
    


    
}
