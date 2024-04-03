public class Warrior extends Character {

    private String role;

    public Warrior() {
    }

    public Warrior(String name, int hp, int mana, int atk, int matk, String role) {
        super(name, hp, mana, atk, matk);

        this.role = role;
    }

    @Override
    public String toString() {
        var roleStr = String.format("職業=%s, ", this.role);
        var skillStr = "技能=[劈砍]";

        return roleStr + super.toString() + skillStr;
    }

    public String getRole() {
        return role;
    }
}
