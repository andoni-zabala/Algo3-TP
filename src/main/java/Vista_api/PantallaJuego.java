package Vista_api;

import Controlador.ContenedorDeClases;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.RecursosClass.PanelDerecho;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class PantallaJuego {

    private Mapa mapa;

    public void inicializar(Stage stage, ContenedorDeClases contenedorDeClases) {
        Coordenada ultimaCoordenadaTocada = new Coordenada(0,0); //Le pongo una posicion inicial
       mapa = new Mapa(contenedorDeClases.obtenerTablero(), ultimaCoordenadaTocada);

       //contenedor principal es el grupo de nodos mas externo de toda la pantalla
       HBox contenedor_principal = new HBox();

        contenedor_principal.setSpacing(20);

       //panel Derecho donde estaran los controles o la informacion del tablero
        PanelDerecho panel_derecho = new PanelDerecho();

        //Metemos los contenidos
       contenedor_principal.getChildren().addAll(mapa,panel_derecho);
        panel_derecho.ColocarUnidades(contenedorDeClases, ultimaCoordenadaTocada, mapa);

        //Creamos la escena
       Scene escena_juego = new Scene(contenedor_principal);

       //Seteando esta escena, ahora los eventos de esta seran manipulado por otros (manipuladores de evento)
       stage.setScene(escena_juego);
    }

    public void actualizar() {
        //Actualizar el tablero de la izquierda
        this.mapa.actualizarTablero();
        //Actualizar el panel derecho
    }


    public void mostrar(Stage stage) {

    }
}
