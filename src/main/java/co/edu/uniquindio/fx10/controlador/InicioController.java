package co.edu.uniquindio.fx10.controlador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.fx10.App;
import co.edu.uniquindio.fx10.repositorio.ProductoRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {

    /**
     * Sample Skeleton for 'inicio.fxml' Controller Class
     */


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCrearProducto"
    private Button btnCrearProducto; // Value injected by FXMLLoader

    @FXML // fx:id="btnVerProductos"
    private Button btnVerProductos; // Value injected by FXMLLoader

    @FXML
    void crearProducto(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(App.class.getResource("/co/edu/uniquindio/fx10/vista/Vista/FormularioProducto.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar el formulario", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void verProductos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(App.class.getResource("/co/edu/uniquindio/fx10/vista/Vista/ListadoProductos.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar el formulario", Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }

    /**
     * Muestra una alerta al usuario
     */
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private ProductoRepository productoRepository;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        productoRepository = ProductoRepository.getInstancia();

        assert btnCrearProducto != null : "fx:id=\"btnCrearProducto\" was not injected: check your FXML file 'inicio.fxml'.";
        assert btnVerProductos != null : "fx:id=\"btnVerProductos\" was not injected: check your FXML file 'inicio.fxml'.";

    }

    public void setDashboardController(DashboardController dashboardController){

    }

}
