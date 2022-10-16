public class Liner extends Series {

    public Liner(double firstElement, int numberOfElements, double step) {
        super(firstElement, numberOfElements, step);
    }

    public Liner() {
        super(0, 0, 0);
    }

    @Override
    public double findJElement(int j) {
        return super.getFirstElement() + (j - 1) * super.getStep();
    }
}