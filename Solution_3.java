import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int val){
        this.val=val;
    }
}
public class Solution_3{
    //利用数组求出由前序中序遍历的树
    public static TreeNode1 buildTree1(int[] preorder, int[] inorder){
        if(preorder.length==0){
            return null;
        }
        //汇总的思路 分根 左 右 子树
        //根
        int rootvalue=preorder[0];
        int leftcount=-1;
        for(int i=0;i<preorder.length;i++){
            if(inorder[i]==rootvalue){
                leftcount=i;
            }
        }
        //只需一个新的根节点
        TreeNode1 root=new TreeNode1(rootvalue);
 int[] leftpreorder= Arrays.copyOfRange(preorder,1,1+leftcount);
 int[] leftinorder= Arrays.copyOfRange(inorder,0,leftcount);
 TreeNode1 left=buildTree1(leftpreorder,leftinorder);
 root.left=left;
        //for循环的遍历  copyOfrange（）
        //左
  int[] rightpreorder=Arrays.copyOfRange(preorder,leftcount,preorder.length-1);
  int[] rightinorder=Arrays.copyOfRange(inorder,1+leftcount,inorder.length);
  TreeNode1 right=buildTree1(rightpreorder,rightinorder);
  root.right=right;
  // 右
        return root;
    }

    public static class ReturnValue{
        TreeNode1 root;
        int used;
    }
    //只给出前序遍历求二叉树
    public static ReturnValue buildTreepre(List<Character>preorder){
        //1.构建出树
        //2.返回调用者构建过程用掉的值得个数
        //方法需要返回两个值
        int rootValue=preorder.get(0);
        if(preorder.size()==0){
           ReturnValue rv=new ReturnValue();
           rv.root=null;
           rv.used=0;
            return rv;
       }
       if(rootValue=='#'){
           ReturnValue rv=new ReturnValue();
           rv.root=null;
           rv.used=1;
           return rv;
       }
        ReturnValue leftRe=buildTreepre(preorder.subList(1,preorder.size()));
        ReturnValue righRe=buildTreepre(preorder.subList(1+leftRe.used,preorder.size()));
        //新定义的是变化的根节点
        TreeNode1 root=new TreeNode1(0);

        root.val=rootValue;
        root.left=leftRe.root;
        root.right=righRe.root;

        ReturnValue rv=new ReturnValue();
        rv.root=root;
        return rv;
    }

    public static void main(String[] args) {

    }
}