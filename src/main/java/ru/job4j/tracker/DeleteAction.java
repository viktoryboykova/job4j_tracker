package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
