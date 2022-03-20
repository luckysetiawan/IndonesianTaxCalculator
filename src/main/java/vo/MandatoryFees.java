package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MandatoryFees {
    private List<Double> mandatoryFees;

    public MandatoryFees(List<Double> mandatoryFees) throws Exception {
        if (mandatoryFees.isEmpty())
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_EMPTY.getMessage(), "Mandatory Fees"));

        for (Double mandatoryFee : mandatoryFees) {
            if (mandatoryFee <= 0.0)
                throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Mandatory Fees"));
        }

        this.mandatoryFees = mandatoryFees;
    }
}
