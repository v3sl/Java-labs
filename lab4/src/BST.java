import java.util.Objects;
import java.util.function.Consumer;

public class BST<T extends Comparable<T>> {
    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public void insert(T value) {
        root = doInsert(root, value);
    }

    private Node doInsert(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = doInsert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = doInsert(node.right, value);
        }
        return node;
    }

    private Node root;

    public BST() {
    }

    public void delete(T value) {
        if (Objects.isNull(root)) {
            return;
        }
        root = delete(root, value);
    }

    private Node delete(Node node, T value) {
        if (node.value.compareTo(value) == 0) {
            if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                return null;
            }
            if (Objects.isNull(node.left)) {
                return node.right;
            }
            if (Objects.isNull(node.right)) {
                return node.left;
            }
            Node minimum = findMinimum(node.right);
            node.value = minimum.value;
            node.right = delete(node.right, minimum.value);
            return node;
        }
        if (node.value.compareTo(value) > 0) {
            if (Objects.isNull(node.left)) {
                return node;
            }
            node.left = delete(node.left, value);
            return node;
        }
        if (node.value.compareTo(value) < 0) {
            if (Objects.isNull(node.right)) {
                return node;
            }
            node.right = delete(node.right, value);
            return node;
        }
        return node;
    }

    private Node findMinimum(Node node) {
        if (Objects.isNull(node.left)) {
            return node;
        }
        return findMinimum(node.left);
    }

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(Node node, T value) {
        if (Objects.isNull(node)) {
            return false;
        }
        if (node.value.compareTo(value) == 0) {
            return true;
        }
        if (node.value.compareTo(value) > 0) {
            return find(node.left, value);
        }
        return find(node.right, value);
    }

    public void recPreOrder(Consumer<T> consumer) {
        recPreOrder(root, consumer);
    }

    private void recPreOrder(Node node, Consumer<T> consumer) {
        if (Objects.isNull(node)) {
            return;
        }
        consumer.accept(node.value);
        recPreOrder(node.left, consumer);
        recPreOrder(node.right, consumer);
    }

    public void recInOrder(Consumer<T> consumer) {
        recInOrder(root, consumer);
    }

    private void recInOrder(Node node, Consumer<T> consumer) {
        if (Objects.isNull(node)) {
            return;
        }
        recPreOrder(node.left, consumer);
        consumer.accept(node.value);
        recPreOrder(node.right, consumer);
    }

    public void recPostOrder(Consumer<T> consumer) {
        recPostOrder(root, consumer);
    }

    private void recPostOrder(Node node, Consumer<T> consumer) {
        if (Objects.isNull(node)) {
            return;
        }
        recPreOrder(node.left, consumer);
        recPreOrder(node.right, consumer);
        consumer.accept(node.value);
    }
}