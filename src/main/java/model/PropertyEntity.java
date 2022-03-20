package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vo.LandArea;
import vo.LandValue;
import vo.BuildingArea;
import vo.BuildingValue;

@Setter
@Getter
@NoArgsConstructor

public class PropertyEntity {
    private LandArea landArea;
    private LandValue landValue;
    private BuildingArea buildingArea;
    private BuildingValue buildingValue;
}
