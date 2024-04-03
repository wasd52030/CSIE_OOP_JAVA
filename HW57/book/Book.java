package book;

public class Book {

    private static int BookId = 0;
    private static int borrowCount = 0;

    private int id = -1;
    protected String title, author;
    private boolean borrowState = false;
    private final String date;

    public Book(String title, String author, String date) {
        BookId++;
        setId(BookId);
        setTitle(title);
        setAuthor(author);
        setBorrowState(false);
        this.date = date;
    }

    public int getBookId() {
        return BookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(boolean s) {
        borrowState = s;
    }

    public String getDate() {
        return date;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public static int getTotalBooks() {
        return BookId;
    }

    public static int getTotalBorrowedBooks() {
        return borrowCount;
    }

    public void showProfile() {
        System.out.println(this + "\n");
    }

    public void borrowBook() {
        setBorrowState(true);
        borrowCount++;
    }

    public void returnBook() {
        setBorrowState(false);
        borrowCount--;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();
        strBuild.append(String.format("編號= %d\n", getId()));
        strBuild.append(String.format("書名= %s,作者= %s\n", getTitle(), getAuthor()));
        strBuild.append(String.format("建立時間= %s\n", getDate()));
        strBuild.append(String.format("借閱狀態= %b\n", getBorrowState()));
        return strBuild.toString();
    }
}
