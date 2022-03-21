package controller;

import exception.ValidationException;
import model.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.AssessableStatus;
import vo.Gross;
import vo.MandatoryFees;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeTaxControllerTest {

    IncomeTaxController incomeTaxController = new IncomeTaxController();

    PersonEntity person = new PersonEntity();

    @BeforeEach
    public void initUseCase() throws Exception {
        person = new PersonEntity();
    }

    @Test
    void itShouldCalculateNetIncome() throws Exception {
        Double gross = 100000000.0;
        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(35000000.0);
        mandatoryFees.add(5000000.0);
        mandatoryFees.add(10000000.0);

        person.setGross(new Gross(gross));
        person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        Double expected = 50000000.0;
        Double actual = incomeTaxController.getNetIncome(person);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldCalculateNonTaxableIncome() throws Exception {
        person.setAssessableStatus(new AssessableStatus(true, 4));

        Double expected = 54000000.0 + 4500000.0 + (3 * 4500000);
        Double actual = incomeTaxController.getNonTaxableIncome(person);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldCalculateIncomeTax() throws Exception {
        Double gross = 100000000.0;
        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(35000000.0);
        mandatoryFees.add(5000000.0);
        mandatoryFees.add(10000000.0);
        person.setGross(new Gross(gross));
        person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        person.setAssessableStatus(new AssessableStatus(true, 4));
        Double expected = 50000000 * 0.05;
        Double actual = incomeTaxController.getIncomeTax(person);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldCalculateTaxableIncome() throws Exception {
        Double gross = 100000000.0;
        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(35000000.0);
        mandatoryFees.add(5000000.0);
        mandatoryFees.add(10000000.0);

        person.setGross(new Gross(gross));
        person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        person.setAssessableStatus(new AssessableStatus(true, 4));

        Double expected = (100000000.0 - 35000000.0 - 5000000.0 - 10000000.0) - (54000000.0 + 4500000.0 + (3 * 4500000));
        Double actual = incomeTaxController.getTaxableIncome(person);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void itShouldThrowEmptyValidation() throws Exception {
        try {
            person.setMandatoryFees(new MandatoryFees(new ArrayList<>()));
        } catch (ValidationException exception) {
            String expected = "Mandatory Fees must not be empty";
            String actual = exception.getMessage();

            assertEquals(expected, actual);
        }
    }

    @Test
    void itShouldThrowNegativeValidations() throws Exception {
        Double gross = -100000000.0;

        try {
            person.setGross(new Gross(gross));
        } catch (ValidationException exception) {
            String expected = "Gross must not be negative";
            String actual = exception.getMessage();

            assertEquals(expected, actual);
        }

        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(-10000000.0);

        try {
            person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        } catch (ValidationException exception) {
            String expected = "Mandatory Fees must not be negative";
            String actual = exception.getMessage();

            assertEquals(expected, actual);
        }
    }
}