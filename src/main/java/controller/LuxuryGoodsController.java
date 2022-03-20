package controller;

import model.GoodsEntity;
import model.PersonEntity;

public class LuxuryGoodsController {

    // PPNBM (Pajak Penjualan Atas Barang Mewah)
    public Double getPPNBM(GoodsEntity good) {
        Double harga = good.getHarga();
        Double PPnBM = good.getPPnBM();

        return harga * PPnBM;
    }

    // PPN (Pajak Penjualan)
    public Double getPPN(GoodsEntity good) {
        Double harga = good.getHarga();

        return 0.1 * (harga - getPPNBM(good));
    }

    // PPNBM Total (Pajak Penjualan Atas Barang Mewah)
    public Double getPPNBMTotal(GoodsEntity good) {
        Double harga = good.getHarga();

        return harga + getPPNBM(good) + getPPN(good);
    }
}
