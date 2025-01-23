package Abstractions.Models;

import Models.Posizione;
import Models.Tassello;

import java.util.Collection;

public interface IGrid {
    void riempiGriglia(int rows, int cols);

    void mescolaGriglia();

    void spostaSu(Tassello tassello);

    void spostaSotto(Tassello tassello);

    void spostaSinistra(Tassello tassello);

    void spostaDestra(Tassello tassello);

    int getRows();

    int getCols();

    Collection<Tassello> getCollectionTasselli();

    Tassello getTassello(Posizione posizione);

    Tassello getTassello(int x, int y);
}
