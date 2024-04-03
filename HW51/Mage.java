public class Mage extends Character {
    private String role;

    public Mage() {
    }

    public Mage(String name, int hp, int mana, int atk, int matk, String role) {
        super(name, hp, mana, atk, matk);

        this.role = role;
    }

    @Override
    public String toString() {
        var roleStr = String.format("職業=%s, ", this.role);
        var skillStr = "技能=[魔力爪]";

        return roleStr + super.toString() + skillStr;
    }

    public String getRole() {
        return role;
    }
}
