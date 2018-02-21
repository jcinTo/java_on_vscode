package app.abstractclass;

public abstract class Animal {
    
    // Les animaux seront tous de couleur et de poids différents
    protected String couleur;
    protected int poids;
    
    public Animal(){
    }

    // On considère que les animaux boivent et mangent les mêmes choses
    public void manger() {
        System.out.println("Je mange de la viande.");
    }

    public void boire() {
        System.out.println("Je bois de l'eau !");
    }

    // On considère que les animaux ne se déplacent pas et ne crient pas de la même façon
    public abstract void deplacement();

    public abstract void crier();

    public String toString(){
        String str = "Je suis un objet de la " + this.getClass() + ", je suis " + this.couleur + ", je pèse " + this.poids;
        return str;
    }
}