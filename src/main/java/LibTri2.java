import java.io.*;
/**
 * Indiquer le ou les numeros de TP et d'exercice.
 *
 * @author (votre nom)
 */
public class LibTri2 {

    /** affiche un TNP(Tableau Non Plein)
     * @param pfTNP IN la liste des éléments
     */
    public static void afficherTNP(TNPEtu pfTNP)  {
        for (int i = 0; i < pfTNP.nbElt ; i = i + 1){
            System.out.print(pfTNP.lesElements[i].nom + " " + pfTNP.lesElements[i].prenom + " " + pfTNP.lesElements[i].td + " " + pfTNP.lesElements[i].tp +  "\n" ) ;
        }
    }

    /**
     * transforme un tableau d'Etudiant en un tableau non plein (TNP) d'Etudiant
     * 
     * @param : pfTabEtu IN tableau contenant les Etudiants
     * @param : pfTNPEtu IN/OUT tableau non plein dans lequel mettre les Etudiants
     */
    public static void chargerListeEtu(Etudiant[] pfTabEtu, TNPEtu pfTNPEtu){
        for(int i = 0; i < ListeEtudiants.nbEtudiant(pfTabEtu); i++){
            pfTNPEtu.lesElements[i] = pfTabEtu[i];
        }
    }

    /** tri un tableau non plein d'Etudiant par ordre alphabétique du nom puis du prenom
     * 
     * @param pfTNPEtu  IN/OUT le tableau non plein des Etudiants à trier
     *
     */
    public static void triListeEtu(TNPEtu pfTabEtu){
        boolean permut = true;
        while (permut){
            permut = false;
            for(int i = 0 ; i < pfTabEtu.nbElt - 1; i++){
                if (pfTabEtu.lesElements[i].nom.compareTo(pfTabEtu.lesElements[i+1].nom) > 0){
                    permut = true;
                    Etudiant ech = pfTabEtu.lesElements[i];
                    pfTabEtu.lesElements[i] = pfTabEtu.lesElements[i+1];
                    pfTabEtu.lesElements[i+1] = ech;                   
                }
                else{
                    if ((pfTabEtu.lesElements[i].nom.compareTo(pfTabEtu.lesElements[i+1].nom)==0)&&(pfTabEtu.lesElements[i].prenom.compareTo(pfTabEtu.lesElements[i+1].prenom) > 0)){ 
                        permut = true;
                        Etudiant ech = pfTabEtu.lesElements[i];
                        pfTabEtu.lesElements[i] = pfTabEtu.lesElements[i+1];
                        pfTabEtu.lesElements[i+1] = ech;   
                    }
                }
            }
        }
    }

    /**
     * recherche un Etudiant dans une liste d'Etudiants par recherche sans rupture
     *
     * @param : pfTabEtu IN la liste des Etudiants
     * @param : pfEtuCherche IN l'Etudiant rechercher
     *
     * @return l'indice de l'Etudiant trouvé dans la liste et -1 si l'Etudiant n'est pas dans la liste
     */
    public static int sansRupture(TNPEtu pfTNPEtu,Etudiant pfEtu){
        int indiceVal = -1; 
        String trace = "";
        int iefori = 0; // Compteur du nombre d'itérations de la boucle i
        for (int i=0; i<pfTNPEtu.nbElt ; i++){
            // *** Trace d'exécution ***
            iefori ++;
            if (pfEtu.nom.compareTo(pfTNPEtu.lesElements[i].nom)==0
            &&
            pfEtu.prenom.compareTo(pfTNPEtu.lesElements[i].prenom)==0 
            && 
            pfEtu.td==pfTNPEtu.lesElements[i].td 
            &&
            pfEtu.tp.compareTo(pfTNPEtu.lesElements[i].tp)==0 ){
                indiceVal = i;         
            }
        }
        trace = trace + "Nombre d’opérations élémentaires : "+iefori;
        System.out.println(trace);
        return indiceVal;
    }

