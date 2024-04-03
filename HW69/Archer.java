public class Archer extends Role implements RemoteAttack {

    public Archer(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
       System.out.println("近身攻擊");
    }

    @Override
    public void R_attack() {
        System.out.println("二連矢攻擊");
    }
    
}
