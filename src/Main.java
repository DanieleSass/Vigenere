import static java.lang.IO.*;

void main(){
    println("Caratteri stampabili (ascii): 32-126");
    ArrayList<Integer> chiavi = ChiediChiave();
    int operazione = ChiediOperazione();
    ArrayList<Lettera> stringa = ChiediStringa();

    Stringa stringa1 = new Stringa(stringa, chiavi, operazione);
    println(stringa1.Cifra_Decifra());
}

ArrayList<Integer> ChiediChiave(){
    int lunghezzaChiave = -1;
    do {
        println("Inserisci lunghezza chiave");
        try{
            lunghezzaChiave = Integer.parseInt(readln());
        }
        catch (Exception e){
            println("Numero non valido");
        }
    } while (lunghezzaChiave<=0);

    ArrayList<Integer> chiavi = new ArrayList<Integer>();
    for (int i = 0; i < lunghezzaChiave; i++) {
        println("Inserisci la "+ (1+i)+ " chiave: ");
        try{
            int chiave = Integer.parseInt(readln());

            //chiedendolo qua salvo le chiavi già normalizzate senza doverle poi ricalcolare
            //per ogni lettera che viene processata
            if (chiave >= 95 || chiave <0) {  //le lettere da usare vanno da 32 a 126 -> 126-32= 94
                chiave = chiave %95; //annulla effetto "ciclicamente" con il modulo
                if (chiave <0){ //pk il modulo di un num <0 da un num <0
                    chiave+=95; //la faccio rientrare nel range
                }
            }

            chiavi.add(chiave);
        }
        catch (Exception e){
            println("Numero della chiave non valido");
            i--;    //annulla il ciclo appena fatto
        }
    }

    return chiavi;
}

int ChiediOperazione(){
    int risposta=-1;
    do {
        println("Inserisci operazione (1->cifratura ; 2->decifratura: ");
        try{
            risposta = Integer.parseInt(readln());
        }
        catch (Exception e){
            println("Operazione non valida non valido");
        }
    } while (risposta!= 1 && risposta!=2);
    return risposta;
}

ArrayList<Lettera> ChiediStringa(){
    println("Inserisci la stringa da (de)cifrare: ");
    String risposta="";
    do{
        risposta = readln().trim();
    }while(risposta.isEmpty());

    ArrayList<Lettera> caratteriDellaStringa = new ArrayList<Lettera>();
    Lettera lettera;
    for (int i = 0; i < risposta.length() ; i++) {
        lettera = new Lettera(risposta.charAt(i));
        caratteriDellaStringa.add(lettera);
    }


    return caratteriDellaStringa;
}
