package Modelo.Casillero;

import Modelo.Unidad;

public interface EstadoTerritorio {
    void analizarDanio(Unidad unidad, float danio);

    void actualizarEstado(Unidad unidad, Casillero casillero);
}
