package vo;

import exception.ValidationException;
import exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssessableStatus {
    public Boolean isMarried;
    public Integer relativeCount;

    public AssessableStatus(Boolean isMarried, Integer relativeCount) throws Exception {
        if (isMarried == null) {
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NULL.getMessage(), "Marital status"));
        }
        if (relativeCount <= 0) {
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_NUMBER_NEGATIVE.getMessage(), "Relative count"));
        }

        this.isMarried = isMarried;
        this.relativeCount = relativeCount;
    }
}
