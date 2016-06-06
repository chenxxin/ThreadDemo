package tree;

import tree.BinaryTreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xin on 2016/5/6.
 */
public class TreeTest {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);


        System.out.println(leafNodeNum(root));

    }
    //二叉树的节点数
    public static int count(BinaryTreeNode root){
        if (root==null){
            return 0;
        }
        return count(root.left)+count(root.right)+1;
    }

    //计算二叉树的叶子节点的个数
    public static int leafNodeNum(BinaryTreeNode root){
        if (root==null) {
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        return leafNodeNum(root.left)+leafNodeNum(root.right);
    }

    // 从上往下打印二叉树，层次遍历
    public void levelOrder(BinaryTreeNode root){
        if (root==null){
            System.out.println("这是一棵空树");
            System.exit(0);
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (queue.size()>0){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
    //前序遍历
    public static void preOrder(BinaryTreeNode root){
        if (root!=null){
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(BinaryTreeNode root){
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    //广义表的形式打印二叉树
    public static void printTree(BinaryTreeNode root){
        if (root!=null){
            System.out.print(root.value);
            if (root.left!=null || root.right!=null){
                System.out.print("(");
                printTree(root.left);
                if (root.right!=null){
                    System.out.print(",");
                }
                printTree(root.right);
                System.out.print(")");
            }
        }
    }

    //二叉树的深度
    public static int depth(BinaryTreeNode root){
        if (root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left>right?left+1:right+1;
    }

    //已知前序和中序，重建二叉树
    public static BinaryTreeNode rebuild(int[] preOrder,int[] inOrder,int n,BinaryTreeNode root){
        if (preOrder==null || inOrder==null) return null;
        root = new BinaryTreeNode(preOrder[0]);
        if (n==1){
            return root;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (inOrder[i]==preOrder[0]){
                break;
            }
        }
        int left = i;
        int right = n-left-1;
        if(left>0){
            root.left = rebuild(Arrays.copyOfRange(preOrder,1,left+1),inOrder,left,root.left);
        }
        if(right>0){
            root.right = rebuild(Arrays.copyOfRange(preOrder,left+1,n),Arrays.copyOfRange(inOrder, left + 1, n),right,root.right);
        }
        return root;
    }

    public BinaryTreeNode fun(BinaryTreeNode root){
        if (root.right==null){
            return root.left;
        }
        if (root.left.right!=null){
            BinaryTreeNode temp = root.right;
            while(temp!=null){
                if (temp.left==null){
                    temp.left = root.left.right;
                    break;
                }
                temp = temp.left;
            }
        }
        root.left.right = root.right;
        return root.left;
    }
}
