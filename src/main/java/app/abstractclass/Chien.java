package app.abstractclass;

// L'ordre est primordial, il faut d'abord mettre l'héritage puis l'implémentation de l'interface
public class Chien extends Canin implements Rintintin{
    
    public Chien(){
    }

    public Chien(String couleur, int poids){
        this.couleur = couleur;
        this.poids = poids;
    } 

    // Obligation d'implémenter les méthodes abstraites de la classe Animal
    public void crier() {
        System.out.println("J'aboie sans raison !");
    }

    public void faireCalin() {
        System.out.println("Je te fais un GROS CÂLIN");               
    }
    
    public void faireLeBeau() {
        System.out.println("Je fais le beau !");
    }
    
    public void faireLechouille() {
        System.out.println("Je fais de grosses léchouilles...");
    } 
}