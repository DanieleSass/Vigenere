import java.util.ArrayList;

public class Stringa {
    ArrayList<Lettera> stringa;
    ArrayList<Integer> chiavi;
    int operazione;

    public Stringa(){
        stringa = new ArrayList<Lettera>();
    }


    public Stringa(ArrayList<Lettera> arrayList, ArrayList<Integer> chiav, int operaz){
        stringa = arrayList;
        chiavi = chiav;
        operazione= operaz;
    }

    public Stringa Cifra_Decifra(){
        char letteraCifrata;
        Stringa stringaDaReturnare = new Stringa();
        int indiceChiave = 0;
        for (int i = 0; i < stringa.size(); i++) {

            char letteraAttuale = stringa.get(i).getValoreLetterale();
            if(letteraAttuale>=32 && letteraAttuale<=126){
                int skip = chiavi.get(indiceChiave%chiavi.size());
                letteraCifrata = stringa.get(i).Trasla(skip,operazione);
                stringaDaReturnare.stringa.add(new Lettera((letteraCifrata)));
                indiceChiave++;
            }
            else{
                //char fuori dal range 32-126 non vengono crittografati
                stringaDaReturnare.stringa.add(new Lettera(letteraAttuale));
            }

        }
        return stringaDaReturnare;
    }

    @Override
    public String toString(){
        String daReturnare = "";
        for (int i = 0; i < stringa.size(); i++) {
            daReturnare+=stringa.get(i).getValoreLetterale();
        }

        return  daReturnare;
    }

}
