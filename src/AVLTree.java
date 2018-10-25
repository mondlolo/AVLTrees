

import java.util.*;
import java.io.*;

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int compareVariable = 0;
   public int counter = 0;
   public int getCompareVariable(){
     return compareVariable;
   }
   public int getCounter(){
     return counter;
   }
   public int height ( BinaryTreeNode<dataType> node)
   {
      if (node != null)
         return node.height;
      return -1;
   }

   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }

   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }

   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( dataType k,dataType d )
   {
      root = insert (k,d, root);
   }
   public BinaryTreeNode<dataType> insert ( dataType k,dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (k,d, null, null);
      if (k.compareTo (node.key) <= 0){
         compareVariable++;
         node.left = insert (k,d, node.left);
         //compareVariable++;
      }else{
         compareVariable++;
         node.right = insert (k,d, node.right);
      }
      return balance (node);
   }

   public void delete ( dataType d )
   {
      root = delete (d, root);
   }
   public BinaryTreeNode<dataType> delete ( dataType k, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (k.compareTo (node.key) < 0)
         node.left = delete (k, node.left);
      else if (k.compareTo (node.key) > 0)
         node.right = delete (k, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }

   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode<dataType> find ( dataType k, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) == 0){
         counter++;
         return node;
      }
      else if (k.compareTo (node.key) < 0){
         counter++;
         return (node.left == null) ? null : find (k, node.left);

      }
      else{
         counter++;
         return (node.right == null) ? null : find (k, node.right);
       }
   }

   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}
