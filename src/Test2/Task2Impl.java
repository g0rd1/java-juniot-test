package Test2;

import java.util.*;

/**
 * <h1>Задание №2</h1>
 * Реализуйте интерфейс {@link IElementNumberAssigner}.
 *
 * <p>Помимо качества кода, мы будем обращать внимание на оптимальность предложенного алгоритма по времени работы
 * с учетом скорости выполнения операции присвоения номера:
 * большим плюсом (хотя это и не обязательно) будет оценка числа операций, доказательство оптимальности
 * или указание области, в которой алгоритм будет оптимальным.</p>
 */



//Оценка числа операций:
//Минимальное количество операций, если в листе elements номера элементов начинаются с нуля и совпадают с позицией: O(1)
//Максимальное количество опереций, если в листе elements номера элементов начинаются с нуля и каждый номер не совпадает с позицией: O(n)
//Среднее число операций: O(n)



public class Task2Impl implements IElementNumberAssigner {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IElementNumberAssigner INSTANCE = new Task2Impl();

    @Override
    public void assignNumbers(final List<IElement> elements) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода, работающего за разумное время.
        if (elements.size() < 2) return;
        for (int i = 0; i < elements.size(); i++) {
            numbersChanger(elements, i, i);
        }
    }

    private void numbersChanger(final List<IElement> elements, final int initialPosition, final int position) {
        // initialPosition - позиция, с которой начали искать несовпадения
        // position - позиция в которой в данный момент ищем несовпадение
        if (position != elements.get(position).getNumber()) { // position не совпадает с номер элемента
            final int foundPosition = indexOf(elements, position); // foundPosition - позиция элемента у которого номер совпадает с position
            if (foundPosition != -1) {  //Если найдена позиция, в которой номер элемента совпадает с position
                if (initialPosition == foundPosition) { // Если initialPosition совпадает с foundPosition (проверка для избежания зацикливания)
                    elements.get(position).setupNumber(elements.size() + position); // Присваем элементу с позицией position номер, которого нет в списке
                    return;
                } else { // Если initialPosition не совпадает с foundPosition
                    numbersChanger(elements, initialPosition, foundPosition); //Вызываем этот же метод только с foundPosition в качестве position
                }
            } //Если не найдена позиция, в которой номер элемента совпадает с position
            elements.get(position).setupNumber(position); // Присваем элементу с позицией position номер со значением position
        }
    }

    private int indexOf(final List<IElement> elements, final Integer number) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getNumber() == number) return i;
        }
        return -1;
    }

}
