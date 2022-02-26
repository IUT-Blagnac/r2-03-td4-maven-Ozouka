import java.io.*;
import java.util.Scanner;

public class ListeEtudiants {

    /** donne le nombre d’étudiants de la liste pfListe
     *@param   pfListe IN tableau contenant la liste d'étudiants nom, prenom,  
     *@return le nombre d’étudiants de la liste
     **/
    public static int nbEtudiant( Etudiant pfListe[]){
        return pfListe.length;
    }

    /** charge dans un tableau la liste des étudiants
     *@param   pfFileName IN le nom du fichier à lire
     *@param   pfDelimiter IN le délimiteur de champs dans le fichier csv
     *@return le tableau
     **/

    public static Etudiant [] getListe(String pfFileName, String pfDelimiter)throws FileNotFoundException{
        /* nombre  de lignes du fichier */
        BufferedReader read = new BufferedReader(new FileReader(pfFileName));
        int nbElt = 0;
        try
        {
            while (read.readLine() != null)
                nbElt++;
            read.close(); 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 

        /* création du tableau d'étudiants */
        Etudiant res [] = new Etudiant [nbElt];

        /* lecture du fichier */

        String line = "";

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader(pfFileName));
            int cpt = 0;

            System.out.println("Nombre de lignes : " + nbElt);

            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {

                String[] token = line.split(pfDelimiter);    // separate every token by comma
                
                res [cpt] = new Etudiant();
                
                res [cpt].nom = token[0];
                res [cpt].prenom = token[1];
                res [cpt].td = Integer.parseInt(token[2]);
                res [cpt].tp = token[3];

                cpt ++;
            }
            reader.close(); 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return res;

    }
    

    public static void main(String[] args) {
        try {
            Etudiant promo[] = getListe("listenomssansaccent.csv", ",");

            for (int i=0;i<nbEtudiant(promo);i++){

                System.out.println("etu : " +promo [i].nom + " " +promo [i].prenom + " " + promo[i].td + " "+ promo[i].tp);
            }

            System.out.println("Il y a : " + nbEtudiant(promo) + " etudiants"); 

        }
        catch (Exception e) {  
            System.out.println("Erreur : "+e.getMessage());

        } 

    } // fin main

} // fin class