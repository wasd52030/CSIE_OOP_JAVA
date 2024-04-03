public class Warrior extends Role {

    public Warrior(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println("拔刀斬");
    }

}
