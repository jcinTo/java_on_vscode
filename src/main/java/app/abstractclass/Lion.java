package app.abstractclass;

public class Lion extends Felin {
    
    public Lion(){
    }

    public Lion(String couleur, int poids){
        this.couleur = couleur;
        this.poids = poids;
    }  

    // Obligation d'implémenter les méthodes abstraites de la classe Félin
    public void crier(){
        System.out.println("Je rugis dans la savane !");
    }
}