    /**
     * recherche un Etudiant dans une liste d'Etudiants par dichotomie
     *
     * @param : pfTabEtu IN la liste des Etudiants
     * @param : pfEtuCherche IN l'Etudiant recherché
     *
     * @return l'indice de l'Etudiant trouvé dans la liste et -1 si l'Etudiant n'est pas dans la liste
     */
    public static int dichotomie(TNPEtu pfTNP, Etudiant pfEtu) {

        boolean trouve = false;
        int indMin = 0;
        int indMax = pfTNP.nbElt - 1;
        int indMilieu = (indMin + indMax)/2;

        String trace = "";
        int iefori = 0;

        while (indMin <= indMax && !trouve) {

            indMilieu = (indMin + indMax)/2;

            if (pfTNP.lesElements[indMilieu].nom.compareTo(pfEtu.nom) == 0) {
                // *** Trace d'exécution ***
                iefori ++;
                if (pfTNP.lesElements[indMilieu].prenom.compareTo(pfEtu.prenom) == 0) {
                    // *** Trace d'exécution ***
                    iefori ++;
                    trouve = true;

                } else {

                    if (pfTNP.lesElements[indMilieu].prenom.compareTo(pfEtu.prenom) < 0) {
                        // *** Trace d'exécution ***
                        iefori ++;
                        indMin = indMilieu + 1;

                    } else {
                        // *** Trace d'exécution ***
                        iefori ++;
                        indMax = indMilieu - 1;

                    }

                }

            } else {
                // *** Trace d'exécution ***
                iefori ++;
                if (pfTNP.lesElements[indMilieu].nom.compareTo(pfEtu.nom) < 0) {
                    // *** Trace d'exécution ***
                    iefori ++;
                    indMin = indMilieu + 1;

                } else {
                    // *** Trace d'exécution ***
                    iefori ++;
                    indMax = indMilieu - 1;

                }

            }
        }
        trace = trace + "Nombre d’opérations élémentaires : " + iefori;
        System.out.println(trace);

        if (trouve) {
            return indMilieu;
        }else {
            return -1;
        }
    }

    /**
     * recherche un Etudiant dans une liste d'Etudiants par recherche avec rupture
     *
     * @param : pfTabEtu IN la liste des Etudiants
     * @param : pfEtuCherche IN l'Etudiant recherché
     *
     * @return l'indice de l'Etudiant trouvé dans la liste et -1 si l'Etudiant n'est pas dans la liste
     */
    public static int avecRupt(TNPEtu pfTNP,Etudiant pfEtu){
        String Trace = "";
        int iefori = 0; //Compteur du nombre d'itérations de la boucle i
        for (int i = 0; i < pfTNP.nbElt ; i++){
            // *** Trace d'exécution ***
            iefori ++;
            if (pfEtu.nom.compareTo(pfTNP.lesElements[i].nom)==0
            &&
            pfEtu.prenom.compareTo(pfTNP.lesElements[i].prenom)==0 
            && 
            pfEtu.td==pfTNP.lesElements[i].td 
            &&
            pfEtu.tp.compareTo(pfTNP.lesElements[i].tp)==0 ){
                Trace = Trace + "Nombre d’opérations élémentaires : "+iefori;
                System.out.println(Trace);
                return i;
            }        
        }
        Trace = Trace + "Nombre d’opérations élémentaires : "+iefori;
        System.out.println(Trace);
        return -1;
    }

