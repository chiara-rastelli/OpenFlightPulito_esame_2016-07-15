package it.polito.tdp.flight;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.flight.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//controller del turno B --> switchare al branch master_turnoA per turno A

public class FXMLController {
	
	private Model model;

	@FXML
	private ResourceBundle resources;
	
	@FXML
    private URL location;

    @FXML
    private TextField txtDistanzaInput;

    @FXML
    private TextField txtPasseggeriInput;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCreaGrafo(ActionEvent event) {

    }

    @FXML
    void doSimula(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtDistanzaInput != null : "fx:id=\"txtDistanzaInput\" was not injected: check your FXML file 'Flight.fxml'.";
        assert txtPasseggeriInput != null : "fx:id=\"txtPasseggeriInput\" was not injected: check your FXML file 'Flight.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Flight.fxml'.";

    }
	    
	public void setModel(Model model) {
		this.model = model;
	}
}
