package Calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator implements CalculatorInterface {

    // in case of this application there is no necessary to have any getter and setter because variables are used only inside this class
    private List<String> operationsList;
    private int lastLineNumber;
    private double initialValue;

    public Calculator() {
        // it is not necessary here, all this constructor can be removed in case of declaration like this:  private int lastLineNumber-1;
        this.lastLineNumber = -1;
    }

    @Override
    public Double calculateResult(String fileName) throws FileNotFoundException {

        loadOperationListFromFile(fileName);
        searchForLastLineAndInitialValue();
        if (lastLineNumber == -1) {
            return null;
        }

        Double result = initialValue;
        for (int i = 0; i < lastLineNumber; i++) {
            result = calculateSingleCommand(result, operationsList.get(i));
        }
        return result;
    }

    private void searchForLastLineAndInitialValue() {

        //I need value of i as a lastLineNumber
        //it is possible to use foreach, but then I need to use some counter in place of "i" in the line: lastLineNumber = i;
        for (int i = 0; i < operationsList.size(); i++) {
            String[] strings = operationsList.get(i).split(" ");
            if (strings.length != 2) {
                break;
            }

            if (lastLineNumber == -1 && LAST_LINE_MARKER.equals(strings[0].toUpperCase())) {
                lastLineNumber = i;
                initialValue = Double.valueOf(strings[1]);
                break;
            }
        }
    }


    /**
     * method returns list of string with mathematical instructions from *.txt file
     *
     * @param fileName name of txt-file
     * @throws FileNotFoundException in case of no file
     */
    private void loadOperationListFromFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);

        Scanner scanner = new Scanner(file);
        String singleLine;
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            singleLine = scanner.nextLine();
            lines.add(singleLine);
        }
        scanner.close();

        operationsList = lines;
    }

    /**
     * calculates single command from input string
     *
     * @param inputValue  initial value that is taken to calculations
     * @param inputString one line of command that contains operation and value with blank space between e.g. "add 2"
     * @return result of operation
     */
    // calculateSingleCommand should be private but I did not make it private due to the fact that I want to show some tests.
    Double calculateSingleCommand(Double inputValue, String inputString) {

        Double result = null;
        String[] strings = inputString.split(" ");
        if (strings.length != 2) {
            return null;
        }

        // section of "if" statements with proper commands.
        // in case of wrong command e.g. mmultiply with double "m" inside the null value will be return because of the line: Double result = null;
        if (MATH_ADD.equals(strings[0].toUpperCase())) {
            Double newNumber = convertStringToValue(strings[1]);
            result = (inputValue != null && newNumber != null) ? inputValue += newNumber : null;
        }
        if (MATH_SUBTRACT.equals(strings[0].toUpperCase())) {
            Double newNumber = convertStringToValue(strings[1]);
            result = (inputValue != null && newNumber != null) ? inputValue -= newNumber : null;
        }
        if (MATH_MULTIPLY.equals(strings[0].toUpperCase())) {
            Double newNumber = convertStringToValue(strings[1]);
            result = (inputValue != null && newNumber != null) ? inputValue *= newNumber : null;
        }
        if (MATH_DIVIDE.equals(strings[0].toUpperCase())) {
            Double newNumber = convertStringToValue(strings[1]);
            result = (inputValue != null && newNumber != null) ? inputValue /= newNumber : null;
        }

        return result;
    }


    /**
     * method converts string to Double
     *
     * @param inputString that contains value
     * @return value
     */
    private Double convertStringToValue(String inputString) {

        try {
            return Double.valueOf(inputString);
        } catch (NumberFormatException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }

    }
}