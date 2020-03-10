package iterator;

public class IteratorMain {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf(4);
        bookshelf.appendBook(new Book("Around the world in 80 days"));
        bookshelf.appendBook(new Book("Bible"));
        bookshelf.appendBook(new Book("Cinderella"));
        bookshelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookshelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
