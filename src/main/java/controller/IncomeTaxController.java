package controller;

import model.PersonEntity;

public class IncomeTaxController {

    public Double getNetIncome(PersonEntity person) {
        Double gross = 0.0, mandatoryFees = 0.0;

        gross = person.getGross().getGross();
        for(Double mandatoryFee : person.getMandatoryFees().getMandatoryFees()) {
            mandatoryFees += mandatoryFee;
        }

        return gross - mandatoryFees;
    }
}
