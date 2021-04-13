package hellofx;

import static java.awt.Color.yellow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private TextField numero1Caja;
    private TextArea texto;
    @FXML
    private Button calcular;
    @FXML
    private ToggleGroup pesos;

    private void error() {
        retorno.setText("No es posible escribir aqui.");

    }

    @FXML
    private double getNumero1() {
        double numero = 0;
        try {
            numero = Double.parseDouble(numero1Caja.getText()) / 100;
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
    private void calculo() {
        try {
            double resultado = getNumero2() / Math.pow(getNumero1(), 2);
            retorno.setText(String.format("%.2f", resultado));
            cambioColor(resultado);
        } catch (Exception e) {
            System.out.println("Error Aritmetico.");
        }
    }
    private void cambioColor(double resultado) {
        if(resultado > 30 || resultado < 18.4) {
            retorno.setStyle("-fx-background-color: yellow");
        }
    }
}
