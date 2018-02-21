# Useful links

[Buld Java Web Apps with Vs Code](https://code.visualstudio.com/docs/java/java-tutorial)
[Main Java extensions for Vs Code](https://github.com/Microsoft/vscode-java-pack)
[Presentation of RedHat extension Java](https://github.com/redhat-developer/vscode-java)

## Classes abstraites et interfaces

Concepts permettant de bien structurer des programmes

### Classes abstraites

- Nous ne pouvons pas instancier une classe abstraite

- Exemple montrant l'utilité de ces classes : soit un programme qui gère différents types d'animaux (loups, chiens, chats, lions, tigres). Tous ces animaux ont des points communs. Nous pouvons créer une classe mère "Animal". On se retrouve avec la hiérarchie suivante :

![Uml héritage](./pictures/385976.png)

Cependant si l'on instancie un object Animal

    public class Test{
        public static void main(String[] args){
            Animal ani = new Animal();
            ani.manger(); //Que doit-il faire ?
       }
    }

Cela ne rime à rien d'appeler la méthode `manger()` avec une instance de Animal. En effet on ne sait pas précisément ce qu'un animal mange.

D'où l'idée de faire de la classe Animal une classe abstraite.

- Les classes abstraites permettent de définir une superclasse.

- Elles sont déclarées avec le mot-clé `abstract`.

- Les enfants d'une classe abstraite peuvent utiliser tous ses éléments (méthodes et attributs déclarés `public` ou `protected`).

- Possibilité de définir dans ces classes abstraites, des méthodes abstraites. Ces méthodes n'auront pas de corps. Il s'agit jsute d'un en-tête et se termine donc par un `;`. Ces méthodes ne peuvent exister que des dans des classes abstraites.

- Les classes héritant d'une classe abstraite devront (OBLIGATOIRE) implémenter les méthodes abstraites de leur mère comme bon leur semble.

### Les interfaces

- Les interfaces permettent de créer des supertype.

- Les interfaces sont des classes 100% abstraites.

- On n'utilise pas le mot-clé `abstract` dans des interfaces.

- Pour qu'une classe utilise une interface, on utilise le mot-clé `implements`

    public interface I{
        public void A();
        public String B();
    }

    public interface I2{
        public void C();
        public String D();
    }

    public class X implements I, I2{
        public void A(){
          //…
        } 
        public String B(){
          //…
        } 
        public void C(){
          //…
        } 
        public String D(){
          //…
        }
    }

- Lorsque qu'on implémente une classe, on doit obligatoirement redéfinir toutes les méthodes de l'interface.

#### Notes

Le polymorphisme nous permet ceci :

    public static void main(String[] args){
        //Avec cette référence, vous pouvez utiliser les méthodes de l'interface I
        I var = new X();
        //Avec cette référence, vous pouvez utiliser les méthodes de l'interface I2
        I2 var2 = new X();
        var.A();
        var2.C();
    }

### Le pattern strategy

- L'héritage atteint ses limites quand nous devons modifier la hiérarchie des classes.

- Le pattern strategy est basé sur l'encapsulation.

- Consiste à créer des objets avec des données, des méthodes (voire les deux). Le principe de base de ce pattern est "isoler ce qui varie dans votre programme et encapsulez-le".

- Préférez encapsuler des comportements plutôt que de les mettre d'office dans l'objet concerné.

## Java 8 ou la révolution des interfaces

### Des méthodes statiques

- Possibilité de définir des méthodes statiques (via le mot-clé `static`) dans des interfaces. De plus on peut implémenter de telle méthode dans ces mêmes interfaces.

- Pour appeler ces méthodes, on n'instancie pas ces interfaces. On utilise `nom_interface.nom_methode_statique()`.

- Des interfaces peuvent avoir une interface mère. L'héritage a donc été introduit dans les interfaces.

### Des méthodes par défaut

- On peut ajouter un comportement par défaut à des méthodes dans une interface, via le mot-clé `default`.

- Rajouter une méthode dans une interface voulais dire, avant Java 8 et les méthodes par défaut, repasser sur toutes les classes qui implémentent l'interface afin de redéfinir la nouvelle méthode : ce n'est plus la peine maintenant.

## Exceptions

- Bloc try...catch pour capturer des execeptions

- getMessage() de la classe Exception, nous permet de préciser la nature de l'erreur.

- le bloc finally permet de définir des actions à effectuer qu'il y est une exception où qu'il n'y en ait pas.