public class Character {
    private String name;
    private int hp, mana;
    private int atk, matk;
    private Equipment equipment;

    public Character() {
        name = null;
        hp = 1;
        mana = 1;
        atk = 1;
        matk = 1;
        equipment = null;
    }

    public Character(String name, int hp, int mana, int atk, int matk, Equipment e) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.atk = atk;
        this.matk = matk;
        Equip(e);
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名=%s\n", name));
        strBuild.append(String.format("血量=%d, 魔力量=%d\n", hp, mana));
        strBuild.append(String.format("物攻=%d, 魔攻=%d\n", atk, matk));

        return strBuild.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getMatk() {
        return matk;
    }

    public void setMatk(int matk) {
        this.matk = matk;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void Equip(Equipment e) {
        this.setEquipment(e);
        if (getEquipment() != null) {
            this.setAtk(this.getAtk() + this.getEquipment().getAtkAdd());
            this.setMatk(this.getMatk() + this.getEquipment().getMatkAdd());
        }
    }

    void showProfile() {
        System.out.println(this);
    }
}
