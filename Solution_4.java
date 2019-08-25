import java.util.LinkedList;
import java.util.Queue;

class Node1{
    int val;
    Node1 left;
    Node1 right;
    Node1(int val){
        this.val=val;
    }
}


public class Solution_4 {
    //计算二叉树高度
    public static int calcHigh(Node1 root) {
        if (root == null) {
            return 0;
        }
        int left = calcHigh(root.left);
        int right = calcHigh(root.right);
        int high = Math.max(left, right);
        return high;
    }
    //判断是否为平衡树
    public static boolean isBalanced(Node1 root){
        if(root==null){
            return true;
        }
        //boolean的用法 jdk看一看
        boolean left=isBalanced(root.left);
        if(!left){
            return false;
        }
        boolean right=isBalanced(root.right);
        if(!right){
            return false;
        }

        int leftheigh=calcHigh(root.left);
        int rightheigh=calcHigh(root.right);
        int diff=leftheigh-rightheigh;
        if(diff>1||diff<-1){
            return false;
        }
        return true;

    }
    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先 。
    public static boolean search(Node1 root,Node1 v){
        if(root==null){
            return false;
        }

        if(root==v){
            return true;
        }
        Node1 left=root.left;
        Node1 right=root.right;
        if(left==v){
            return true;
        }
        return search(right,v);
    }

    public static Node1 lowestCommonAncestor(Node1 root,Node1 p,Node1 q){
        if(root==p||root==q){
            return root;
        }
        //判断p q 是否都在左边
        //判断结点（引用）
        boolean pINleft=search(root.left,p);
        boolean qINleft=search(root.left,q);
        if(pINleft&&qINleft){
        return lowestCommonAncestor(root.left,p,q);
        }
        if(!pINleft&&!qINleft){
            return  lowestCommonAncestor(root.right,p,q);
        }
       return root;
    }

    //层序遍历
    //利用队列实现
    public static void levelTravel(Node1 root){
        if(root==null){
            return;
        }
        Queue<Node1>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node1 front=queue.poll();
            System.out.println(front.val);
            if(front.left!=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
         return;

    }

    public static void main(String[] args) {

    }

}

