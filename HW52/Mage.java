public class Mage extends Character {
    private String role;

    public Mage() {
    }

    public Mage(String name, int hp, int mana, int atk, int matk, String role, Equipment e) {
        super(name, hp, mana, atk, matk, e);

        this.role = role;
        if (this.getEquipment() != null) {
            if (this.getEquipment().getName().equals("杖")) {
                this.setMatk(getMatk() + 10);
            }
        }
    }

    @Override
    public String toString() {
        var roleStr = String.format("職業=%s, ", this.role);
        var skillStr = "技能=[魔力爪]\n";
        var equipStr = (getEquipment().equals(null)) ? "無裝備" : getEquipment();

        return roleStr + super.toString() + skillStr + equipStr;
    }

    public String getRole() {
        return role;
    }
}
