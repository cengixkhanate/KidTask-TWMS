import java.time.LocalDateTime;
import java.util.LinkedList;

public class Child extends Person {
    public int totalPoint = 0;
    public int currentLevel = 1;

    public Child(String name) {
        super(name);
    }

    public void addTotalPoint(int point) {
        this.totalPoint += point;
    }

    public void printTotalPoint() {
        System.out.println("Current Budget: " + this.totalPoint);
    }

    public void printCurrentLevel() {
        if (this.totalPoint >= 0 && this.totalPoint <= 40) {
            this.currentLevel = 1;
        }
        else if (this.totalPoint > 40 && this.totalPoint <= 60) {
            this.currentLevel = 2;
        }
        else if (this.totalPoint > 60 && this.totalPoint <= 80) {
            this.currentLevel = 3;
        }
        else if (this.totalPoint > 80) {
            this.currentLevel = 4;
        }
        else{
            System.out.println("ERROR! Something went wrong.");
            return;
        }
        System.out.println("Current Level: " + this.currentLevel);
    }

    public void completeTask(String id, LinkedList<Task> taskObjectList) {
        int idButInt = Integer.parseInt(id);
        for (Task task : taskObjectList) {
            if (task.getTaskId() == idButInt) {
                task.completeThisTask();
            } else {
                System.out.println("ERROR! There is no such a task with this id: " + task.getTaskId());
            }

        }
    }

    public Wish addWish(String[] wishes) {
        String wishId = wishes[1];
        String title = wishes[2];
        String description = wishes[3];
        return new Wish(wishId, title, description);

    }

    public StartEndWish addStartEndWish(String[] wishes) {
        String wishId = wishes[1];
        String title = wishes[2];
        String description = wishes[3];
        String[] startYearMonthDay = wishes[4].split("-");
        String Syear = startYearMonthDay[0];
        String Smonth = startYearMonthDay[1];
        String Sday = startYearMonthDay[2];
        String[] startHourMinute = wishes[5].split(":");
        String Shour = startHourMinute[0];
        String Sminute = startHourMinute[1];
        String[] endYearMonthDay = wishes[6].split("-");
        String Eyear = endYearMonthDay[0];
        String Emonth = endYearMonthDay[1];
        String Eday = endYearMonthDay[2];
        String[] endHourMinute = wishes[7].split(":");
        String Ehour = endHourMinute[0];
        String Eminute = endHourMinute[1];
        LocalDateTime startTime = getLocalDateTime(Syear, Smonth, Sday, Shour, Sminute);
        LocalDateTime endTime = getLocalDateTime(Eyear, Emonth, Eday, Ehour, Eminute);
        return new StartEndWish(wishId, title, description, startTime, endTime);
    }

    @Override
    public void addCoin(int coin, Child child) {
        System.out.println("You do not have permission to add coin.");
    }

    @Override
    public void approveTask(String id, String star, LinkedList<Task> taskObjectList,Child child) {
        System.out.println("You do not have permission to approve this task.");
    }
    public void rejectTask(String id, LinkedList<Task> taskObjectList) {
        System.out.println("You do not have permission to reject this task.");
    }

    public LocalDateTime getLocalDateTime(String year, String month, String day, String hour, String minute) {
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));


    }
}
