package book;

import java.util.ArrayList;
import java.util.List;

public class EBook extends Book {

    protected String format;

    public EBook(String title, String author,String format, String date) {
        super(title, author, date);
        this.format = format;
    }

    @Override
    public String toString() {
        var superStr = new ArrayList<>(List.of(super.toString().split("\n")));
        var formatStr = String.format("格式: %s", format);
        var borrowState = superStr.get(superStr.size() - 1);
        superStr.set(superStr.size() - 1, formatStr);
        superStr.add(borrowState);

        return String.join("\n", superStr);
    }

}
