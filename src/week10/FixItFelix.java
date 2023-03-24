package week10;

/**
 * @author Andre
 */

/**
 * enum to dictate different possible genres
 * @see Book
 */
enum BookGenre {
    Fiction, NonFiction
}

/**
 * enum to dictate different possible mediums
 * @see PublishedBook
 */
enum BookMedium {
    PhysicalBook, EBook, AudioBook;
}

/**
 * enum to dictate different possible ratings
 * @see ReadBook
 */
enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

/**
 * class Book is the parent class, published and read books are made from it
 */
abstract class Book {
    private String title;
    private String author;
    private BookGenre genre;

    /**
     * constructor for Book class, sets params to their equivalent attributes
     * @param title - title of the book
     * @param author - author of the book
     * @param genre - genre of the book
     */
    Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    /**
     * setter for the title attribute
     * @param title - new title for the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * setter for the author attribute
     * @param author - new author for the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * setter for the genre attribute
     * @param genre - new genre for the book
     */
    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    /**
     * getter for the title attribute
     * @return - title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for the author attribute
     * @return - author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * getter for the genre attribute
     * @return - genre of the book
     */
    public BookGenre getGenre() {
        return genre;
    }

    /**
     * turns the book into a string format by combining its attributes
     * @return - the book in a string format
     */
    public String toString() {
        return(this.title + " by " + this.author);
    }
}

/**
 * class PublishedBook is a child and parent class, it is made from the Book class and serves as a model for ReadBook
 */
class PublishedBook extends Book {
    private int publishDate;
    private BookMedium medium;

    /**
     * constructor for the PublishedBook class, it creates a book and adds exclusive params to their corresponding attributes
     * @param title - title of the book
     * @param author - author of the book
     * @param genre - genre of the book
     * @param publishDate - date the book was published
     * @param medium - way the book was distributed
     */
    PublishedBook(String title, String author, BookGenre genre, int publishDate, BookMedium medium) {
        super(title, author, genre);
        this.publishDate = publishDate;
        this.medium = medium;
    }

    /**
     * setter for the published date attribute
     * @param publishDate - new date of publishing for the book
     */
    public void setPublishedDate(int publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * setter for the medium attribute
     * @param medium - new medium of distribution for the book
     */
    public void setMedium(BookMedium medium) {
        this.medium = medium;
    }

    /**
     * getter for the published date attribute
     * @return - date the book was published
     */
    public int getPublishedDate() {
        return publishDate;
    }

    /**
     * getter for the medium attribute
     * @return - medium of distribution for the book
     */
    public BookMedium getMedium() {
        return medium;
    }

    /**
     * turns the book into a string format by getting a generic book string and combining its published date
     * @return - the book in a string format
     */
    @Override
    public String toString() {
        String msg = super.toString();
        msg += " (" + this.publishDate + ")";
        return(msg);
    }
}

/**
 * class PublishedBook is a child class, it is made from the PublishedBook class
 */
class ReadBook extends PublishedBook {
    private BookRating rating;
    private int readDate;

    /**
     * constructor for the ReadBook class, it creates a published book and adds exclusive params to their corresponding attributes
     * @param title - title of the book
     * @param author - author of the book
     * @param genre - genre of the book
     * @param publishDate - date the book was published
     * @param readDate - date the book was read
     * @param medium - way the book was distributed
     * @param rating - rating given by the reader to the book
     */
    ReadBook(String title, String author, BookGenre genre, int publishDate, int readDate, BookMedium medium, BookRating rating) {
        super(title, author, genre, publishDate, medium);
        this.readDate = readDate;
        this.rating = rating;
    }

    /**
     * setter for the read date attribute
     * @param readDate - new date the book was read
     */
    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }

    /**
     * setter for the rating attribute
     * @param rating - new rating the reader is giving the book
     */
    public void setRating(BookRating rating) {
        this.rating = rating;
    }

    /**
     * getter for the read date attribute
     * @return - date the book was read by the reader
     */
    public int getReadDate() {
        return readDate;
    }

    /**
     * getter for the rating attribute
     * @return - rating of the book given by the reader
     */
    public BookRating getRating() {
        return rating;
    }

    /**
     * turns the book into a string format by getting a generic book string and combining its rating
     * @return - the book in a string format
     */
    @Override
    public String toString() {
        String msg = super.toString();
        msg += " - read in " + this.readDate + ", rated ";
        switch (this.rating) {
            case Rating5:
                msg += "5/5";
                break;
            case Rating4:
                msg += "4/5";
                break;
            case Rating3:
                msg += "3/5";
                break;
            case Rating2:
                msg += "2/5";
                break;
            case Rating1:
                msg += "1/5";
                break;
        }
        return(msg);
    }
}

public class FixItFelix {
    public static void main(String[] args) {
        Book b2 = new PublishedBook("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015, BookMedium.PhysicalBook);
        System.out.println(b2);
        Book b3 = new ReadBook("Perdido Street Station", "China Mieville",
                BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);
    }
}
