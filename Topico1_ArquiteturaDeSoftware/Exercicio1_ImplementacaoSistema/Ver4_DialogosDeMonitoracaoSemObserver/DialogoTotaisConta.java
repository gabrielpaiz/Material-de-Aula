package Refactoring05_DialogoModeless;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DialogoTotaisConta {
	private int nroConta;
    private Scene cena;
    private Stage dlgStage;
    private TextField tfTotalCreditos;
    private TextField tfTotalDebitos;
    private TextField tfMaiorSaldo;
    
	public DialogoTotaisConta(int nroConta) {
		this.nroConta = nroConta;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		TotaisConta totais = LogicaOperacoes.getInstance().getTotaisConta(nroConta);

		String dadosCorr = totais.getNumero() + " : "
				           + totais.getNomeCorrentista();
		Text scenetitle = new Text(dadosCorr);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		tfTotalCreditos = new TextField();
		tfTotalCreditos.setDisable(true);
		tfTotalCreditos.setText("" + totais.getTotalCreditos());
		HBox valTotCred = new HBox(20);
		valTotCred.setAlignment(Pos.BOTTOM_LEFT);
		valTotCred.getChildren().add(new Label("Total de créditos"));
		valTotCred.getChildren().add(tfTotalCreditos);
		grid.add(valTotCred, 0, 2);

		tfTotalDebitos = new TextField();
		tfTotalDebitos.setDisable(true);
		tfTotalDebitos.setText("" + totais.getTotalDebitos());
		HBox valTotDeb = new HBox(20);
		valTotDeb.setAlignment(Pos.BOTTOM_LEFT);
		valTotDeb.getChildren().add(new Label("Total de débitos"));
		valTotDeb.getChildren().add(tfTotalDebitos);
		grid.add(valTotDeb, 0, 3);

		tfMaiorSaldo = new TextField();
		tfMaiorSaldo.setDisable(true);
		if (totais.isMaiorSaldo()) {
		    tfMaiorSaldo.setText("Sim");
		}else {
		    tfMaiorSaldo.setText("Nao");			
		}
		HBox valMSal = new HBox(20);
		valMSal.setAlignment(Pos.BOTTOM_LEFT);
		valMSal.getChildren().add(new Label("Conta com maior saldo?"));
		valMSal.getChildren().add(tfMaiorSaldo);
		grid.add(valMSal, 0, 4);

		Button btnVoltar = new Button("Voltar");
		grid.add(btnVoltar, 1, 2);


		btnVoltar.setOnAction(e -> {
			dlgStage.close();
		});

		cena = new Scene(grid);
		dlgStage = new Stage();
		dlgStage.setScene(cena);
		dlgStage.show();
		dlgStage.toFront();
	}
}
