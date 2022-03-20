package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Bruto {
    private Double bruto;

    public Bruto(Double bruto) throws Exception {
        if (bruto.isNaN())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NAN.getMessage(), "Bruto"));
        if (bruto <= 0.0)
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Bruto"));

        this.bruto = bruto;
    }
}
