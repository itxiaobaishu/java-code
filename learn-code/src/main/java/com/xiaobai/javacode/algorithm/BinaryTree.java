package com.xiaobai.javacode.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xiaobai
 * @description: 如何打印二叉树每层的节点
 * @date 2021/1/5 10:26 上午
 */
public class BinaryTree {

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    //保存根左右的序列
    public ArrayList<Integer> gzy;

    //保存左根右的序列
    public ArrayList<Integer> zgy;

    //保存已经排好的节点
    public ArrayList<Node> pack;

    public void getResult() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        gzy = new ArrayList<>();
        zgy = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            gzy.add(scanner.nextInt());
        }
        for (int j = 0; j < count; j++) {
            zgy.add(scanner.nextInt());
        }
        pack = new ArrayList<>();

        if (count == 1) {
            System.out.println(gzy.get(0));
            return;
        }
        //构造最左侧节点的二叉树
        Node node = new Node(gzy.get(0));
        pack.add(node);
        //根左右的下标
        int index1 = 1;
        Node tmp = node;

        while (gzy.get(index1) != zgy.get(0)) {
            //如果没访问到最左边的叶子节点，继续还原最左侧二叉树
            tmp.left = new Node(gzy.get(index1++));
            tmp = tmp.left;
            pack.add(tmp);
        }
        tmp.left = new Node(gzy.get(index1++));
        pack.add(tmp.left);
        //加入剩余的节点完善二叉树
        for (int k = index1; k < gzy.size(); k++) {
            fillErCS(gzy.get(k));
        }
        //层次遍历
        ArrayList<Node> res = new ArrayList<>();
        res.add(node);
        int num = 0;
        while (res.size() != num) {
            System.out.println(res.get(num).val + "");
            if (res.get(num).left != null) {
                res.add(res.get(num).left);
            }
            if (res.get(num).right != null) {
                res.add(res.get(num).right);
            }
            num++;
        }


    }

    //将值为val的节点加入二叉树
    private void fillErCS(Integer val) {
        int index = zgy.indexOf(val);
        //每一个遍历的节点都是val节点的根或者在其左边
        for (int i = index - 1; i >= 0; i--) {
            if (findNode(zgy.get(i)) != null) {
                //找到待插入节点的根节点或者其左边的节点
                Node node = findNode(zgy.get(i));
                insert(node, val);
                break;
            }

        }
    }

    //将节点val插入二叉树
    private void insert(Node node, Integer val) {
        if (zgy.indexOf(node.val) > zgy.indexOf(val)) {
            //node在待插入节点的右边
            if (node.left == null) {
                node.left = new Node(val);
                pack.add(node.left);
                return;
            }
            insert(node.left, val);
        } else {
            //node在待插入节点的左边或者是其根
            if (node.right == null) {
                node.right = new Node(val);
                pack.add(node.right);
                return;
            }
            insert(node.right, val);
        }
    }

    //根据val找到pack里的节点
    private Node findNode(int val) {
        for (Node node : pack) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.getResult();
    }


}
