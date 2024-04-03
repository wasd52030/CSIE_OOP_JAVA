public class Manager extends Member implements IBonus {
    private String department, officecall;

    public Manager() {
    }

    public Manager(String name) {
        super(name, null, 0, 0, null);
    }

    public Manager(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Manager(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Manager(String name, String address, int age, double salary) {
        super(name, address, age, salary, null);
        setBounsedSalary();
    }

    public Manager(String name, String address, int age, double salary, String phone) {
        super(name, address, age, salary, phone);
        setBounsedSalary();
    }

    public Manager(String name, String address, int age, double salary, String phone, String department) {
        super(name, address, age, salary, phone);
        setDepartment(department);
        setBounsedSalary();
    }

    public Manager(String name, String address, int age, double salary, String phone, String department,
            String officecall) {
        super(name, address, age, salary, phone);
        setDepartment(department);
        setOfficecall(officecall);
        setBounsedSalary();
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOfficecall(String officecall) {
        this.officecall = officecall;
    }

    @Override
    public void setBounsedSalary() {
        this.setSalery(getSalery() * 2.587);
    }

    @Override
    public String toString() {
        String d = String.format("部門: %s, ", department);
        String o = String.format("職務: %s", officecall);
        return super.toString() + d + o;
    }

    @Override
    void showProfile() {
        System.err.println(this);
    }

}
