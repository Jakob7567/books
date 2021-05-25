import java.util.HashMap;
import ecs100.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, remove, find, print all and edit from a menu
 * prevent the user from adding more than 20 books
 * prevent the user from adding duplicates
 *
 * @author Jakob L.
 * @version 25/05/21
 */
public class Books
{
    private HashMap<Integer, Book> booksMap;
    private int curBookId;                  // stores the current id of the book being added
    private ArrayList<String> names;
    
    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        booksMap = new HashMap<Integer, Book>();// initialise hashmap
        names = new ArrayList<String>();
        
        // Creating books
        Book b1 = new Book(1, "Pet Semetary", "Stephen King", 8);
        Book b2 = new Book(2, "Otherland", "Tad Williams", 3);
        Book b3 = new Book(3, "Spear of the Emperor", "Benski Bowden", 18);
        
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        names.add("Pet Semetary");
        names.add("Otherland");
        names.add("Spear of the Emperor");
        
        curBookId = 4;
        menu();
    }
    
    /**
     * Adds a book to the collection
     */
    public void addBook()
    {
        int MAX_QUANTITY = 99;
        int quantity = -1;
        String name;
        if (booksMap.size() >= 20)
        {
            UI.println("Nah bro u gay");
        }
        else
        
        {
            do {
                name = UI.askString("Name: ");
            } while (names.contains(name));
            names.add(name);
            String author = UI.askString("Author: ");
            do {
                quantity = UI.askInt("Quantity: ");
            } while (0 > quantity && quantity < MAX_QUANTITY);
            booksMap.put(curBookId, new Book(curBookId, name, author, quantity));
            curBookId++;
        }
    }
    
    /**
     * finds a book within the collection based on id (not great)
     */
    public void findBook()
    {
        int bookId = UI.askInt("ID: ");
        UI.println(booksMap.get(bookId).getName());
    }
    
    /**
     * prints every book in the collection
     */
    public void printAll()
    {
        for (int bookId : booksMap.keySet())
        {
            UI.println(bookId + "Details:");
            UI.println(booksMap.get(bookId).getName());
            UI.println(booksMap.get(bookId).getAuthor());
            UI.println(booksMap.get(bookId).getQty());
        }
    }
    
    /**
     * Edits a book
     */
    public void edit()
    {
        int MAX_QUANTITY = 99;
        int quantity = -1;
        int bookId;
        do {
            bookId = UI.askInt("ID: ");
        } while (!booksMap.keySet().contains(bookId));
        
        String name = UI.askString("Name: ");
        String author = UI.askString("Author: ");
        
        do {
            quantity = UI.askInt("Quantity: ");
        } while (0 > quantity && quantity < MAX_QUANTITY);
        booksMap.put(bookId, new Book(curBookId, name, author, quantity));
        names.remove(bookId);
        names.set(bookId, name);
    }
    
    /**
     * deletes a book from the collection
     */
    public void delete()
    {
        int bookId = UI.askInt("ID: ");
        if (bookId < curBookId)
        {
            booksMap.remove(bookId);
        }
        else
        {
            UI.println("ur trash kid");
        }
        names.remove(bookId);
    }
    
    /**
     * Robust Menu to print and call apropriate methods
     */
    public void menu()
    {
        // list of options
        ArrayList<String> choices = new ArrayList<>(Arrays.asList("A", "P", "Q"));
        
        // print menu and force choices
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(E)dit a book");
            UI.println("(D)elete a book");
            UI.println("(Q)uit");
            choice = UI.askString("Enter a choice");
            
            if (choice.equalsIgnoreCase("A"))
            {
                    addBook();
            }
            else if (choice.equalsIgnoreCase("F"))
            {
                    findBook();
            }
            else if (choice.equalsIgnoreCase("P"))
            {
                    printAll();
                }
            else if (choice.equalsIgnoreCase("E"))
            {
                    edit();
                }
            else if (choice.equalsIgnoreCase("D"))
            {
                    delete();
                }
            else if (choice.equalsIgnoreCase("Q"))
            {
                    UI.println("Goodbye!");
                    break;
                }
            else
            {
                    UI.println("That is not a choice u dumbass. Not pog");
                }
        } while (!choices.contains(choice));
    }
}
