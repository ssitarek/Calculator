package Calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator implements CalculatorInterface {

    private List<String> operationsList;
    private int lastLineNumber = -1;
    private double initialValue;

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
    Double calculateSingleCommand(Double inputValue, String inputString) {

        Double result = null;
        String[] strings = inputString.split(" ");
        if (strings.length != 2) {
            return null;
        }

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