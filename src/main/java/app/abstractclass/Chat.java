package app.abstractclass;

public class Chat extends Felin {
    
    public Chat(){
    }

    public Chat(String couleur, int poids){
        this.couleur = couleur;
        this.poids = poids;
    }

    // Obligation d'implémenter les méthodes abstraites de la classe Félin
    public void crier() {
        System.out.println("Je miaule sur les toits !");
    } 
}