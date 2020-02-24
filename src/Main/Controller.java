package Main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import solver.Solver;

public class Controller {
/**
* Описываю переменные ввода и вывода текста
* булевые переменные на нажатие "=" и наличие на дисплее записи
 */
    @FXML
    private TextField outputField;

    @FXML
    private TextField inputField;

    @FXML
    private TextField z;

    @FXML
    private TextField memory1;

    @FXML
    private TextField memory2;

    @FXML
    private TextField memory3;


    private boolean isDisplayingAns = false;
    private boolean isEqualLabel = false;

    TextField getOutputField() {
        return outputField;
    }

    /*
    *Выполнение математческих операций
    * Нажатие на кнопки цифр
    * Операции с 3 перменными из памяти
     */
    @FXML
    void pressing1Btn() {
        reset();
        outputField.setText( outputField.getText() + "1");
    }

    @FXML
    void pressing2Btn() {
        reset();
        outputField.setText( outputField.getText() + "2");
    }

    @FXML
    void pressing3Btn() {
        reset();
        outputField.setText( outputField.getText() + "3");
    }

    @FXML
    void pressing4Btn() {
        reset();
        outputField.setText( outputField.getText() + "4");
    }

    @FXML
    void pressing5Btn() {
        reset();
        outputField.setText( outputField.getText() + "5");
    }

    @FXML
    void pressing6Btn() {
        reset();
        outputField.setText( outputField.getText() + "6");
    }

    @FXML
    void pressing7Btn() {
        reset();
        outputField.setText( outputField.getText() + "7");
    }

    @FXML
    void pressing8Btn() {
        reset();
        outputField.setText( outputField.getText() + "8");
    }

    @FXML
    void pressing9Btn() {
        reset();
        outputField.setText( outputField.getText() + "9");
    }

    @FXML
    void pressing0Btn() {
        reset();
        outputField.setText( outputField.getText() + "0");
    }

    @FXML
    void dot() {
        reset();
        outputField.setText( outputField.getText() + ".");
    }

    @FXML
    void plusminus() {
        reset();
        if (outputField.getText(0,1).contains("-")){
            outputField.deleteText(0,1);
        } else {
            outputField.setText("-" + outputField.getText());
        }
    }

    @FXML
    void add() {
        if (!isEqualLabel) {
            reset();
            inputField.setText(outputField.getText() + "+");
            outputField.clear();
            isEqualLabel=true;
        } else {
            reset();
            equal();
            inputField.setText(outputField.getText() + "+");
            outputField.clear();
            isEqualLabel=true;
        }
    }

    @FXML
    void minus() {
        if (!isEqualLabel) {
            reset();
            inputField.setText(outputField.getText() + "-");
            outputField.clear();
            isEqualLabel=true;
        } else {
            reset();
            equal();
            inputField.setText(outputField.getText() + "-");
            outputField.clear();
            isEqualLabel=true;
        }
    }

    @FXML
    void divide() {
        if (!isEqualLabel) {
            reset();
            inputField.setText(outputField.getText() + "÷");
            outputField.clear();
            isEqualLabel=true;
        } else {
            reset();
            equal();
            inputField.setText(outputField.getText() + "÷");
            outputField.clear();
            isEqualLabel=true;
        }
    }

    @FXML
    void times() {
        if (!isEqualLabel) {
            reset();
            inputField.setText(outputField.getText() + "×");
            outputField.clear();
            isEqualLabel=true;
        } else {
            reset();
            equal();
            inputField.setText(outputField.getText() + "×");
            outputField.clear();
            isEqualLabel=true;
        }
    }

    @FXML
    void equal() {
        inputField.setText(inputField.getText() +outputField.getText());
        Solver solver = new Solver(inputField.getText());
        outputField.setText(solver.getAnswer());
        inputField.clear();
        if (!isEqualLabel) {
            isDisplayingAns = false;
        } else {
            isDisplayingAns = true;
        }
        isEqualLabel=false;
    }

    @FXML
    void clear() {
        outputField.clear();
        inputField.clear();
    }

    @FXML
    void memory1plus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" ) ) {
            memory1.setText(memory1.getText() + "+" + s);
            Solver solver = new Solver(memory1.getText());
            memory1.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory1minus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" )) {
            memory1.setText(memory1.getText() + "-" + outputField.getText());
            Solver solver = new Solver(memory1.getText());
            memory1.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory1read () {
        outputField.setText(memory1.getText());
    }

    @FXML
    void memory1clear () {
        memory1.setText("0");
    }

    @FXML
    void memory2plus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" ) ) {
            memory2.setText(memory2.getText() + "+" + s);
            Solver solver = new Solver(memory2.getText());
            memory2.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory2minus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" )) {
            memory2.setText(memory2.getText() + "-" + outputField.getText());
            Solver solver = new Solver(memory2.getText());
            memory2.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory2read () {
        outputField.setText(memory2.getText());
    }

    @FXML
    void memory2clear () {
        memory2.setText("0");
    }

    @FXML
    void memory3plus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" ) ) {
            memory3.setText(memory3.getText() + "+" + s);
            Solver solver = new Solver(memory3.getText());
            memory3.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory3minus () {
        String s = outputField.getText();
        if (s.length() >0 && s.matches("^-?[\\d.]+$" )) {
            memory3.setText(memory3.getText() + "-" + outputField.getText());
            Solver solver = new Solver(memory3.getText());
            memory3.setText(solver.getAnswer());
            isDisplayingAns = true;
        }
    }

    @FXML
    void memory3read () {
        outputField.setText(memory3.getText());
    }

    @FXML
    void memory3clear () {
        memory3.setText("0");
    }

    private void reset(){
        if(isDisplayingAns){
            outputField.clear();
            isDisplayingAns = false;
        }
    }

}

