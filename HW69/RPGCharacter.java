public abstract class RPGCharacter {
    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public RPGCharacter() {
    }

    public RPGCharacter(String monster_Name, int monster_Level) {
        setName(monster_Name);
        setLevel(monster_Level);
    }
}
