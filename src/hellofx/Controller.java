package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    private int contador = 1;

    @FXML
    private TextField retorno;
    @FXML
    private TextField numero2Caja;
    @FXML
    private Label numero2;
    @FXML
    private Label etiquetaNumero1;
    @FXML
    private Button resto;
    @FXML
    private Button elevar;
    @FXML
    private Button porcentaje;
    @FXML
    private Button sumar;
    @FXML
    private Button limpiar;
    @FXML
    private TextField numero1Caja;
    @FXML
    private TextArea texto;

    @FXML
    private void error() {
        retorno.setText("No es posible escribir aqui.");

    }

    @FXML
    private double getNumero1() {
        double numero = 0;
        try {
            numero = Double.parseDouble(numero1Caja.getText());
        } catch (NumberFormatException e) {
            retorno.setText("DATOS NO VALIDOS");
        }
        return numero;
    }

    @FXML
    private double getNumero2() {
        double numero = 0;
        try {
            numero = Double.parseDouble(numero2Caja.getText());
        } catch (NumberFormatException e) {
            retorno.setText("DATOS NO VALIDOS");
        }
        return numero;
    }

    @FXML
    private void calculoResto(ActionEvent event) {
        retorno.setText(Double.toString(getNumero1() - getNumero2()));
        texto.appendText("Operacion " + contador++ + ", "
                + ((Button) event.getSource()).getText() + " " + getNumero1()
                + " - " + getNumero2() + " = " + retorno.getText() + "\n");
    }

    @FXML
    private void calculoElevar() {
        double resultado = Math.pow(getNumero1(), getNumero2());
        retorno.setText(Double.toString(resultado));
    }

    @FXML
    private void calculoPorcentaje(ActionEvent event) {
        double numero2 = getNumero2();
        if (numero2 != 0) {
            double resultado = (getNumero1() / getNumero2()) * 100;
            retorno.setText(Double.toString(resultado));
        } else {
            retorno.setText("ERROR");
        }
    }

    @FXML
    private void calculoSumar(ActionEvent event) {
        double resultado = getNumero1() + getNumero2();
        retorno.setText(Double.toString(resultado));
    }

    @FXML
    private void hacerLimpieza(ActionEvent event) {
        numero1Caja.clear();
        numero2Caja.clear();
        retorno.clear();
    }

    @FXML
    private void resumenOperaciones(MouseEvent event) {
    }

}
