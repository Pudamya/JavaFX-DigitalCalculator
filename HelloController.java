package com.iit.cal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    private TextField textDisplay;

    private Double numberOne = 0.0;
    private Double numberTwo = 0.0;
    private String operator = "";

    @FXML
    protected void onButtonClick(ActionEvent event) {
        String newText = ((Button) event.getSource()).getText();
        textDisplay.setText(textDisplay.getText() + newText);
    }

    @FXML
    protected void onGenButtonClick(ActionEvent event) {
        operator = ((Button) event.getSource()).getText();
        String text = textDisplay.getText();

        switch (operator) {
            case "AC":
                textDisplay.setText("");
                break;

            case "+/-":
                if (!text.isEmpty()) {
                    Double currentValue = Double.parseDouble(text);
                    currentValue = currentValue * -1;
                    textDisplay.setText(currentValue.toString());
                }
                break;

            case "%":
                if (!text.isEmpty()) {
                    Double currentValue = Double.parseDouble(text);
                    currentValue = currentValue / 100;
                    textDisplay.setText(currentValue.toString());
                }
                break;

            default:
                if (!text.isEmpty()) {
                    numberOne = Double.parseDouble(text);
                    textDisplay.setText("");
                }
                break;
        }
    }

    @FXML
    protected void onPeriodButtonClick(ActionEvent event) {
        String newText = ((Button) event.getSource()).getText();
        String text = textDisplay.getText();
        if (!text.contains(".")) {
            textDisplay.setText(text + newText);
        }
    }

    @FXML
    protected void onButtonEqual(ActionEvent event) {
        if (!textDisplay.getText().isEmpty()) {
            numberTwo = Double.parseDouble(textDisplay.getText());

            switch (operator) {
                case "+":
                    textDisplay.setText(Double.toString(numberOne + numberTwo));
                    break;
                case "-":
                    textDisplay.setText(Double.toString(numberOne - numberTwo));
                    break;
                case "*":
                    textDisplay.setText(Double.toString(numberOne * numberTwo));
                    break;
                case "/":
                    if (numberTwo != 0) {
                        textDisplay.setText(Double.toString(numberOne / numberTwo));
                    } else {
                        textDisplay.setText("Error");
                    }
                    break;
            }
        }
    }
}
