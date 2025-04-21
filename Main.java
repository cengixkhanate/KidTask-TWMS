
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Teacher teacher = new Teacher("Sevgi Koyuncu Tunç");
        Parent parent = new Parent("Cengizhan Aydoğan");
        Child child = new Child("Ali Baran Gündoğan");
        TaskManager taskManager = new TaskManager();
        ErrorManager errorManager = new ErrorManager();
        WishManager wishManager = new WishManager();
        LinkedList<String[]> commandList = new LinkedList<>();
        FileHandler fh = new FileHandler();
        commandList = fh.readCommands();
        LinkedList<String[]> taskList = new LinkedList<>();
        taskList = fh.readTasks();
        LinkedList<Task> taskObjectList = new LinkedList<>();
        taskObjectList = taskManager.createTasksFromTaskTxt(taskList);
        LinkedList<String[]> wishList = new LinkedList<>();
        wishList = fh.readWishes();
        LinkedList<Wish> wishObjectList = new LinkedList<>();
        wishObjectList = wishManager.createWishesFromWishesTxt(wishList);
        for (String[] command : commandList) {
            if (command[0].equals("ADD_TASK1")) { // command'in 0. elamanı = ADD_TASK1
                if (command[1].equals("T")) {
                    EndOnlyTask task = teacher.addEndOnlyTask(command);
                    FileHandler fh2 = new FileHandler();
                    fh2.writeEndOnlyTasks(task);
                } else if (command[1].equals("P")) {
                    EndOnlyTask task = parent.addEndOnlyTask(command);
                    FileHandler fh2 = new FileHandler();
                    fh2.writeEndOnlyTasks(task);

                }
            } else if (command[0].equals("ADD_TASK2")) {
                if (command[1].equals("T")) {
                    StartEndTask task = teacher.addStartEndTask(command);
                    FileHandler fh2 = new FileHandler();
                    fh2.writeStartEndTasks(task);

                } else if (command[1].equals("P")) {
                    StartEndTask task = parent.addStartEndTask(command);
                    FileHandler fh2 = new FileHandler();
                    fh2.writeStartEndTasks(task);


                }

            } else if (command[0].equals("LIST_ALL_TASKS")) {//ÜSTÜNE DÜŞÜNÜLECEK
                FileHandler fh2 = new FileHandler();
                fh2.printTasks();

                /* if (command[1].equals("D")) {

                } else if (command[1].equals("W")) {

                } else {
                    FileHandler fh2 = new FileHandler();
                    fh2.printTasks();
                } */

            } else if (command[0].equals("LIST_ALL_WISHES")) {
                FileHandler fh2 = new FileHandler();
                fh2.printTasks();

            } else if (command[0].equals("TASK_DONE")) {
                child.completeTask(command[1], taskObjectList);

            } else if (command[0].equals("TASK_CHECKED")) {
                if (command[1].equals("T")) {
                    if (command[2].equals("A")) {
                        teacher.approveTask(command[3], command[4], taskObjectList,child);
                    }
                    else if (command[2].equals("R")) {
                        teacher.rejectTask(command[3], taskObjectList);
                    }
                    else {
                        errorManager.missingApproveOrRejectIndicatorError();
                    }

                } else if (command[1].equals("P")) {
                    if (command[2].equals("A")) {
                        parent.approveTask(command[3], command[4], taskObjectList,child);
                    }
                    else if (command[2].equals("R")) {
                        parent.rejectTask(command[3], taskObjectList);
                    }
                    else {
                        errorManager.missingApproveOrRejectIndicatorError();
                    }
                } else {
                    if (command[2].equals("A")) {
                        child.approveTask(command[3], command[4], taskObjectList,child);
                    }
                    else if (command[2].equals("R")) {
                        child.rejectTask(command[3], taskObjectList);
                    }
                    else {
                        errorManager.missingApproveOrRejectIndicatorError();
                    }
                }

            } else if (command[0].equals("ADD_WISH1")) {
                Wish wish = child.addWish(command);
                FileHandler fh2 = new FileHandler();
                fh2.writeWishes(wish);

            } else if (command[0].equals("ADD_WISH2")) {
                StartEndWish wish = child.addStartEndWish(command);
                FileHandler fh2 = new FileHandler();
                fh2.writeStartEndWishes(wish);

            } else if (command[0].equals("ADD_BUDGET_COIN")) {
                if (command[1].equals("T")) {
                    int coin = Integer.parseInt(command[2]);
                    teacher.addCoin(coin, child);
                } else if (command[1].equals("P")) {
                    int coin = Integer.parseInt(command[2]);
                    parent.addCoin(coin, child);
                } else {
                    int coin = Integer.parseInt(command[2]);
                    child.addCoin(coin, child);
                }

            } else if (command[0].equals("WISH_CHECKED")) {
                if(command[1].equals("P")) {
                    if (command[2].equals("A")) {
                        parent.approveWish(command[3], command[4], wishObjectList);

                    }
                    else if (command[2].equals("R")) {
                        parent.rejectWish(command[3], command[4], wishObjectList);
                    }
                    else {
                        errorManager.missingApproveOrRejectIndicatorError();
                    }
                }
                else {
                    errorManager.permissionError();
                }

            } else if (command[0].equals("PRINT_BUDGET")) {
                child.printTotalPoint();

            } else if (command[0].equals("PRINT_STATUS")) {
                child.printCurrentLevel();
            } else {
                System.out.println("Invalid command");
            }
        }


    }


}