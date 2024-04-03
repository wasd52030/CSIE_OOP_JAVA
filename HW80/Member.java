import java.util.regex.Pattern;

public abstract class Member {
    private String name, address, phone;
    private int age;
    private double  salery;

    public Member() {
    }

    public Member(String n, String addr, int age, double s, String phone) {
        setName(n);
        setAddress(addr);
        setPhone(phone);
        setAge(age);
        setSalery(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (Pattern.matches("09\\d{2}-\\d{3}-\\d{3}", phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("illegal phone format!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("age must greater than 0!");
        }
    }

    public double getSalery() {
        return salery;
    }

    public void setSalery(double salery) {
        if (salery > 0) {
            this.salery = salery;
        } else {
            throw new IllegalArgumentException("salery must greater than 0!");
        }
    }

    abstract void showProfile();

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名: %s, 年齡: %d, ", name, age));
        strBuild.append(String.format("地址: %s, 電話: %s, 薪水: %.0f, ", address, phone, salery));

        return strBuild.toString();
    }
}