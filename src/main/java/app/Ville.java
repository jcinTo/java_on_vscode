package app;

public class Ville{

    // On les met en private pour pas quelles soient accessible via une instance de la classe Ville, exemple ville.nom
    // Ainsi on se protège de toutes modifications des valeurs depuis une autre classe 
    protected String nom;
    protected String pays;
    protected int nbHabitants;
    protected char categorie;

    //Variables publiques qui comptent les instances
    public static int nbreInstances = 0;

    //Variable privée qui comptera aussi les instances
    protected static int nbreInstancesBis = 0;       

    public Ville(){
        
        System.out.println("Création d'une ville!");
        nom = "Marciac";
        pays = "Gascogne";
        nbHabitants = 10;
        this.setCategorie();

        //On incrémente nos variables à chaque appel aux constructeurs
        nbreInstances++;
        nbreInstancesBis++;  
    }

    public Ville(String pNom, String pPays, int pNbHabitants) throws NombreHabitantException, NomVilleException{
        if(nbHabitants < 0){
            // On utilise le second constructeur pour avoir plus d'informations
            throw new NombreHabitantException(pNbHabitants); 
        }
        if(pNom.length() < 3){
            throw new NomVilleException("le nom de la ville est inférieur à 3 caractères ! nom = " + pNom);
        }
        else {
            System.out.println("Création d'une ville!");
            nom = pNom;
            pays = pPays;
            nbHabitants = pNbHabitants;
            this.setCategorie();

            //On incrémente nos variables à chaque appel aux constructeurs
            nbreInstances++;
            nbreInstancesBis++;
        }  
    }

    //*************   ACCESSEURS *************
    
    //Retourne le nom de la ville
    public String getNom()  {  
        return nom;
    }

    //Retourne le nom du pays
    public String getNomPays()
    {
        return pays;
    }

    // Retourne le nombre d'habitants
    public int getNombreHabitants()
    {
        return nbHabitants;
    } 

    //Retourne la catégorie de la ville
    public char getCategorie()
    {
        return categorie;
    }

    public static int getNombreInstancesBis()
    {
        return nbreInstancesBis;
    }  
    
    //*************   MUTATEURS   *************

    //Définit le nom de la ville
    public void setNom(String pNom)
    {
        nom = pNom;
    }

    //Définit le nom du pays
    public void setNomPays(String pPays)
    {
        pays = pPays;
    }

    //Définit le nombre d'habitants
    public void setNombreHabitants(int nbre)
    {
        nbHabitants = nbre;
    }
    
    //Définit la catégorie de la ville
    private void setCategorie() {
    
        int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
        char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int i = 0;
        while (i < bornesSuperieures.length && this.nbHabitants > bornesSuperieures[i])
        i++;

        this.categorie = categories[i];
    }

    //Retourne la description de la ville
    public String decrisToi(){
        return "\t"+this.nom+" est une ville de "+this.pays+ ", elle comporte : "+this.nbHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
    }

    //Retourne une chaîne de caractères selon le résultat de la comparaison
    public String comparer(Ville v1){
        String str = new String();

        if (v1.getNombreHabitants() > this.nbHabitants)
        str = v1.getNom()+" est une ville plus peuplée que "+this.nom;
        
        else
        str = this.nom+" est une ville plus peuplée que "+v1.getNom();
        
        return str;
    }

    //Redéfinition de la méthode toString issu de la superclasse Object de Java
    public String toString(){
        return "\t"+this.nom+" est une ville de "+this.pays+", elle comporte : "+this.nbHabitants+" => elle est donc de catégorie : "+this.categorie;
    }
}