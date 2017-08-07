package main.model;

/**
 * Model class for holding data that is necessary for rsa encryption.
 */
public class EncryptionData {

    /**
     * Public key for encryption.
     */
    private int e;

    /**
     * Public number for encryption.
     */
    private int n;

    /**
     * First prime factor of n.
     */
    private int p;

    /**
     * Second prime factor of n.
     */
    private int q;

    /**
     * Private key for decryption.
     */
    private int d;

    public EncryptionData() {}

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getPhiN() {
        return (p - 1) * (q - 1);
    }
}
