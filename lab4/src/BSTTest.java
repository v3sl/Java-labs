public class BSTTest {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(20);
        tree.insert(15);

        tree.recPreOrder(value -> value++);
        tree.recInOrder(System.out::println);
        tree.delete(5);
        tree.recPreOrder(value -> value++);
        tree.recInOrder(System.out::println);
    }
}