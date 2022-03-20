package controller;

import model.PersonEntity;

public class IncomeTaxController {

    public Double getCleanIncome(PersonEntity person) {
        Double bruto = 0.0, mandatoryFees = 0.0;

        bruto = person.getBruto().getBruto();
        for(Double mandatoryFee : person.getMandatoryFees().getMandatoryFees()) {
            mandatoryFees += mandatoryFee;
        }

        return bruto - mandatoryFees;
    }
}
