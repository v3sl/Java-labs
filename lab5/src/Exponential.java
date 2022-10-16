public class Exponential extends Series {

    public Exponential(double firstElement, int numberOfElements, double step) {
        super(firstElement, numberOfElements, step);
    }

    public Exponential() {
        super(0, 0, 0);
    }

    @Override
    public double findJElement(int j) {
        return super.getFirstElement() * Math.pow(super.getStep(), j - 1);
    }
}