package Handlers;

import Abstractions.Handlers.HandlerGrid;
import Models.Griglia;
import Models.Tassello;

import java.util.Collection;

public class GestoreGriglia implements HandlerGrid {

    private Griglia griglia;
    private Tassello tassello;

    public GestoreGriglia (int rows, int cols)
    {
        this.griglia = new Griglia(rows,cols);
    }


    @Override
    public boolean isVittoria() {
        int valoreAtteso = 1;

        for (int i = 0; i < griglia.getRows(); i++) {
            for (int j = 0; j < griglia.getCols(); j++) {
                if (i == griglia.getRows() - 1 && j == griglia.getCols() - 1) {
                    continue;
                }

                // Ottieni il tassello nella posizione corrente
                Tassello tassello = griglia.getTassello(i, j);

                if (tassello == null || tassello.getValore() != valoreAtteso++) {
                    return false;
                }
            }
        }
        return true;
    }



}
