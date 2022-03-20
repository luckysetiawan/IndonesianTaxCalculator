package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LandValue {
    private Double landValue;

    public LandValue(Double landValue) throws Exception {
        if (landValue.isNaN())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NAN.getMessage(), "Bruto"));
        if (landValue <= 0.0)
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Bruto"));

        this.landValue = landValue;
    }
}
