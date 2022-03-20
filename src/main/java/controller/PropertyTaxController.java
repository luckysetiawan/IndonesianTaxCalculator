package controller;

import model.PropertyEntity;

public class PropertyTaxController {

    //Nilai Jual Objek Pajak
    public Double getNJOP(PropertyEntity property) {
        Double landValue = property.getLandValue().getLandValue();
        Double landArea = property.getLandArea().getLandArea();
        Double buildingValue = property.getBuildingValue().getBuildingValue();
        Double buildingArea = property.getBuildingArea().getBuildingArea();

        return (landValue*landArea) + (buildingValue*buildingArea);
    }

    //Nilai Jual Kena Pajak
    public Double getNJKP(PropertyEntity property){
        Double njop = getNJOP(property);
        
        return 0.4 * njop;
    }

    //Pajak Bumi dan Bangunan
    public Double getPBB(PropertyEntity property){
        Double njkp = getNJKP(property);

        return 0.5 * njkp;
    }
}
