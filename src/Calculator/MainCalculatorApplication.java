package Calculator;

import java.io.FileNotFoundException;

public class MainCalculatorApplication {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide any file");
            return;
        }

        for (String arg: args){
            String fileName = arg;
            Calculator calculator = new Calculator();
            try {
                Double result = calculator.calculateResult(fileName);
                if (result != null) {
                    System.out.println("Result = " + result);
                } else {
                    System.out.println(String.format("Wrong result. Please check the file   '%s'   if there are proper commands inside.", fileName));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File '" + fileName + "' not found");
            }
        }
    }
}