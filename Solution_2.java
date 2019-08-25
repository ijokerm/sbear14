import java.util.Arrays;
import java.util.List;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(char val){
        this.val=val;
    }
}
public class Solution_2 {
//根据前序和中序遍历写出二叉树
    //掌握List的一些方法
   public static TreeNode buildTree1(List<Character>preorder,List<Character>inorder){
       if(preorder.size()==0){
           return null;
       }
       //汇总的思路 分根 左 右 子树
       //根
       char rootvalue=preorder.get(0);
       int leftcount=inorder.indexOf(rootvalue);
       TreeNode root=new TreeNode(rootvalue);//只需一个新的根节点
       //左
       List<Character>leftPreorder=preorder.subList(1,1+leftcount);
       List<Character>leftInorder=inorder.subList(0,leftcount);
       TreeNode left=buildTree1(leftPreorder,leftInorder);//递归
       root.left=left;
       // 右
       List<Character>rightPreorder=preorder.subList(1+leftcount,preorder.size());
       List<Character>rightInorder=inorder.subList(leftcount+1,inorder.size());
       TreeNode right=buildTree1(rightPreorder,rightInorder);
       root.right=right;

return root;

   }
//根据中序和后序遍历写出二叉树
   public static TreeNode buildTree2(List<Character>inorder,List<Character>postorder){
        if(postorder.size()==0){
            return null;
        }
        //取根植下标
    char rootvalue=postorder.get(postorder.size()-1);
    int leftcount=inorder.indexOf(rootvalue);
    TreeNode root=new TreeNode(rootvalue);
    //左
    List<Character>leftInorder=inorder.subList(0,leftcount);
    List<Character>leftPostorder=postorder.subList(0,leftcount);
    TreeNode left=buildTree2(leftInorder,leftPostorder);
    root.left=left;
// 右
       List<Character>rightInorder=inorder.subList(leftcount+1,inorder.size());
       List<Character>rightPostorder=postorder.subList(leftcount,postorder.size()-1);
       TreeNode right=buildTree2(rightInorder,rightPostorder);
       root.right = right;
   return root;
   }




    public static void main(String[] args) {
     List<Character>preorder= Arrays.asList('A','B','D','E','G','C','F','H');
List<Character>inorder=Arrays.asList('D','B','G','E','A','C','F','H');
TreeNode root=buildTree1(preorder,inorder);
System.out.println(root);
List<Character>postorder=Arrays.asList('D','G','E','B','H','F','C','A');
TreeNode root1=buildTree2(inorder,postorder);
        System.out.println(root1);
    }
}
