public class Book {
    private static int BookId = 0;
    private int id=-1;
    private String title, author;
    private boolean borrowState = false;

    Book(String title, String author) {
        BookId++;
        setId(BookId);
        setTitle(title);
        setAuthor(author);
        setBorrowState(false);
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

    public void showProfile() {
        System.out.println(this);
    }

    public void borrowBook() {
        setBorrowState(true);
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();
        strBuild.append(String.format("編號= %d\n", getId()));
        strBuild.append(String.format("書名= %s,作者= %s\n", getTitle(), getAuthor()));
        strBuild.append(String.format("借閱狀態= %b\n", getBorrowState()));
        return strBuild.toString();
    }
}
