package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Gross {
    private Double gross;

    public Gross(Double gross) throws Exception {
        if (gross.isNaN())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NAN.getMessage(), "Gross"));
        if (gross <= 0.0)
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Gross"));

        this.gross = gross;
    }
}
