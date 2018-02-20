package app;

public class Capitale extends Ville{
 
    private String monument;
 
     //Constructeur par défaut
    public Capitale(){
        //Ce mot clé appelle le constructeur de la classe mère
        super();
        monument = "aucun";
    }    
        
    //Constructeur d'initialisation de capitale
    public Capitale(String nom, int hab, String pays, String monument){
        super(nom, pays, hab);
        this.monument = monument;
    }

    public String decrisToi(){
        String str =  super.decrisToi() + "\n \t ==>>" + this.monument+ " en est un monument";
        System.out.println("Invocation de super.decrisToi()");
        
        return str;
    }

    public String toString(){
        String str = super.toString() + "\n \t ==>>" + this.monument + " en est un monument";
        return str;
    }

    /**
    * @return le nom du monument
    */
    public String getMonument() {
        return monument;
    } 

    //Définit le nom du monument
    public void setMonument(String monument) {
        this.monument = monument;
    }

    
}