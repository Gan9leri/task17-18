package models;
import lombok.Data;
import java.util.ArrayList;

@Data
public class AddBookRequestBodyModel {

    public String userId;
    private ArrayList<CollectionsOfBooks> collectionOfIsbns;

    public void setIsbn(String value) {
        CollectionsOfBooks isbn = new CollectionsOfBooks();
        isbn.setIsbn(value);
        ArrayList<CollectionsOfBooks> isbnData = new ArrayList<>();
        isbnData.add(isbn);
        this.collectionOfIsbns = isbnData;
    }
}