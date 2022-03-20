package controller;

import model.PropertyEntity;

public class PropertyTaxController {

    // public Double getLandNJOP(PropertyEntity property) {
    //     double landNJOP = 0.0;
    //     double landValue = 0.0, landArea = 0.0;
    //     landValue = property.getLandValue().getLandValue;
    //     landArea = property.getLandArea().getLandArea;

    //     landNJOP = (landValue*landArea);
    //     return landNJOP;
    // }

    // public Double getBuildingNJOP(PropertyEntity property) {
    //     double buildingNJOP = 0.0;
    //     double buildingValue = 0.0, buildingArea = 0.0;

    //     buildingValue = property.getBuildingValue().getBuildingValue;
    //     buildingArea = property.getBuildingArea().getBuildingArea;

    //     buildingNJOP = (buildingValue*buildingArea);
    //     return buildingNJOP;
    // }

    //Nilai Jual Objek Pajak
    public Double getNJOP(PropertyEntity property) {
        double njop = 0.0;
        double landValue = 0.0, landArea = 0.0;
        double buildingValue = 0.0, buildingArea = 0.0;
        landValue = property.getLandValue().getLandValue();
        landArea = property.getLandArea().getLandArea();
        buildingValue = property.getBuildingValue().getBuildingValue();
        buildingArea = property.getBuildingArea().getBuildingArea();

        njop = (landValue*landArea) + (buildingValue*buildingArea);
        // njop = getLandNJOP(property) + getBuildingNJOP(property);

        return njop;
    }

    //Nilai Jual Kena Pajak
    public Double getNJKP(PropertyEntity property){
        double njkp = 0.0;
        double njop = getNJOP(property);
        
        njkp =  0.4 * njop;

        return njkp;
    }

    //Pajak Bumi dan Bangunan
    public Double getPBB(PropertyEntity property){
        double pbb = 0.0;
        double njkp = getNJKP(property);

        pbb = 0.5 * njkp;

        return pbb;
    }
}
