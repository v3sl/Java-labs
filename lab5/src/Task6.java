import java.util.Arrays;
import java.util.function.Predicate;

 public class Task6 {

    public static <T> boolean contains(T[] array, T element) {
        return Arrays.stream(array).anyMatch(el -> el.equals(element));
    }

    public static <T> long count(T[] array, T element){
        return Arrays.stream(array).filter(el -> el.equals(element)).count();
    }

    public static <T extends Comparable<T>> long countIfBigger(T[] array, T element){
        return Arrays.stream(array).filter(el -> el.compareTo(element) > 0).count();
    }

    public static <T extends Number> double sum(T[] array) {
        return Arrays.stream(array).mapToDouble(el -> el.doubleValue()).sum();
    } 

    public static <T extends CharSequence> String sum(T[] array) {
        return String.join("", array);
    }

    public static <T extends Number> double average(T[] array) {
        return sum(array)/array.length;
    }

    public static <T> long countIf(T[] array, Predicate<T> predicate){
        return Arrays.stream(array).filter(predicate).count();
    }
}