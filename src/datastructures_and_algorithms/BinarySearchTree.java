/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures_and_algorithms;

import static java.lang.Integer.max;
/**
 *
 * @author Hassan
 */
public class BinarySearchTree <Value>{
    private class Node
    {
        int data;
        Node right,left;
        Node()
        {
            
        }
        Node(int value)
        {
            data=value;
            right=null;
            left=null;
        }
    }
    private Node root = null;
    /*public BinarySearchTree()
    {
        root = new Node();
    }*/
    private void add(Node temp,int item)
    {
        if (item >temp.data)
        {
            if (temp.right!=null)
            {
                add(temp.right,item);
            }
            else
            {
                Node newnode = new Node(item);
                temp.right=newnode;
            }
        }
        else
        {
            if (temp.left!=null)
            {
                add(temp.left,item);
            }
            else
            {
                Node newnode = new Node(item);
                temp.left=newnode;
            }
        }
    }
    
    private int getMax(Node temp)
    {
        if (temp.right==null)return temp.data;
        else
        {
            return getMax(temp.right);
        }
        
    }
    private Node geMax(Node temp)
    {
        if (temp.right==null)return temp;
        else
        {
            return geMax(temp.right);
        }
        
    }
    private int getheight(Node temp)
    {
        if(temp==null)
        {
            return -1;
        }
        int leftH=getheight(temp.left);
        int rightH=getheight(temp.right);
        return 1+max(leftH,rightH);
    }
    private void preOrder(Node x,IQueue q)
    {
        if(x.right==null&&x.left==null)return;
        if (x.left!=null)
        {
            q.enqueue(x.left.data);
            preOrder(x.left,q);
        }
        if (x.right!=null)
        {
            q.enqueue(x.right.data);
            preOrder(x.right,q);
        }   
    }
    private void postOrder(Node x,IStack s)
    {
        if(x.right==null&&x.left==null)return;
        if (x.right!=null)
        {
            s.push(x.right.data);
            postOrder(x.right,s);
        }
        if (x.left!=null)
        {
            s.push(x.left.data);
            postOrder(x.left,s);
        }         
        
    }
    private void InOrder(Node x)      // The same we can do preorder and postorder 
    {
        if(x.left!=null)
        InOrder(x.left);
        System.out.println(x.data); 
        if(x.right!=null)
        InOrder(x.right);
        
    }
    public void RInsert(int item)
    {
        if (root == null)
        {
            Node newnode= new Node(item);
            root = newnode;
        }
        else
        {
            add(root,item);
        }
    }
    public void Insert(int item)
    {
        Node newnode = new Node();
        newnode.data=item;
        newnode.right=null;
        newnode.left=null;
        if (root == null)
        {
            root=newnode;   
            return;
        }
        
        Node temp=root;
        Node parent =null;
        while(temp!=null)
        {
            parent=temp;
            if (item <temp.data)
            {
              temp = temp.left;
            }
            else 
            {
              temp = temp.right;
            }
        }
        if (item>parent.data)
        {
         parent.right=newnode;   
        }
        else
        {
         parent.left=newnode;
        }
         
    }
    private void Remove(Node x,int it)
    {
        
    }
    public void Remove(int item)
    {
         if (root==null)return;
         
         Remove(root,item);
         Node temp =root;
         Node parent=null;
         if (root.data==item)
         {
             Node ew =  geMax(root.left);
         }
         while (item!=temp.data)
         {
             if(item>temp.data)
             {
             parent=temp;
             temp=temp.right;
             if(item==temp.data)
                {
                    if(temp.left==null&&temp.right==null)
                    {
                        parent.right=null;
                    }
                    else if (temp.left!=null||temp.right==null)
                    {
                        parent.right=temp.left;
                    }
                    else if (temp.left==null||temp.right!=null)
                    {
                        parent.right=temp.right;
                    }
                    else if (temp.left!=null&&temp.right!=null)
                    {
                        Node ew =  geMax(temp.left);
                        System.out.println(temp.left);
                        System.out.println(temp.right);
                        ew.left=temp.left;
                        ew.right=temp.right;
                        temp.left=null;
                        temp.right=null;
                        parent.right=ew;  
                    }
                }
             }
             else if(item<temp.data)
             {
             parent=temp;
             temp=temp.left;
                if(item==temp.data)
                {
                    if(temp.left==null&&temp.right==null)
                    {
                        parent.left=null;
                    }
                    else if (temp.left!=null||temp.right==null)
                    {
                        parent.left=temp.left;
                    }
                    else if (temp.left==null||temp.right!=null)
                    {
                        parent.left=temp.right;
                    }
                    else if (temp.left!=null&&temp.right!=null)
                    {
                        
                        /*int ew =  Max(temp.left);
                        temp.data = ew;
                        Remove(ew);*/
                        Node ew =  geMax(temp.left);
                        ew.left=temp.left;
                        ew.right=temp.right;
                        temp.left=null;
                        temp.right=null;
                        parent.left=ew;
                        
                    }
                }
             }
         }
    }
    
    public void preOrder()
    {
        if(root==null)return ;
        
        IQueue queue = new IQueue(20);
        queue.enqueue(root.data);
        preOrder(root,queue);
        queue.display();
    }
    
    public void postOrder()
    {
        if(root==null)return ;
        
        IStack stack = new IStack(20);
        stack.push(root.data);
        postOrder(root,stack);
        stack.display();
    }
    
    public void InOrder()
    {
        if(root==null)return ;
        InOrder(root);
    }

    public int height()
    {
        if (root ==null)
        {
            return -1;
        }
        
        return getheight(root);
        
    }
    public int Max()
    {
        Node temp=root;
        while (temp.right!=null)
        {
            temp=temp.right;
        }
        return temp.data;
        
    }
    public int Max(Node x)
    {
        Node temp=x;
        while (temp.right!=null)
        {
            temp=temp.right;
        }
        return temp.data;
        
    }
    public int Min()
    {
        Node temp=root;
        int min =-1;
        while (temp.left!=null)
        {
            temp=temp.left;
            min =temp.data;
        }
        return min;
        
    }
    public void levelOrder()
    {
        int height = height();
        for(int i = 0; i <= height; i++)
        {
            levelOrderTraversal(root, i);
        }
    }

    // Method for breadth first search
    public void levelOrderTraversal(Node node, int level)
    {
        if(node == null)
        {
            return;
        }
        if(level == 0)
        {
            System.out.print(node.data + " ");
        }
        else
        {
            levelOrderTraversal(node.left, level-1);
            levelOrderTraversal(node.right, level-1);
        }    
    }
       /* private void BFS(Node x)
    {
        //System.out.println(x.data); 
        if(x.left!=null)
        System.out.println(x.left.data);
        if(x.right!=null) 
        System.out.println(x.right.data);
        
        if(x.left!=null)
        BFS(x.left);
        if(x.right!=null) 
        BFS(x.right);
        
    }
    public void BFS()
    {
        if(root==null)return ;
        System.out.println(root.data);
        BFS(root);
    }
*/
}
