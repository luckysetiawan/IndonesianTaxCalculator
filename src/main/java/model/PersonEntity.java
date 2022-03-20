package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vo.Bruto;
import vo.MandatoryFees;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PersonEntity {
    private Bruto bruto;
    private MandatoryFees mandatoryFees;
}
