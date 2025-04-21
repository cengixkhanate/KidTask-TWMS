import java.time.LocalDateTime;
import java.util.LinkedList;

public class Teacher extends Person {
    public Teacher(String name) {
        super(name);

    }

    public EndOnlyTask addEndOnlyTask(String[] tasks) {
        char taskAssigner = tasks[1].charAt(0);
        int taskID = Integer.parseInt(tasks[2]);
        String title = tasks[3];
        String description = tasks[4];
        String[] yearMonthDay = tasks[5].split("-");
        String year = yearMonthDay[0];
        String month = yearMonthDay[1];
        String day = yearMonthDay[2];
        String[] hourMinute = tasks[6].split(":");
        String hour = hourMinute[0];
        String minute = hourMinute[1];
        LocalDateTime deadline = getLocalDateTime(year, month, day, hour, minute);
        int taskReward = Integer.parseInt(tasks[7]);
        EndOnlyTask task = new EndOnlyTask(taskID, taskAssigner, title, description, taskReward, deadline);
        return task;
    }

    public StartEndTask addStartEndTask(String[] tasks) {
        char taskAssigner = tasks[1].charAt(0);
        int taskID = Integer.parseInt(tasks[2]);
        String title = tasks[3];
        String description = tasks[4];
        String[] startYearMonthDay = tasks[5].split("-");
        String Syear = startYearMonthDay[0];
        String Smonth = startYearMonthDay[1];
        String Sday = startYearMonthDay[2];
        String[] startHourMinute = tasks[6].split(":");
        String Shour = startHourMinute[0];
        String Sminute = startHourMinute[1];
        String[] endYearMonthDay = tasks[7].split("-");
        String Eyear = endYearMonthDay[0];
        String Emonth = endYearMonthDay[1];
        String Eday = endYearMonthDay[2];
        String[] endHourMinute = tasks[8].split(":");
        String Ehour = endHourMinute[0];
        String Eminute = endHourMinute[1];
        LocalDateTime startTime = getLocalDateTime(Syear, Smonth, Sday, Shour, Sminute);
        LocalDateTime endTime = getLocalDateTime(Eyear, Emonth, Eday, Ehour, Eminute);
        int taskReward = Integer.parseInt(tasks[9]);
        StartEndTask task = new StartEndTask(taskID, taskAssigner, title, description, taskReward, startTime, endTime);
        return task;

    }
    @Override
    public void addCoin(int coin, Child child) {
        child.addTotalPoint(coin);
    }

    @Override
    public void approveTask(String id, String star, LinkedList<Task> taskObjectList,Child child) {
        int idButInt = Integer.parseInt(id);
        int startButInt = Integer.parseInt(star);
        for (Task task : taskObjectList) {
            if (task.getTaskId() == idButInt) {
                task.approveThisTask();
                child.addTotalPoint(idButInt + startButInt);
            }
        }
    }
    @Override
    public void rejectTask(String id, LinkedList<Task> taskObjectList) {
        int idButInt = Integer.parseInt(id);
        for (Task task : taskObjectList) {
            if (task.getTaskId() == idButInt) {
                task.rejectThisTask();
            }
        }
    }

    public LocalDateTime getLocalDateTime(String year, String month, String day, String hour, String minute) {
        LocalDateTime dateTime = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));
        return dateTime;

    }

}
