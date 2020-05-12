/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpaymentcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Noah
 */
public class FXMLDocumentController implements Initializable {

    int loanTerm;

    @FXML
    private TextField carPrice;

    @FXML
    private TextField downPayment;

    @FXML
    private RadioButton loanTerm2;

    @FXML
    private ToggleGroup terms;

    @FXML
    private RadioButton loanTerm1;

    @FXML
    private RadioButton loanTerm3;

    @FXML
    private TextArea displayReport;

    @FXML
    void generateReport(ActionEvent event) {
        double price = Double.parseDouble(carPrice.getText());
        double initialPayment = Double.parseDouble(downPayment.getText());
        double taxAmount = (price*0.07);
        double interestAmount = ((price-initialPayment)*0.09);
        double fees = taxAmount + interestAmount;
        double totalCost = (price+fees);
        double borrowedAmount = price-initialPayment;
        double monthlyPayment = (((price-initialPayment)/loanTerm)/12) + (((fees)/loanTerm)/12);
        float formattedMonthlyPayment = (float)monthlyPayment;
        displayReport.setText("Monthly Payment: " + String.valueOf(formattedMonthlyPayment) + "\nCar Sticker Price: " + price + "\nYou will put down: " + 
                initialPayment + "\nTax Price: " + taxAmount + "\nYour Cost: " + totalCost + "\nBorrowed Amount: " + borrowedAmount + "\nInterest Amount: " + interestAmount);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loanTerm1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean old_val, Boolean new_val) {
                if (loanTerm1.isSelected()) {
                    loanTerm = 2;
                }
            }
        });

        loanTerm2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean old_val, Boolean new_val) {
                if (loanTerm2.isSelected()) {
                    loanTerm = 3;
                }
            }
        });

        loanTerm3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean old_val, Boolean new_val) {
                if (loanTerm3.isSelected()) {
                    loanTerm = 4;
                }
            }
        });
        
        

    }

}
