package controller;

import exception.ValidationException;
import model.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        Double gross = 100.0;
        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(35.0);
        mandatoryFees.add(5.0);
        mandatoryFees.add(10.0);

        person.setGross(new Gross(gross));
        person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        Double expected = 50.0;
        Double actual = incomeTaxController.getNetIncome(person);

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
    void itShouldThrowNegativeGrossValidations() throws Exception {
        Double gross = -100.0;

        try {
            person.setGross(new Gross(gross));
        } catch (ValidationException exception) {
            String expected = "Gross must not be negative";
            String actual = exception.getMessage();

            assertEquals(expected, actual);
        }

        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(-1.0);

        try {
            person.setMandatoryFees(new MandatoryFees(mandatoryFees));
        } catch (ValidationException exception) {
            String expected = "Mandatory Fees must not be negative";
            String actual = exception.getMessage();

            assertEquals(expected, actual);
        }
    }
}