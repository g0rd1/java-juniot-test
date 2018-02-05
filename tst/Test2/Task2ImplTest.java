package Test2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Task2ImplTest {

    @Test
    public void assignNumbersTest1() throws Exception {

        final Task2Impl task2 = new Task2Impl();

        final List<IElement> elements = new ArrayList<>();

        final Set<Integer> numbers = new LinkedHashSet<>();

        final List<Integer> expectedNumbers = new ArrayList<>();

        final List<Integer> actualNumbers = new ArrayList<>();

        final int NUMBER_OF_ELEMENTS = 100;

        while (numbers.size() < NUMBER_OF_ELEMENTS) {
            numbers.add((int) (Math.random() * NUMBER_OF_ELEMENTS));
        }

        for (Integer number : numbers) {
            elements.add(new ElementExampleImpl(new ElementExampleImpl.Context(), number));
        }

        task2.assignNumbers(elements);

        for (IElement element : elements) {
            actualNumbers.add(element.getNumber());
        }

        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            expectedNumbers.add(i);
        }

        assertArrayEquals(expectedNumbers.toArray(), actualNumbers.toArray());

    }

}