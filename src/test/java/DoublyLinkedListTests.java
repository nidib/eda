import map.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTests {

    private static DoublyLinkedList<String> makeList() {
        return new DoublyLinkedList<>();
    }

    @Test
    void itShouldInitCorrectly() {
        var list = makeList();

        Assertions.assertNull(list.getFirst());
        Assertions.assertNull(list.getLast());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void itShouldSetBothHeadAndTailToSameInsertedValueOnFirstInsertion() {
        var list = makeList();
        String firstItem = "Foo";

        list.insertAtEnd(firstItem);

        Assertions.assertEquals(firstItem, list.getFirst());
        Assertions.assertEquals(firstItem, list.getLast());
    }

    @Test
    void itShouldIncreaseTheSizeAsItemsAreInserted() {
        var list = makeList();

        list.insertAtEnd("Foo");
        list.insertAtEnd("Bar");

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void itShouldReturnTheFoundItem() {
        var list = makeList();
        String firstItem = "Foo";

        list.insertAtEnd(firstItem);

        Assertions.assertEquals(firstItem, list.getByValue("Foo"));
    }

    @Test
    void itShouldReturnNullWhenTheItemDoesNotExist() {
        var list = makeList();
        String firstItem = "Foo";

        list.insertAtEnd(firstItem);

        Assertions.assertNull(list.getByValue("Bar"));
    }

    @Test
    void itShouldReturnNullWhenItemIsNotFound() {
        var list = makeList();

        Assertions.assertNull(list.removeByValue("Foo"));
    }

    @Test
    void itShouldRemoveFromAListWithASingleItem() {
        var list = makeList();
        list.insertAtEnd("Foo");

        list.removeByValue("Foo");

        Assertions.assertEquals(0, list.size());
        Assertions.assertNull(list.getFirst());
        Assertions.assertNull(list.getLast());
    }

    @Test
    void itShouldRemoveTheHead() {
        var list = makeList();
        list.insertAtEnd("Foo");
        list.insertAtEnd("Zoo");
        list.insertAtEnd("Bar");

        list.removeByValue("Foo");

        Assertions.assertNull(list.getByValue("Foo"));
        Assertions.assertEquals("Zoo", list.getFirst());
        Assertions.assertEquals("Bar", list.getLast());
    }

    @Test
    void itShouldRemoveTheTail() {
        var list = makeList();
        list.insertAtEnd("Foo");
        list.insertAtEnd("Zoo");
        list.insertAtEnd("Bar");

        list.removeByValue("Bar");

        Assertions.assertNull(list.getByValue("Bar"));
        Assertions.assertEquals("Foo", list.getFirst());
        Assertions.assertEquals("Zoo", list.getLast());
    }

    @Test
    void itShouldRemoveAnItem() {
        var list = makeList();
        list.insertAtEnd("Foo");
        list.insertAtEnd("Zoo");
        list.insertAtEnd("Bar");

        var removed = list.removeByValue("Zoo");

        Assertions.assertNull(list.getByValue("Zoo"));
        Assertions.assertEquals("Zoo", removed);
    }

}
