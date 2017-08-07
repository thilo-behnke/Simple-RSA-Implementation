package main.model;

/**
 * Model class for holding data is necessary for extended Euclidean Algorithm.
 */
public class EuclideanData {

    private int a;
    private int b;
    private int s;
    private int t;

    public EuclideanData(int a, int b, int s, int t) {
        this.a = a;
        this.b = b;
        this.s = s;
        this.t = t;
    }

    public int getA() {
        return a;
    }

    public int getT() {
        return t;
    }

}
