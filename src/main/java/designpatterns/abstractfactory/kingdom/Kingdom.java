package designpatterns.abstractfactory.kingdom;

public class Kingdom {
    private King king;
    private Castle castle;
    private Army army;

    Kingdom(King king, Castle castle, Army army) {
        this.king = king;
        this.castle = castle;
        this.army = army;
    }

    public King getKing() {
        return king;
    }

    public Castle getCastle() {
        return castle;
    }

    public Army getArmy() {
        return army;
    }
}
