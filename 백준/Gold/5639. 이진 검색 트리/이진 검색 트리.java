import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

        // 노드 삽입하는 메서드
        void insert(int n) {
            if (n < this.val) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        // 입력이 없을 때까지 노드 삽입
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        // 후위 순회
        postOrder(root);
    }

    // 왼쪽 -> 오른쪽 -> 루트 순서로 출력
    static void postOrder(Node node) {
        if (node == null)
            return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}