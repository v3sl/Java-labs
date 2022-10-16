import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public abstract class Series {

    public Series(double firstElement, int numberOfElements, double step) {
        this.firstElement = firstElement;
        this.numberOfElements = numberOfElements;
        this.step = step;
    }

    public abstract double findJElement(int j);

    public double sum() {
        double sum = 0;
        for (int i = 1; i <= numberOfElements; ++i) {
            sum += findJElement(i);
        }
        return sum;
    }

    public String toString() {
        String str = "";
        for (int i = 1; i <= numberOfElements; ++i) {
            str += String.valueOf(findJElement(i)) + " ";
        }
        return str;
    }

    public void writeToFile(String filepath) throws IOException {
        try (FileWriter writer = new FileWriter(Path.of(filepath).toFile())) {
            writer.write(toString() + '\n');
        }
    }

    public double getFirstElement() {
        return firstElement;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public double getStep() {
        return step;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setFirstElement(double firstElement) {
        this.firstElement = firstElement;
    }

    public void setStep(double step) {
        this.step = step;
    }

    private double firstElement;
    private int numberOfElements;
    private double step;
}
