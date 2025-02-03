// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    int height(Node node){
        return node == null ? -1 : 1 + Math.max(height(node.left), height(node.right));
    }
}
