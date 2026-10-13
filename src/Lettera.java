public class Lettera {

    private char valoreLetterale;
    private int valoreAscii;

    public Lettera(char let){
        valoreLetterale = let;
        valoreAscii = let;  //con il tipo int diventa direttamente ascii
    }

    public char getValoreLetterale() {
        return valoreLetterale;
    }

    public char Trasla(int numeroSalto, int direzione)
    {
        if(direzione==1){   //in avanti -> cifratura
            valoreAscii+=numeroSalto;
        }
        else if (direzione==2){ //in indietro -> decifratura
            valoreAscii-=numeroSalto;
        }

        int minimoAscii = 32;
        int scarto = 126 - 32 + 1;
        valoreAscii = minimoAscii +((valoreAscii-minimoAscii)%scarto);

        if (valoreAscii < minimoAscii) {
            valoreAscii += scarto;
        }

        valoreLetterale= (char) valoreAscii;
        return valoreLetterale;
    }
}
