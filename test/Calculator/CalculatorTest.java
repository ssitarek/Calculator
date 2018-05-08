package Calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class CalculatorTest {

    private final double DELTA = 0.01;
    private Calculator calculator;

    @Before
    public void before() {
        calculator = new Calculator();
    }


    @Test
    public void divideByZeroEqualsInfinity() {
        String line = "divide 0";
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.calculateSingleCommand(5.0, line), DELTA);
    }

    @Test
    public void multiplyByZero() {
        String line = "multiply 0";
        Assert.assertEquals(0.0, calculator.calculateSingleCommand(5.0, line), DELTA);
    }

    @Test
    public void capitalLettersInName() {
        String line = "muLTipLY 2";
        Assert.assertEquals(10.0, calculator.calculateSingleCommand(5.0, line), DELTA);
    }

    @Test
    public void nullAsInitialValue() {
        String line = "multiply 2";
        Assert.assertNull(calculator.calculateSingleCommand(null, line));
    }


    @Test
    public void wrongFunctionNameBegin() {
        String line = "mmultiply 2";
        Assert.assertNull(calculator.calculateSingleCommand(5.0, line));
    }

    @Test
    public void checkResultIfListOfOperationsOk() throws FileNotFoundException {

        Assert.assertEquals(32, calculator.calculateResult("TestFile01.txt"), DELTA);
    }

    @Test
    public void checkNoOperationsInFile() throws FileNotFoundException {

        Assert.assertEquals(1, calculator.calculateResult("TestFile02.txt"), DELTA);
    }

    @Test
    public void checkDivideByZero() throws FileNotFoundException {

        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.calculateResult("TestFile03.txt"), DELTA);
    }

    @Test
    public void checkEmptyFile() throws FileNotFoundException {

        Assert.assertNull(calculator.calculateResult("TestFile04.txt"));
    }

    @Test
    public void checkMultipleApplyInFile() throws FileNotFoundException {

        Assert.assertEquals(32, calculator.calculateResult("TestFile05.txt"), DELTA);
    }


    @Test(expected = FileNotFoundException.class)
    public void checkWrongFileName() throws FileNotFoundException {

        calculator.calculateResult("TestFile06.txt");
    }
}