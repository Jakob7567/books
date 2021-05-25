
/**
 * Class of book
 * contains an id, name, author, quantity and image
 *
 * @author Jakob L.
 * @version 25/05/21
 */
public class Book
{
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;       // to be completed
    
    /**
     * Construtor to make the book object
     */
    public Book(int id, String nm, String aut, int qty)
    {
        this.id = id;
        this.name = nm;
        this.author = aut;
        this.quantity = qty;
    }
    
    /**
     * getter for id
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * getter for name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * getter for author
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * getter for id
     */
    public int getQty()
    {
        return this.quantity;
    }
}
