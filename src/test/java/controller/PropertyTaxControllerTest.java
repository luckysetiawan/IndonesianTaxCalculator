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

        Double landValue = 10000000.0;
        Double landArea = 300.0;
        Double buildingValue = 5000000.0;
        Double buildingArea = 240.0;

        property.setLandValue(new LandValue(landValue));
        property.setLandArea(new LandArea(landArea));
        property.setBuildingValue(new BuildingValue(buildingValue));
        property.setBuildingArea(new BuildingArea(buildingArea));


    }

    @Test
    void itShouldCalculateNJOP() throws Exception {
        Double expected = 4200000000.0;
        Double actual = propertyTaxController.getNJOP(property);

        assertEquals(expected, actual, 0.0001);
    }
    @Test
    void itShouldCalculateNJKP() throws Exception {
        Double expected = 840000000.0;
        Double actual = propertyTaxController.getNJOP(property);

        assertEquals(expected, actual, 0.0001);
    }
    @Test
    void itShouldCalculatePBB() throws Exception {
        Double expected = 4200000.0;
        Double actual = propertyTaxController.getNJOP(property);

        assertEquals(expected, actual, 0.0001);
    }
}