/**
 *
 * @author ZOULI-BARRERE DOUVILLE CABRILLAC
 */
public class Etudiant
{
    String nom;
    String prenom;
    int td;
    String tp;
    
    
    /** constructeur sans parametre  permettant d'initialiser un étudiant inconnu
     * 
     */
    Etudiant(){
        this.nom = "inconnu";
        this.prenom = "inconnu";
        this.td = 0;
        this.tp = "inconnu";
    }
    
    
    /** constructeur avec 4 paramètres permettant d'initialiser un étudiant
     * @param pfNom IN le nom d'un étudiant
     * @param pfPrenom IN le prénom d'un étudiant
     * @param pfTD IN le groupe td d'un étudiant
     * @param pfTD IN le groupe tp d'un étudiant
     */    
    Etudiant(String pfNom, String pfPrenom, int pfTD, String pfTP) {
        this.nom = pfNom ;
        this.prenom = pfPrenom;
        this.td = pfTD;
        this.tp = pfTP;
    }
}
