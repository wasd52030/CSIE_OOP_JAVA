public class Engineer extends Member implements IBonus {

    private String expertise;

    public Engineer() {
    }

    public Engineer(String name) {
        super(name, null, 0, 0, null);
    }

    public Engineer(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Engineer(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Engineer(String name, String address, int age, double salary) {
        super(name, address, age, salary, null);
        setBounsedSalary();
    }

    public Engineer(String name, String address, int age, double salary, String phone) {
        super(name, address, age, salary, phone);
        setBounsedSalary();
    }

    public Engineer(String name, String address, int age, double salary, String phone, String expertise) {
        super(name, address, age, salary, phone);
        setExpertise(expertise);
        setBounsedSalary();
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public void setBounsedSalary() {
        this.setSalery(getSalery()*3.87);
    }

    @Override
    void showProfile() {
        System.err.println(this);
    }

    @Override
    public String toString() {
        String e = String.format("專業技能: %s", expertise);
        return super.toString() + e;
    }
}