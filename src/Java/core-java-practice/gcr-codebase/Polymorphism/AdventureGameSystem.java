class GameCharacter {
    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    void performAttack() {
        System.out.println(characterName + " attacks.");
    }
}

class Warrior extends GameCharacter {
    Warrior(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " attacks with a sword.");
    }
}

class Mage extends GameCharacter {
    Mage(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " casts a fireball spell.");
    }
}

class Archer extends GameCharacter {
    Archer(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " shoots an arrow.");
    }
}

public class AdventureGameSystem {

    static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter c : characters) {
            c.performAttack();

            if (c instanceof Warrior) {
                warriorCount++;
            } else if (c instanceof Mage) {
                mageCount++;
            } else if (c instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println();
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] characters = {
                new Warrior("Thor"),
                new Mage("Merlin"),
                new Archer("Robin"),
                new Warrior("Arthur")
        };

        startBattle(characters);
    }
}
