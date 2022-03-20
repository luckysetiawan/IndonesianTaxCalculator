package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vo.AssessableStatus;
import vo.Gross;
import vo.MandatoryFees;

@Setter
@Getter
@NoArgsConstructor
public class PersonEntity {
    private Gross gross;
    private MandatoryFees mandatoryFees;
    private AssessableStatus assessableStatus;
}
