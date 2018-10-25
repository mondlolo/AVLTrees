

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{

  int compareVariable = 0;
  int countAll = 0;
   public void insert ( dataType k, dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (k,d, null, null);
      else
         insert (k,d, root);
   }
   public void insert ( dataType k, dataType d, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) <= 0){
          countAll++;
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (k,d, null, null);
         else
            insert (k,d, node.left);
      }
      else{
         countAll++;
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (k,d, null, null);
         else
            insert (k,d, node.right);
      }
   }

   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public int getCounter(){
     return compareVariable;
   }
   public int getCountAll(){
     return countAll;
   }
   public BinaryTreeNode<dataType> find ( dataType k, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) == 0){
         compareVariable++;
         return node;
      }
      else if (k.compareTo (node.key) < 0){
         compareVariable++;
         return (node.left == null) ? null : find (k, node.left);
      }
      else{
        compareVariable++;
         return (node.right == null) ? null : find (k, node.right);
      }
   }

   /*public void printFound(BinaryTreeNode<dataType> node){
      System.out.println(node.key);
   }*/

   public void delete ( dataType d )
   {
      root = delete (d, root);
   }
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.key) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.key) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.key = findMin (node.right).key;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }

   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }

}
