// file encode utf8 build command -> javac -encoding utf-8 main.java

public class main {

    public static void main(String[] args) {
        Dog d = new Dog();

        // 1.
        // a. 繼承了Animal class
        // b. showProfile method輸出了種族、姓名、年齡、叫聲的資訊
        // b. makeSound method輸出了姓名叫做XXX的XXX，發出了XXX的聲音
        // b. 內容透過繼承Animal獲得的setter進行設定

        // 2.
        // 現階段無法透過showProfile輸出品種、顏色、體型
        // 因為這是Dog class獨有的變數，Animal class並不知道

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
}