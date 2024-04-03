public class Equipment {
    private String name;
    private int atkAdd, matkAdd;

    public Equipment(String name, int atkAdd, int matkAdd) {
        this.name = name;
        this.atkAdd = atkAdd;
        this.matkAdd = matkAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtkAdd() {
        return atkAdd;
    }

    public void setAtkAdd(int atkAdd) {
        this.atkAdd = atkAdd;
    }

    public int getMatkAdd() {
        return matkAdd;
    }

    public void setMatkAdd(int matkAdd) {
        this.matkAdd = matkAdd;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("武器名稱=%s\n", name));
        strBuild.append(String.format("物理攻擊加成=%s\n", atkAdd));
        strBuild.append(String.format("魔法攻擊加成=%s\n", matkAdd));

        return strBuild.toString();
    }

    void showEquipment() {
        System.out.println(this);
    }
}
