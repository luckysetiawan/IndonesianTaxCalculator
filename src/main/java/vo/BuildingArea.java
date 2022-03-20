package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BuildingArea {
    private Double buildingArea;

    public BuildingArea(Double buildingArea) throws Exception {
        if (buildingArea.isNaN())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NAN.getMessage(), "Bruto"));
        if (buildingArea <= 0.0)
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Bruto"));

        this.buildingArea = buildingArea;
    }
}
