public class Mage extends Role implements RemoteAttack {

    public Mage(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println("長仗揮擊");
    }

    @Override
    public void R_attack() {
        System.out.println("火遁·豪火球之術");
    }

}
