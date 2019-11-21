package Vista_api;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import static Vista_api.ConstantesInterfaz.*;


public class Mapa extends VBox {

    private GridPane matriz;
    private final int filas, columnas;
    //Constructor
    public Mapa(){
        this.matriz = new GridPane();
        this.matriz.setHgap(2);
        this.matriz.setVgap(2);
        //TODO cambiar harcoding de aqui
        this.filas = 20;
        this.columnas = 20;
        this.getChildren().add(this.matriz);
        this.actualizarTablero();
    }

    //Actualiza la vista del mapa
    public void actualizarTablero(){
        //aqui colocar clase que obtiene y actualiza cada uno de los casilleros
        for (int x=1; x<=this.columnas; x++) {
            for (int y = 1; y <= this.filas; y++) {
                //Aqui la anterior mencionada clase obtiene la casilla y le coloca la imagen que le pertenece
                ImageView vacio = (new ImageView(new Image(IMG_VACIO)));

                this.matriz.add(vacio, y, x);
            }
        }
        ImageView vacio = (new ImageView(new Image(IMG_CURANDERO)));
        //vacio.setFitHeight(25);
        //vacio.setFitWidth(25);
        this.matriz.add(vacio, 20, 20);
        System.out.println("Mapa actualizado");
    }
}
