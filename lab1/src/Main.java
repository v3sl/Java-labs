public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2)
                throw new IllegalArgumentException("Incorrect input");
            double answer = calculateRow(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            System.out.println(answer);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static double calculateRow(double x, double accuracy) {
        double current = (double) -1 * 2 * x / 3;
        return current + calculateRow(x, accuracy, 1, current);
    }

    private static double calculateRow(double x, double accuracy, int k, double previous) {
        if (Math.abs(previous) < Math.abs(accuracy))
            return 0;
        double current = (double) previous * (-1) * x * (k + 2) / (3 * (k + 1));
        return current + calculateRow(x, accuracy, k + 1, current);
    }
}