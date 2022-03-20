package controller;

import model.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.Bruto;
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

        Double bruto = 100.0;
        List<Double> mandatoryFees = new ArrayList<>();
        mandatoryFees.add(35.0);
        mandatoryFees.add(5.0);
        mandatoryFees.add(10.0);

        person.setBruto(new Bruto(bruto));
        person.setMandatoryFees(new MandatoryFees(mandatoryFees));

    }

    @Test
    void itShouldCalculateCleanIncome() throws Exception {
        Double expected = 50.0;
        Double actual = incomeTaxController.getCleanIncome(person);

        assertEquals(expected, actual, 0.0001);
    }
}