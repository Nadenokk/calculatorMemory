package solver;

import exception.MathException;

public class Solver {

    private String equation;
    private String answer;
    private MathException exception = null;

    public Solver(String equation){
        this.equation = equation;
        solve();
    }

    private void solve(){
        if(equation.equals("")){
            answer = "";
            return;
        }
        addingTimesSign();
        try {
            calculate();
        } catch (MathException e) {
            exception = e;
        }
    }

    /**
     * 
     */
    private void addingTimesSign(){
        for (int i = 1; i < equation.length(); i++) {
            char oneChar = equation.charAt(i);
        }
    }

    private void calculate() throws MathException{
        ArithmeticSolver solver = new ArithmeticSolver(equation);
        answer = solver.getAnswer();
    }

    public String getAnswer(){
        if(exception == null){
            return answer;
        }
        return exception.getWarning();
    }
}