    /**
     * test le fonctionnement de la fonction sansRupture dans les différents cas possible
     */
    public static void testSansRupture(){
        try {
            Etudiant promo[] = ListeEtudiants.getListe("listenomssansaccent.csv", ","); //Initialisation des Etudiants dans la variable promo qui est un tableau d'Etudiant
            TNPEtu TNPpromo = new TNPEtu(ListeEtudiants.nbEtudiant(promo));             //Initialisation de la variable TNPpromo qui est de type TNPEtu avec comme longueur la taille de la promo
            TNPpromo.nbElt = ListeEtudiants.nbEtudiant(promo);                          //Initialisation du nombre d'elements de TNPpromo au nombre d'Etudiant dans la promo

            chargerListeEtu(promo, TNPpromo);   //On insère les étudiants de la promo dans TNPpromo
            triListeEtu(TNPpromo);              //On trie les Etudiants par ordre alphabétique

            // *** Initialisation d'Etudiants permettant de réaliser les test algorithmique ***
            Etudiant etuTest1 = creerEtuTestValide1();
            Etudiant etuTest2 = creerEtuTestValide2();
            Etudiant etuTest3 = creerEtuTestValide3();
            Etudiant etuTestN = creerEtuTestNonValide();

            /// *** Affichage ***
            System.out.println();

            System.out.println("Test sans rupture");

            System.out.println();

            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            int recSansRup = sansRupture(TNPpromo, etuTest1);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est "+recSansRup);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            recSansRup = sansRupture(TNPpromo, etuTest2);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est "+recSansRup);

            System.out.println();

            // Test milieu de liste
            System.out.println("Test étudiant valide en milieu de liste");
            recSansRup = sansRupture(TNPpromo, etuTest3);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est "+recSansRup);

            System.out.println();

            // Test non valide
            System.out.println("Test étudiant non valide");
            recSansRup = sansRupture(TNPpromo, etuTestN);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est "+recSansRup);

            System.out.println("----------------------------------------");

            Etudiant promo2[] = ListeEtudiants.getListe("listenomssansaccentreduit.csv", ",");
            TNPEtu TNPpromo2 = new TNPEtu(ListeEtudiants.nbEtudiant(promo2));
            TNPpromo2.nbElt = ListeEtudiants.nbEtudiant(promo2);

            chargerListeEtu(promo2, TNPpromo2);
            triListeEtu(TNPpromo2);

            Etudiant etuTest11 = creerEtuTestValide1();
            Etudiant etuTest22 = creerEtuTestValide2();
            Etudiant etuTest33 = creerEtuTestValide3();
            Etudiant etuTestNN = creerEtuTestNonValide();

            System.out.println();

            System.out.println("Test sans rupture liste réduite");

            System.out.println();

            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            recSansRup = sansRupture(TNPpromo2,etuTest11);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est " + recSansRup);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            recSansRup = sansRupture(TNPpromo2,etuTest22);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est " + recSansRup);

            System.out.println();

            // Test milieu de liste
            System.out.println("Test étudiant valide en milieu de liste");
            recSansRup = sansRupture(TNPpromo2,etuTest33);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est " + recSansRup);

            System.out.println();

            // Test non valide
            System.out.println("Test étudiant non valide");
            recSansRup = sansRupture(TNPpromo2,etuTestNN);
            System.out.println("Recherche sans rupture : le rang de l'étudiant est " + recSansRup);

