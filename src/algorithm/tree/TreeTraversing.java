package algorithm.tree;

class Node {
    int data;
    int level;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}
class BinaryTree {
    Node node;

    int size;

    void add(int data) {
        this.size++;
        if (this.node == null) {
            this.node = new Node(data);
            this.node.level = 1;
        } else {
            add(this.node, data);
        }
    }

    void add(Node node1, int data) {
        if (node1.left == null) {
            node1.left = new Node(data); //insert at left
            node1.left.level = node1.level + 1;
            return;
        } else if (node1.right == null) {
            node1.right = new Node(data);
            node1.right.level = node1.level + 1;
            return;
        }

        Node leftNode = traverse(node1.left); //verify left side
        Node rightNode = traverse(node1.right);

        if (leftNode.level <= rightNode.level) {
            node1 = leftNode;
        } else {
            node1 = rightNode;
        }

        add(node1, data);
    }

    Node traverse(Node node) {
        if (node == null) return null;

        Node leftNode, rightNode;
        if (node.left == null || node.right == null) {
            return node;
        }
        leftNode = traverse(node.left);
        rightNode = traverse(node.right);
        if (leftNode.level <= rightNode.level) {
            return leftNode;
        }
        return rightNode;
    }

    /*
        This logic taken from: https://www.baeldung.com/java-print-binary-tree-diagram
        Intended just for knowledge.
     */
    public String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    /*
        This logic taken from: https://www.baeldung.com/java-print-binary-tree-diagram
        Intended just for knowledge.
     */
    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }
}
public class TreeTraversing {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.add(10);
        binaryTree.add(11);
        binaryTree.add(12);
        binaryTree.add(13);
        binaryTree.add(14);
        binaryTree.add(15);
        binaryTree.add(16);
        binaryTree.add(17);
        binaryTree.add(18);
        binaryTree.add(19);
        binaryTree.add(20);
        binaryTree.add(21);
        binaryTree.add(22);
        binaryTree.add(23);
        binaryTree.add(24);
        binaryTree.add(25);
        binaryTree.add(26);
        binaryTree.add(27);
        binaryTree.add(28);
        binaryTree.add(29);
        binaryTree.add(30);

        //System.out.println(binaryTree.display(binaryTree.node));
        System.out.println("Total elements in tree is, " + binaryTree.size);
        System.out.println(binaryTree.traversePreOrder(binaryTree.node));
    }
}


/*

    void addDD(int data) {
        if (this.node == null) {
            this.node = new Node(data);
        } else {
            Node node1 = this.node;
            int level = 0;
            boolean leftSide = false, rightSide = false;
            while (node1 != null) {
                if (node1.left == null) {
                    node1.left = new Node(data);
                    break;
                } else if (node1.right == null) {
                    node1.right = new Node(data);
                    break;
                }

                level++;

                if (level == 1) {
                    rightSide = true;
                }
                if (hasLevelFilled(node1) && leftSide){
                    node1 = this.node.right;
                    leftSide = false;
                    rightSide = true;
                } else if (hasLevelFilled(node1) && rightSide) {
                    node1 = this.node.left;
                    leftSide = true;
                    rightSide = false;
                } else {
                    node1 = node1.left;
                }
            }
        }
    }
        void display() {
        if (this.node == null) {
            System.out.println("Tree is empty.");
        } else {
            int mul = 1;
            Node node1 = this.node;
            int space = 20, slashSpace = 18, slashSpaceRight = 5;

            for (int i = 0; i < space; i++) System.out.print("\t");
            System.out.println("[" + node1.data + "]\n");
            space = 17;

            while (node1.left != null) {
                for (int i = 0; i < slashSpace; i++) System.out.print("\t");
                System.out.print("/");
                for (int i = 0; i < slashSpaceRight; i++) System.out.print("\t");
                System.out.print("\\ \n\n");
                for (int i = 0; i < space; i++) System.out.print("\t");
                System.out.print("[" + node1.left.data + "]");
                if (node1.right != null){
                    for (int i = 0; i < slashSpaceRight + 2; i++) System.out.print("\t");
                    System.out.print("[" + node1.right.data + "]\n\n");
                }

                /*mul *= 2;
                traverseDisplay(node1.left, mul / 2); //verify left side

                traverseDisplay(node1.right, mul / 2);

space -= 2;
slashSpace -= 1;
slashSpaceRight -= 1;
node1 = node1.left; //next level

            }
                    }
                    }

                        Node traverse(Node node, int level) {
        for (int i = 1; i <= level; i++) {
            Node node1 = (level > 2) ? (i % 2 != 0) ? node.left : node.right : node;
            if (node1.left == null || node1.right == null) {
                return node1;
            }
        }
        return null;
    }
    void add1(int data) {
        this.size++;
        if (this.node == null) {
            this.node = new Node(data);
            this.node.level = 1;
        } else {
            int level = 1;
            int mul = 1;
            Node node1 = this.node;

            while (true) {
                if (node1.left == null) {
                    node1.left = new Node(data); //insert at left
                    node1.level = ++level;
                    break;
                } else if (node1.right == null) {
                    node1.right = new Node(data);
                    node1.level = ++level;
                    break;
                }

                mul *= 2;
                Node node2 = traverse(node1.left, mul / 2); //verify left side

                if (node2 == null) node2 = traverse(node1.right, mul / 2);

                if (node2 == null) {
                    node1 = node1.left;
                } else {
                    node1 = node2;
                }
            }
        }
    }

 */
