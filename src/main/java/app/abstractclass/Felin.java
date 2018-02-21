package app.abstractclass;

public abstract class Felin extends Animal {
    /**
     *  Implémente une méthode abstraite de la classe Animal
     *  Comme c'est une classe abstraite elle n'est pas obligée d'implémenter toutes les méthodes abstraites de ma classe Animal
     */
    public void deplacement() {
      System.out.println("Je me déplace seul !");
    } 
  }