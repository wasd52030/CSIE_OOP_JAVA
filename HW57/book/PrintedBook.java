package book;

import java.util.ArrayList;
import java.util.List;

public class PrintedBook extends Book {

    protected int numPages;

    public PrintedBook(String title, String author, int numPages, String date) {
        super(title, author, date);
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        var numPagesStr = new ArrayList<>(List.of(super.toString().split("\n")));
        var formatStr = String.format("頁數: %s", numPages);
        var borrowState = numPagesStr.get(numPagesStr.size() - 1);
        numPagesStr.set(numPagesStr.size() - 1, formatStr);
        numPagesStr.add(borrowState);

        return String.join("\n", numPagesStr);
    }
}
