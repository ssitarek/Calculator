package Calculator;

import java.io.FileNotFoundException;

public interface CalculatorInterface {

    String LAST_LINE_MARKER = "APPLY";
    String MATH_ADD = "ADD";
    String MATH_SUBTRACT = "SUBTRACT";
    String MATH_MULTIPLY = "MULTIPLY";
    String MATH_DIVIDE = "DIVIDE";

    Double calculateResult(String fileName) throws FileNotFoundException;
}
