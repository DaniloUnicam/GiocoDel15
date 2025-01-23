package Models;

import Abstractions.Models.IGrid;

import java.util.ArrayList;
import java.util.Collection;

public class Griglia implements IGrid {

    private Tassello[][] grigliaGioco;

    public Griglia(int rows, int cols)
    {
        if(rows > 0 || cols > 0) {
            riempiGriglia(rows, cols);
            mescolaGriglia();
        }
    }

    public void riempiGriglia(int rows, int cols)
    {
        int valoreTassello = 1;
        for (int i = 0; i < this.getRows();i++)
        {
            for(int j = 0; j < this.getCols();j++)
            {
                if(i == this.getRows() - 1 && j == this.getCols() - 1)
                {
                    grigliaGioco[i][j] = null;
                }
                else
                {
                    grigliaGioco[i][j] = new Tassello(new Posizione(i,j), valoreTassello++);
                }
            }
        }
    }

    public void mescolaGriglia() {
        int righe = this.getRows();
        int colonne = this.getCols();

        for (int i = righe - 1; i >= 0; i--) {
            for (int j = colonne - 1; j >= 0; j--) {
                if (i == righe - 1 && j == colonne - 1) {
                    continue;
                }

                int randomRow = (int) (Math.random() * (i + 1));
                int randomCol = (int) (Math.random() * (j + 1));

                if (randomRow == righe - 1 && randomCol == colonne - 1) {
                    randomCol = j;
                }

                Tassello temp = grigliaGioco[i][j];
                grigliaGioco[i][j] = grigliaGioco[randomRow][randomCol];
                grigliaGioco[randomRow][randomCol] = temp;
            }
        }
    }

    public void spostaSu(Tassello tassello) {
        isNull(tassello);
        if (dentroBordo(tassello)) {
            Tassello tasselloSuccessivo = grigliaGioco[tassello.getPosizione().getX()][tassello.getPosizione().getY()+1];
            scambiaTasselli(tassello, tasselloSuccessivo);
        } else {
            throw new IndexOutOfBoundsException("Indice tassello fuori dalla griglia!");
        }
    }

    public void spostaSotto(Tassello tassello)
    {
        isNull(tassello);
        if (dentroBordo(tassello)) {
            Tassello tasselloSuccessivo = grigliaGioco[tassello.getPosizione().getX()][tassello.getPosizione().getY()-1];
            scambiaTasselli(tassello, tasselloSuccessivo);
        } else {
            throw new IndexOutOfBoundsException("Indice tassello fuori dalla griglia!");
        }
    }

    public void spostaSinistra(Tassello tassello)
    {
        isNull(tassello);
        if (dentroBordo(tassello)) {
            Tassello tasselloSuccessivo = grigliaGioco[tassello.getPosizione().getX()-1][tassello.getPosizione().getY()];
            scambiaTasselli(tassello, tasselloSuccessivo);
        } else {
            throw new IndexOutOfBoundsException("Indice tassello fuori dalla griglia!");
        }
    }

    public void spostaDestra(Tassello tassello)
    {
        isNull(tassello);
        if (dentroBordo(tassello)) {
            Tassello tasselloSuccessivo = grigliaGioco[tassello.getPosizione().getX()+1][tassello.getPosizione().getY()];
            scambiaTasselli(tassello, tasselloSuccessivo);
        } else {
            throw new IndexOutOfBoundsException("Indice tassello fuori dalla griglia!");
        }
    }

    private void scambiaTasselli(Tassello tassello, Tassello tasselloSuccessivo) {
        for (int i = 0; i < grigliaGioco.length; i++) {
            for (int j = 0; j < grigliaGioco[0].length; j++) {
                if (isEmpty(tasselloSuccessivo)) {
                    Tassello temp = tasselloSuccessivo;
                    tasselloSuccessivo = tassello;
                    tassello = temp;
                }
            }
        }
    }


    private boolean dentroBordo(Tassello tassello)
    {
        int posX = tassello.getPosizione().getX();
        int posY = tassello.getPosizione().getY();
        return posX < this.getRows() || posX > 0 || posY < this.getCols() || posY > 0;
    }

    private boolean isEmpty(Tassello tassello)
    {
        return grigliaGioco[tassello.getPosizione().getX()][tassello.getPosizione().getY()] == null;
    }

    private void isNull(Tassello tassello) {
        if(tassello == null)
        {
            throw new NullPointerException("Tassello nullo");
        }
    }

    public Collection<Tassello> getCollectionTasselli()
    {
        Collection<Tassello> listaTasselli = new ArrayList<>();
        for (Tassello[] righe : grigliaGioco)
            for (Tassello tassello : righe) {
                if (tassello != null) {
                    listaTasselli.add(tassello);
                }
            }
        return listaTasselli;
    }

    public int getRows() {
        return grigliaGioco.length;
    }

    public int getCols() {
        return grigliaGioco[0].length;
    }

    public Tassello getTassello(Posizione posizione)
    {
        return grigliaGioco[posizione.getX()][posizione.getY()];
    }

    public Tassello getTassello(int x, int y) {
        return grigliaGioco[x][y];
    }
}