            System.out.println("----------------------------------------");

        }
        catch (Exception e) {  
            System.out.println("Erreur : "+e.getMessage());

        } 
    }
    
    /**
     * test le fonctionnement de la fonction dichotomie dans les différents cas possible
     */
    public static void testDichotomique(){
        try {
            Etudiant promo[] = ListeEtudiants.getListe("listenomssansaccent.csv", ","); //Initialisation des Etudiants dans la variable promo qui est un tableau d'Etudiant
            TNPEtu TNPpromo = new TNPEtu(ListeEtudiants.nbEtudiant(promo));             //Initialisation de la variable TNPpromo qui est de type TNPEtu avec comme longueur la taille de la promo
            TNPpromo.nbElt = ListeEtudiants.nbEtudiant(promo);                          //Initialisation du nombre d'elements de TNPpromo au nombre d'Etudiant dans la promo

            chargerListeEtu(promo, TNPpromo);   //On insère les étudiants de la promo dans TNPpromo
            triListeEtu(TNPpromo);              //On trie les Etudiants par ordre alphabétique

            // *** Initialisation d'Etudiants permettant de réaliser les test algorithmique ***
            Etudiant etuTest1 = creerEtuTestValide1();       
            Etudiant etuTest2 = creerEtuTestValide2();
            Etudiant etuTest3 = creerEtuTestValide3();
            Etudiant etuTestN = creerEtuTestNonValide();

            
            /// *** Affichage ***
            System.out.println();

            System.out.println("Test dichotomique");

            System.out.println();
            
            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            int Dico = dichotomie(TNPpromo,etuTest1);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est "+Dico);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            Dico = dichotomie(TNPpromo,etuTest2);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println();

            // Test milieu de liste 
            System.out.println("Test étudiant valide en milieu de liste");
            Dico = dichotomie(TNPpromo,etuTest3);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);  

            System.out.println();

            // Test non valide
            System.out.println("Test étudiant non valide");
            Dico = dichotomie(TNPpromo,etuTestN);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println("----------------------------------------");
            
            
            // *** Initialisation d'Etudiants permettant de réaliser les test algorithmique ***
            Etudiant promo2[] = ListeEtudiants.getListe("listenomssansaccentreduit.csv", ",");
            TNPEtu TNPpromo2 = new TNPEtu(ListeEtudiants.nbEtudiant(promo2));
            TNPpromo2.nbElt = ListeEtudiants.nbEtudiant(promo2);

            chargerListeEtu(promo2, TNPpromo2);
            triListeEtu(TNPpromo2);

            Etudiant etuTest11 = creerEtuTestValide1();
            Etudiant etuTest22 = creerEtuTestValide2();
            Etudiant etuTest33 = creerEtuTestValide3();
            Etudiant etuTestNN = creerEtuTestNonValide();

            System.out.println();

            System.out.println("Test dichotomie liste réduite");

            System.out.println();
            
            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            Dico = dichotomie(TNPpromo2,etuTest11);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            Dico = dichotomie(TNPpromo2,etuTest22);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println();

            // Test milieu de liste
            System.out.println("Test étudiant valide en milieu de liste");
            Dico = dichotomie(TNPpromo2,etuTest33);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println();

            // Test non valide
            System.out.println("Test étudiant non valide");
            Dico = dichotomie(TNPpromo2,etuTestNN);
            System.out.println("Recherche dichotomique : le rang de l'étudiant est " + Dico);

            System.out.println("----------------------------------------");

        }
        catch (Exception e) {  
            System.out.println("Erreur : "+e.getMessage());

        } 
    }

    /**
     * test le fonctionnement de la fonction avecRupt dans les différents cas possible
     */
    public static void testAvecRupture(){
        try {
            Etudiant promo[] = ListeEtudiants.getListe("listenomssansaccent.csv", ","); //Initialisation des Etudiants dans la variable promo qui est un tableau d'Etudiant
            TNPEtu TNPpromo = new TNPEtu(ListeEtudiants.nbEtudiant(promo));             //Initialisation de la variable TNPpromo qui est de type TNPEtu avec comme longueur la taille de la promo
            TNPpromo.nbElt = ListeEtudiants.nbEtudiant(promo);                          //Initialisation du nombre d'elements de TNPpromo au nombre d'Etudiant dans la promo

            chargerListeEtu(promo, TNPpromo);   //On insère les étudiants de la promo dans TNPpromo
            triListeEtu(TNPpromo);              //On trie les Etudiants par ordre alphabétique

            // *** Initialisation d'Etudiants permettant de réaliser les test algorithmique ***
            Etudiant etuTest1 = creerEtuTestValide1();
            Etudiant etuTest2 = creerEtuTestValide2();
            Etudiant etuTest3 = creerEtuTestValide3();
            Etudiant etuTestN = creerEtuTestNonValide();

            /// *** Affichage ***
            System.out.println();

            System.out.println("Test avec rupture");

            System.out.println();

            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            int recAvecRup = avecRupt(TNPpromo,etuTest1);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            recAvecRup = avecRupt(TNPpromo,etuTest2);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test milieu de liste
            System.out.println("Test étudiant valide en milieu de liste");
            recAvecRup = avecRupt(TNPpromo,etuTest3);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test non valide  
            System.out.println("Test étudiant non valide");
            recAvecRup = avecRupt(TNPpromo,etuTestN);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println("----------------------------------------");

            Etudiant promo2[] = ListeEtudiants.getListe("listenomssansaccentreduit.csv", ",");
            TNPEtu TNPpromo2 = new TNPEtu(ListeEtudiants.nbEtudiant(promo2));
            TNPpromo2.nbElt = ListeEtudiants.nbEtudiant(promo2);

            chargerListeEtu(promo2, TNPpromo2);
            triListeEtu(TNPpromo2);

            Etudiant etuTest11 = creerEtuTestValide1();
            Etudiant etuTest22 = creerEtuTestValide2();
            Etudiant etuTest33 = creerEtuTestValide3();
            Etudiant etuTestNN = creerEtuTestNonValide();

            System.out.println();

            System.out.println("Test avec rupture liste réduite");

            System.out.println();

            // Test début de liste
            System.out.println("Test étudiant valide en début de liste");
            recAvecRup = avecRupt(TNPpromo2,etuTest11);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test fin de liste
            System.out.println("Test étudiant valide en fin de liste");
            recAvecRup = avecRupt(TNPpromo2,etuTest22);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test milieu de liste
            System.out.println("Test étudiant valide en milieu de liste");
            recAvecRup = avecRupt(TNPpromo2,etuTest33);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println();

            // Test non valide
            System.out.println("Test étudiant non valide");
            recAvecRup = avecRupt(TNPpromo2,etuTestNN);
            System.out.println("Recherche avec rupture : le rang de l'étudiant est " + recAvecRup);

            System.out.println("----------------------------------------");
        }
        catch (Exception e) {  
            System.out.println("Erreur : "+e.getMessage());

        } 
    }

    /** créer un Etudiant fin de liste
     * @return l'étudiant crée
     */
    public static Etudiant creerEtuTestValide2() {
        Etudiant etuTest2=new Etudiant("Vigote","Sarah",5,"5B");
        return etuTest2;
    }

    /** créer un Etudiant début de liste
     * @return l'étudiant crée
     */
    public static Etudiant creerEtuTestValide1() {
        Etudiant etuTest1=new Etudiant("Auboisdormant","Abel",1,"1A" );
        return etuTest1;
    }

    /** créer un Etudiant milieu de liste
     * @return l'étudiant crée
     */
    public static Etudiant creerEtuTestValide3() {
        Etudiant etuTest3=new Etudiant("Ho","Bob",3,"3B" );
        return etuTest3;
    }

    /** créer un Etudiant fictif
     * @return l'étudiant crée
     */
    public static Etudiant creerEtuTestNonValide() {
        Etudiant etuTestN=new Etudiant("Zouli-BarrereDouvilleCabrillac","KarimLeoAnthony",3,"3A");
        return etuTestN;
    }

    public static void main(String arguments[])   {
        try {
            Etudiant promo[] = ListeEtudiants.getListe("listenomssansaccent.csv", ","); //Initialisation des Etudiants dans la variable promo qui est un tableau d'Etudiant
            TNPEtu TNPpromo = new TNPEtu(ListeEtudiants.nbEtudiant(promo));             //Initialisation de la variable TNPpromo qui est de type TNPEtu avec comme longueur la taille de la promo
            TNPpromo.nbElt = ListeEtudiants.nbEtudiant(promo);                          //Initialisation du nombre d'elements de TNPpromo au nombre d'Etudiant dans la promo

            chargerListeEtu(promo, TNPpromo);   //On insère les étudiants de la promo dans TNPpromo

            System.out.println("----------------------------------------");
            triListeEtu(TNPpromo);  //On trie les Etudiants par ordre alphabétique
            afficherTNP(TNPpromo);  //On affiche la liste des Etudiants

            System.out.println("----------------------------------------");

            testSansRupture();  //On test l'algorithme de recherche sans rupture

            testAvecRupture();  //On test l'algorithme de recherche avec rupture

            testDichotomique(); //On test l'algorithme de recherche par dichotomie

        }
        catch (Exception e) {  
            System.out.println("Erreur : "+e.getMessage());

        } 

    }
}
