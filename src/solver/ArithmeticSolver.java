package solver;

import exception.DivideByZeroException;
import exception.MathException;
import exception.SyntaxErrorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSolver {
    private String equation;

    private BigDecimal answer;

    private ArrayList<BigDecimal> numbers = new ArrayList<>();
    private ArrayList<Operator> operators = new ArrayList<>();

    public ArithmeticSolver(String equation) throws MathException {
        this.equation = equation;
        solve();
    }

    private void solve() throws MathException{
        System.out.println("at the beginning "+ equation);

        extractEquationToNumbersAndOperators();
        System.out.println("numbers: " + numbers.toString());
        System.out.println("operator: " + operators.toString());
        calculate();
    }

    private void extractEquationToNumbersAndOperators() throws SyntaxErrorException {
        System.out.println("extracting "+ equation);

        boolean isNegative = false;
        Integer numStartIndex = null;

        for (int i = 0; i < equation.length(); i++) {
            char oneChar = equation.charAt(i);
            if(Character.isDigit(oneChar) || oneChar == '.'){
                if(numStartIndex == null){
                    numStartIndex = i;
                }
            }
            else if(Operator.isCalculationOperator(oneChar)){       //the char is an operator
                if (i == 0) {
                    if (oneChar == '-') {
                        isNegative = true;
                        continue;
                    } else if (oneChar == '+') {
                        continue;
                    } else if(Operator.isTimesOrDivide(oneChar)) {
                        throw new SyntaxErrorException();
                    }
                }
                if(i != 0) {
                    char previousChar = equation.charAt(i - 1);
                    if (Operator.isCalculationOperator(previousChar)) {
                        if (oneChar == '-') {
                            isNegative = true;
                            continue;
                        } else if (oneChar == '+') {
                            continue;
                        } else {
                            throw new SyntaxErrorException();
                        }
                    }
                }
                assert numStartIndex != null;
                BigDecimal number;
                try{
                    number = new BigDecimal(equation.substring(numStartIndex, i));
                } catch (NumberFormatException e){
                    throw new SyntaxErrorException();
                }
                numbers.add((isNegative)? (number.multiply(new BigDecimal(-1))): number);
                isNegative = false;
                numStartIndex = null;
                operators.add(Operator.getOperator(oneChar));
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        if(numStartIndex == null){
            throw new SyntaxErrorException();
        }
        BigDecimal number;
        try{
            number = new BigDecimal(equation.substring(numStartIndex));
        } catch (NumberFormatException e){
            throw new SyntaxErrorException();
        }
        numbers.add((isNegative)? (number.multiply(new BigDecimal(-1))): number);
    }

    private void calculation(List<Operator> allowedOperator) throws DivideByZeroException {
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            if(allowedOperator.contains(operator)){
                numbers.set(i, operator.calculate(numbers.get(i), numbers.get(i + 1)));
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }
    }

    private void storeAns(){
        if(numbers.size() != 1){
            throw new IllegalStateException("program have bug(s)...");
        }
        answer = numbers.get(0);
    }

    private void calculate() throws DivideByZeroException {
        calculation(Arrays.asList(Operator.times, Operator.divide));
        calculation(Arrays.asList(Operator.add, Operator.minus));
        storeAns();
    }

    public String getAnswer(){
        return answer.toString();
    }
}
