import map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapTests {

    private static Map<String, String> makeMap() {
        return new Map<>();
    }

    @Test
    void itShouldInitCorrectly() {
        var map = makeMap();

        Assertions.assertEquals(0, map.size());
    }

    @Test
    void itShouldAddAnItem() {
        var map = makeMap();

        map.put("pt-BR", "Português (Brasil)");

        Assertions.assertEquals("Português (Brasil)", map.get("pt-BR"));
    }

    @Test
    void itShouldIncreaseTheMapSize() {
        var map = makeMap();

        map.put("pt-BR", "Português (Brasil)");
        map.put("en-US", "Inglês (EUA)");

        Assertions.assertEquals(2, map.size());
    }

    @Test
    void itShouldReturnNullIfInsertedItemDidNotExist() {
        var map = makeMap();

        Assertions.assertNull(map.put("pt-BR", "Português (Brasil)"));
    }

    @Test
    void itShouldReturnTheOldValueIfInsertedItemAlreadyExists() {
        var map = makeMap();

        map.put("pt-BR", "Português (Brazil)");

        Assertions.assertEquals("Português (Brazil)", map.put("pt-BR", "Português (Brasil)"));
    }

    @Test
    void itShouldReplaceTheOldValueWithTheNewOneIfInsertedItemAlreadyExists() {
        var map = makeMap();

        map.put("en-US", "Inglês (EUA)");
        map.put("pt-BR", "Português (Brazil)");
        map.put("pt-PT", "Português (Portugal)");
        map.put("pt-BR", "Português (Brasil)");

        Assertions.assertEquals("Português (Brasil)", map.get("pt-BR"));
    }

    @Test
    void itShouldReturnNullIfItemIsNotInTheMap() {
        var map = makeMap();

        Assertions.assertNull(map.get("pt-BR"));
    }

    @Test
    void itShouldInsertAnItemWithANullKey() {
        var map = makeMap();

        map.put(null, "Nullable");
        map.put(null, "Nullable 2");

        Assertions.assertEquals("Nullable 2", map.get(null));
    }

}
