package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        new StartUI(output).init(in, tracker, Arrays.asList(new CreateAction(output), new ExitAction(output)));
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", replacedName, "1"}
        );
        Output output = new StubOutput();
        new StartUI(output).init(in, tracker, Arrays.asList(new ReplaceAction(output),
                new ExitAction(output)));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Output output = new StubOutput();
        new StartUI(output).init(in, tracker, Arrays.asList(new DeleteAction(output),
                new ExitAction(output)));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        new StartUI(out).init(in, tracker, Arrays.asList(new ExitAction(out)));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator() +
                        "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        new StartUI(out).init(in, tracker, Arrays.asList(new ReplaceAction(out),
                new ExitAction(out)));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item one2 = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        new StartUI(out).init(in, tracker, Arrays.asList(new FindAllAction(out),
                new ExitAction(out)));
        String ln = System.lineSeparator();

        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : tracker.findAll()) {
            stringBuilder.append(item).append(ln);
        }

        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find All Item" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + stringBuilder.toString()
                        + "Menu:" + ln
                        + "0. Find All Item" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("kisa"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        new StartUI(out).init(in, tracker, Arrays.asList(new FindByIdAction(out),
                new ExitAction(out)));
        String ln = System.lineSeparator();

        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find Item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("kisa"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getName()), "1"}
        );
        new StartUI(out).init(in, tracker, Arrays.asList(new FindByNameAction(out),
                new ExitAction(out)));
        String ln = System.lineSeparator();

        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find Item by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        new StartUI(out).init(in, tracker, Arrays.asList(new ExitAction(out)));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }
}