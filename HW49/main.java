// file encode utf8 build command -> javac -encoding utf-8 main.java

public class main {

    public static void main(String[] args) {
        Dog d = new Dog();

        d.setBreed("a");
        d.setSize("B");
        d.setColor("w");
        d.setSpecies("dog");
        d.setName("d");
        d.setAge(10);
        d.setVoice("www");
        d.showProfile();
        d.makeSound();
    }
}

class Dog extends Animal {
    private String breed, color, size;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    void showProfile() {
        super.showProfile();
        System.out.printf("品種：%s\n", this.getBreed());
        System.out.printf("顏色：%s\n", this.getColor());
        System.out.printf("體型：%s\n", this.getSize());
    }

    @Override
    void makeSound() {
        System.out.printf("姓名叫做%s的%s，發出了%s的聲音\n", super.getName(), super.getSpecies(), super.getVoice());
        System.out.printf("牠的品種是%s,顏色是%s,體型是%s", this.getBreed(), this.getColor(), this.getSize());
    }
}