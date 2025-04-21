import java.util.LinkedList;

public abstract class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
    public abstract void addCoin(int coin, Child child);
    public abstract void approveTask(String id, String star, LinkedList<Task> taskObjectList,Child child);
    public abstract void rejectTask(String id, LinkedList<Task> taskObjectList);
    public void listAllWishes(){

    }
    public void listAllTaks(){

    }
}
