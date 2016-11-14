package problems.problem1;

/**
 * Created by xuhaoran on 14/11/2016.
 */
public class BstChangeToLink {

    private Node head, tail;

    private static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;

        Node(int value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private void traversal(Node node) {
        if (node == null) return;
        if (node.leftNode != null) traversal(node.leftNode);
        changeNode(node);
        if (node.rightNode != null) traversal(node.rightNode);
    }

    private void changeNode(Node node) {
        //初始时，双向链表中无节点，head及tail均为null
        if (head == null) {
            head = node;
            tail = node;
        } else {
            //将新node的左指针指向当前tail,再将当前tail的右指针指向新node，最后将tail后移
            node.leftNode = tail;
            tail.rightNode = node;
            tail = node;
        }
    }

    //头结点向后打印
    private void printHead() {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.rightNode;
        }
    }

    //尾节点向前打印
    private void printTail() {
        while (tail != null) {
            System.out.print(tail.value + " ");
            tail = tail.leftNode;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(4, null, null);
        Node node2 = new Node(8, null, null);
        Node node3 = new Node(12, null, null);
        Node node4 = new Node(16, null, null);
        Node node5 = new Node(6, node1, node2);
        Node node6 = new Node(14, node3, node4);
        Node node7 = new Node(10, node5, node6);
        BstChangeToLink t = new BstChangeToLink();
        t.traversal(node7);
        System.out.println("双向链表从头结点向后遍历:");
        t.printHead();
        System.out.println();
        System.out.println("双向链表从尾结点向前遍历:");
        t.printTail();
    }


}
