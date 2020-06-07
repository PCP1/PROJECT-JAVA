package Update;

import DataAcessObject.Connect;
import DataAcessObject.DAOseance;

public class RechercheInfo {
    public int RechercheSeance(int seance)
    {
        DAOseance seanceDAO;
        int testheure = 0;
        seanceDAO = new DAOseance(new Connect().getConnection());
        testheure = seanceDAO.find(seance).getheure_debut();
        System.out.println("Test heure : "+testheure);
        return testheure;
    }
}
