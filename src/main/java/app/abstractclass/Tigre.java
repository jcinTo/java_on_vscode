package app.abstractclass;

public class Tigre extends Felin {
    
    public Tigre(){
    }

    public Tigre(String couleur, int poids){
        this.couleur = couleur;
        this.poids = poids;
    }
    
    // Obligation d'implémenter les méthodes abstraites de la classe Félin
    public void crier(){
        System.out.println("Je grogne très fort !");
    }
}