package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BuildingValue {
    private Double buildingValue;

    public BuildingValue(Double buildingValue) throws Exception {
        if (buildingValue.isNaN())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NAN.getMessage(), "Bruto"));
        if (buildingValue <= 0.0)
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Bruto"));

        this.buildingValue = buildingValue;
    }
}
