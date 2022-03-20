package controller;

import model.GoodsEntity;
import model.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.AssessableStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuxuryGoodsControllerTest {
    LuxuryGoodsController luxuryGoodsController = new LuxuryGoodsController();

    GoodsEntity good = new GoodsEntity();

    @BeforeEach
    public void initUseCase() throws Exception {
        good = new GoodsEntity();
    }

    @Test
    void itShouldCalculatePPNBM() throws Exception {

        Double expected = 2000000000 * 0.4;
        good.setPPnBM(0.4);
        good.setHarga(2000000000);
        Double actual = luxuryGoodsController.getPPNBM(good);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldCalculatePPN() throws Exception {

        Double expected = 0.1 * (2000000000 - (2000000000 * 0.4));
        good.setPPnBM(0.4);
        good.setHarga(2000000000);
        Double actual = luxuryGoodsController.getPPN(good);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldCalculatePPNBMTotal() throws Exception {
        Double expected = 2000000000 + (0.1 * (2000000000 - (2000000000 * 0.4))) + (2000000000 * 0.4);
        good.setPPnBM(0.4);
        good.setHarga(2000000000);
        Double actual = luxuryGoodsController.getPPNBMTotal(good);
        assertEquals(expected, actual, 0.0001);
    }
}