package model;

public class GoodsEntity {
    private double PPnBM;
    private double harga;
    private double PPn;

    public GoodsEntity(double PPnBM, double harga, double PPn) {
        this.PPnBM = PPnBM;
        this.harga = harga;
        this.PPn = PPn;
    }

    public GoodsEntity() {
    }

    public double getPPnBM() {
        return PPnBM;
    }

    public void setPPnBM(double PPnBM) {
        this.PPnBM = PPnBM;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getPPn() {
        return PPn;
    }

    public void setPPn(double PPn) {
        this.PPn = PPn;
    }

}
