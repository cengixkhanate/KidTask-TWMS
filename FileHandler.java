import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public FileHandler() {

    }
    public LinkedList<String[]> readTasks(){
        File file = new File("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Tasks.txt");
        LinkedList<String[]> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String task = scanner.nextLine();
                String[] commands = task.split("\\|");
                list.add(commands);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return list;

    }
    public LinkedList<String[]> readWishes(){
        File file = new File("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Wishes.txt");
        LinkedList<String[]> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                String[] commands = command.split("\\|");
                list.add(commands);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return list;

    }
    public LinkedList<String[]> readCommands() {
        File file = new File("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Commands.txt");
        LinkedList<String[]> list = new LinkedList<String[]>();


        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                String[] commands = command.split("\\|");
                list.add(commands);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return list;

    }
    public void writeEndOnlyTasks(EndOnlyTask task) {
        String taskDetails = task.getStringOfEndOnlyTask();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Tasks.txt", true))) {
            writer.write(taskDetails);  // Objeyi yaz
            writer.newLine();  // Yeni satır ekle
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public void writeStartEndTasks(StartEndTask task) {
        String taskDetails = task.getStringOfStartEndTask();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Tasks.txt", true))) {
            writer.write(taskDetails);  // Objeyi yaz
            writer.newLine();  // Yeni satır ekle
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public void printTasks(){
        try (Scanner scanner = new Scanner(new File("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Tasks.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }







    public void writeWishes(Wish wish) {
        String wishDetails = wish.getStringOfWish();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Wishes.txt", true))) {
            writer.write(wishDetails);  // Objeyi yaz
            writer.newLine();  // Yeni satır ekle
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

    }
    public void writeStartEndWishes(StartEndWish wish) {
        String wishDetails = wish.getStringOfStartEndWish();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Wishes.txt", true))) {
            writer.write(wishDetails);  // Objeyi yaz
            writer.newLine();  // Yeni satır ekle
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

    }
    public void printWishes(){
        try (Scanner scanner = new Scanner(new File("C:\\Users\\PC\\Desktop\\Lectures\\IntelliJ Projects\\deneme2\\src\\Wishes.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}
