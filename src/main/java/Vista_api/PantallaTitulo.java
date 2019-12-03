package Vista_api;

import Vista_api.ManipuladorEventos.EasterEggLogo;
import Vista_api.ManipuladorEventos.Empezar_juego_Handler;
import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Vista_api.ConstantesInterfaz.*;

public class PantallaTitulo implements Manipulador_escenarios {

    public Scene titulo;

    public void inicializar(Stage stage){

        //abro una imagen y se lo asigno a un visor
        ImageView Imagen_titulo = (new ImageView(new Image(IMG_TITULO)));


        TextField textfield1 = new TextField();
        textfield1.setPromptText("Jugador1");
        TextField textfield2 = new TextField();
        textfield2.setPromptText("Jugador2");
        Label informacion = new Label();

        VBox contenedor_text_fields = new VBox();
        contenedor_text_fields.prefWidth(20); //Pixeles de distancia entre las cosas

        contenedor_text_fields.getChildren().addAll(textfield1,textfield2, informacion);

        //Creo botones
        Button boton_dummy = new Button("Dummy");
        Button boton_iniciar = new Button("Iniciar");
        Button boton_salir = new Button("Salir ");

        //Creacion de Handlers y sus iniciaciones
        Salir_Juego_Handler salir_juego_handler = new Salir_Juego_Handler(stage);
        Empezar_juego_Handler jugarHandler = new Empezar_juego_Handler(stage,textfield1,textfield2,informacion);
        EasterEggLogo logo_bonus = new EasterEggLogo();

        //Asignacion de triggers de eventos a los botones
        //Dummy usa un lambda
        boton_dummy.setOnAction((event) -> System.out.println("Tocaboton"));
        boton_salir.setOnAction(salir_juego_handler);
        boton_iniciar.setOnAction(jugarHandler);

        //Dispara el evento logo_bonus SOLO al hacer click en el logo del titulo
        Imagen_titulo.addEventFilter(MouseEvent.MOUSE_CLICKED, logo_bonus);

        //Creo contenedores y
        HBox hbox = new HBox(boton_dummy, boton_iniciar, boton_salir);
        VBox vbox = new VBox(20,Imagen_titulo,contenedor_text_fields,hbox);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);


        //aplico la escena al Stage
        this.titulo = new Scene(vbox);
    }

    @Override
    public void inicializar() {

    }

    @Override
    public void actualizar(){

    }


    @Override
    public void mostrar(Stage stage) {
        stage.setScene(this.titulo);
    }
}
