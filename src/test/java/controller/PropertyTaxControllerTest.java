package controller;

import model.PropertyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.LandArea;
import vo.LandValue;
import vo.BuildingArea;
import vo.BuildingValue;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyTaxControllerTest {

    PropertyTaxController propertyTaxController = new PropertyTaxController();

    PropertyEntity property = new PropertyEntity();

    @BeforeEach
    public void initUseCase() throws Exception {
        property = new PropertyEntity();

        Double landValue = 100.0;
        Double landArea = 30.0;
        Double buildingValue = 50.0;
        Double buildingArea = 24.0;

        property.setLandValue(new LandValue(landValue));
        property.setLandArea(new LandArea(landArea));
        property.setBuildingValue(new BuildingValue(buildingValue));
        property.setBuildingArea(new BuildingArea(buildingArea));
    }

    @Test
    void itShouldCalculateNJOP() throws Exception {
        Double expected = 4200.0;
        Double actual = propertyTaxController.getNJOP(property);

        assertEquals(expected, actual, 0.0001);
    }
    @Test
    void itShouldCalculateNJKP() throws Exception {
        Double expected = 1680.0;
        Double actual = propertyTaxController.getNJKP(property);

        assertEquals(expected, actual, 0.0001);
    }
    @Test
    void itShouldCalculatePBB() throws Exception {
        Double expected = 840.0;
        Double actual = propertyTaxController.getPBB(property);

        assertEquals(expected, actual, 0.0001);
    }
}