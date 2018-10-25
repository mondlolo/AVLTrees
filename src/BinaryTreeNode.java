

public class BinaryTreeNode<dataType>
{
   dataType data;
   dataType key;
   int height;

   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;

   public BinaryTreeNode ( dataType k,dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      key = k;
      data = d;
      left = l;
      right = r;
   }

   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
