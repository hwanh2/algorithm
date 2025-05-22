import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Node head = new Node('A',null,null);
    static void insertNode(Node head,char rootValue,char leftValue,char rightValue){
        if(head.value==rootValue){
            head.left = (leftValue=='.'?null:new Node(leftValue,null,null));
            head.right = (rightValue=='.'?null:new Node(rightValue,null,null));
        }
        else{
            if(head.left!=null){
                insertNode(head.left,rootValue,leftValue,rightValue);
            }
            if(head.right!=null){
                insertNode(head.right,rootValue,leftValue,rightValue);
            }
        }
    }

    static void preOrder(Node node){
        if(node==null){
            return;
        }
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            insertNode(head,a,b,c);
        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        System.out.println(sb);

    }
}

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
