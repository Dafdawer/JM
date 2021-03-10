import java.util.Objects;

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber() {
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        int result = 19;

        long doubleRe = Double.doubleToLongBits(re);
        result = result * 37 + (int) (doubleRe ^ (doubleRe >>> 32));
        long doubleIm = Double.doubleToLongBits(im);
        result = result * 37 + (int) (doubleIm ^ (doubleIm >>> 32));

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.getRe(), getRe()) == 0 &&
                Double.compare(that.getIm(), getIm()) == 0;
    }
}