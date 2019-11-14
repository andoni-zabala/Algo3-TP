package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;
import Modelo.Unidad;

public class Catapulta extends Unidad{
    private int danioCercano;
    private int danioMediano;
    private int danioLejano;

    public Catapulta(Jugador duenio, Casillero casillero){
        super(50,5, casillero, duenio);
        danioCercano = 0;
        danioMediano = 0;
        danioLejano = 20;
    }

    @Override
    public void accion(Unidad unidad){
        super.atacaAliado(unidad);
        TipoDistancia tipoDistancia = this.casillero.getTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
        tipoDistancia.aplicarAccion(this,unidad);
    }

    @Override
    public void accionCercana(Unidad unidad){
        unidad.sufrirAtaque(danioCercano);
    }

    @Override
    public void accionMediana(Unidad unidad){
        unidad.sufrirAtaque(danioMediano);
    }

    @Override
    public void accionLejana(Unidad unidad){
        unidad.sufrirAtaque(danioLejano);
    }

    @Override
    public void mover(Direccion direccion) {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void recibirCuracion(int curacion){
        throw new CatapultaCuracionException();
    }
}
