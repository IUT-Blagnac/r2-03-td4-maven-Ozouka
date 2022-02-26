/**
 *
 * @author ZOULI-BARRERE Karim DOUVILLE Leo CABRILLAC Anthony
 */
public class TNPEtu {
    int nbElt ;
    Etudiant[] lesElements ;
    
    /** créer un TNPEtu de taille nbMax 
     * @param pfnbMax IN taille max
     */
    TNPEtu(int pfnbMax) {
        this.nbElt = 0 ;
        this.lesElements = new Etudiant[pfnbMax] ;
    }
}

