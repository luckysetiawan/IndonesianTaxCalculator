package controller;

import model.Assessable;
import model.PersonEntity;

public class IncomeTaxController {

    // Penghasilan Bersih
    public Double getNetIncome(PersonEntity person) {
        Double gross = 0.0, mandatoryFees = 0.0;

        gross = person.getGross().getGross();
        for(Double mandatoryFee : person.getMandatoryFees().getMandatoryFees()) {
            mandatoryFees += mandatoryFee;
        }

        return gross - mandatoryFees;
    }

    // PTKP (Penghasilan Tidak Kena Pajak)
    public Double getNonTaxableIncome(PersonEntity person) {
        Double nonTaxableIncome = Assessable.PERSONAL.getAssessable();

        if (person.getAssessableStatus().getIsMarried()) {
            nonTaxableIncome += Assessable.MARRIED.getAssessable();
        }

        if (person.getAssessableStatus().getRelativeCount() > 0) {
            nonTaxableIncome += (
                    person.getAssessableStatus().getRelativeCount() > 3 ? 3 : person.getAssessableStatus().getRelativeCount()
            ) * Assessable.RELATIVES.getAssessable();
        }

        return nonTaxableIncome;
    }

    // PKP (Penghasilan Kena Pajak)
    public Double getTaxableIncome(PersonEntity person) {
        Double netIncome = getNetIncome(person);
        Double nonTaxableIncome = getNonTaxableIncome(person);

        return netIncome - nonTaxableIncome;
    }

    // Pajak Penghasilan (PPh)
    public Double getIncomeTax(PersonEntity person) {
        // TODO: add income tax calculation
        return 0.0;
    }
}
