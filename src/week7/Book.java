package week7;

enum BookMedium {
    PhysicalBook, EBook, AudioBook;
}

enum BookGenre {
    Fiction, NonFiction
}

enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

public class Book {
    private String title;
    private String author;
    private int publishDate;
    private int readDate;
    private BookMedium medium;
    private BookGenre genre;
    private BookRating rating;

    Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    Book(String title, String author, BookGenre genre, int publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
    }

    Book(String title, String author, BookGenre genre, int publishDate, int readDate, BookMedium medium, BookRating rating) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.readDate = readDate;
        this.medium = medium;
        this.genre = genre;
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }

    public void setMedium(BookMedium medium) {
        this.medium = medium;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public void setRating(BookRating rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedDate() {
        return publishDate;
    }

    public int getReadDate() {
        return readDate;
    }

    public BookMedium getMedium() {
        return medium;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public BookRating getRating() {
        return rating;
    }

    public String toString() {
        String message = this.title + " by " + this.author;
        if(this.publishDate != 0) {
            message += " (" + this.publishDate + ")";
        }
        if(this.readDate != 0) {
            message += " - read in " + this.readDate + ", rated ";
            switch(this.rating) {
                case Rating5:
                    message += "5/5";
                    break;
                case Rating4:
                    message += "4/5";
                    break;
                case Rating3:
                    message += "3/5";
                    break;
                case Rating2:
                    message += "2/5";
                    break;
                case Rating1:
                    message += "1/5";
                    break;
            }
        }
        return(message);
    }

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
                BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}
