public class Staff extends Member {

    private String title;
    private float workyear;

    public Staff() {
    }

    public Staff(String name) {
        super(name, null, 0, 0, null);
    }

    public Staff(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Staff(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Staff(String name, String address, int age, int salary) {
        super(name, address, age, salary, null);
    }

    public Staff(String name, String address, int age, int salary, String phone) {
        super(name, address, age, salary, phone);
    }

    public Staff(String name, String address, int age, int salary, String phone, String title) {
        super(name, address, age, salary, phone);
    }

    public Staff(String name, String address, int age, int salary, String phone, String title, float workyear) {
        super(name, address, age, salary, phone);
        setTitle(title);
        setWorkyear(workyear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getWorkyear() {
        return workyear;
    }

    public void setWorkyear(float workyear) {
        if (workyear >= 0) {
            this.workyear = workyear;
        } else {
            throw new IllegalArgumentException("workyear cannot be negative!");
        }
    }

    public String getStaff() {
        if (workyear < 1) {
            return "新進員工";
        } else if (workyear >= 1 && workyear <= 3) {
            return "副領班";
        } else if (workyear >= 3 && workyear <= 5) {
            return "領班";
        }
        return "組長";
    }

    @Override
    public String toString() {
        String t = String.format("職稱: %s, ", title);
        String f = String.format("年資: %.0f", workyear);
        return super.toString() + t + f;
    }

    @Override
    void showProfile() {
        System.err.println(this);
    }
}
