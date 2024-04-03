public class Character {
    private String name;
    private int hp, mana;
    private int atk, matk;

    public Character() {
        name = null;
        hp = 1;
        mana = 1;
        atk = 1;
        matk = 1;
    }

    public Character(String name, int hp, int mana, int atk, int matk) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.atk = atk;
        this.matk = matk;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名=%s\n", name));
        strBuild.append(String.format("血量=%d, 魔力量=%d\n", hp, mana));
        strBuild.append(String.format("物攻=%d, 魔攻=%d\n", atk, atk));

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

    void showProfile() {
        System.out.println(this);
    }
}
