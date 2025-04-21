import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskManager {

    public TaskManager(){

    }
    public LinkedList<Task> createTasksFromTaskTxt(LinkedList<String[]> tasks){
        LinkedList<Task> taskObjectList = new LinkedList<>();
        for (String[] task : tasks) {
            if(task[1].equals("1")){
                int id = Integer.parseInt(task[0]);
                char assigner = task[2].charAt(0);
                String title = task[3];
                String description = task[4];
                String[] yearMonthDay = task[5].split("-");
                String year = yearMonthDay[0];
                String month = yearMonthDay[1];
                String day = yearMonthDay[2];
                String[] hourMinute = task[6].split(":");
                String hour = hourMinute[0];
                String minute = hourMinute[1];
                LocalDateTime deadline = getLocalDateTime(year, month, day, hour, minute);
                int reward = Integer.parseInt(task[7]);
                TaskCompleteStatus completeStatus = TaskCompleteStatus.valueOf(task[8]);
                TaskApproveStatus approveStatus = TaskApproveStatus.valueOf(task[9]);
                EndOnlyTask taskExample = new EndOnlyTask(id,assigner,title,description,reward,deadline);
                taskExample.EndOnlyTaskHelper(approveStatus,completeStatus); // a helper method to assign a value to approveStatus and completeStatus.
                taskObjectList.add(taskExample);
            } else if (task[1].equals("2")) {
                int id = Integer.parseInt(task[0]);
                char assigner = task[2].charAt(0);
                String title = task[3];
                String description = task[4];
                String[] sYearMonthDay = task[5].split("-");
                String sYear = sYearMonthDay[0];
                String sMonth = sYearMonthDay[1];
                String sDay = sYearMonthDay[2];
                String[] sHourMinute = task[6].split(":");
                String sHour = sHourMinute[0];
                String sMinute = sHourMinute[1];
                LocalDateTime startTime = getLocalDateTime(sYear, sMonth, sDay, sHour, sMinute);
                String [] eYearMontDay = task[7].split("-");
                String eYear = eYearMontDay[0];
                String eMonth = eYearMontDay[1];
                String eDay = eYearMontDay[2];
                String[] eHourMinute = task[8].split(":");
                String eHour = eHourMinute[0];
                String eMinute = eHourMinute[1];
                LocalDateTime endTime = getLocalDateTime(eYear, eMonth, eDay, eHour, eMinute);
                int reward = Integer.parseInt(task[9]);
                TaskCompleteStatus completeStatus = TaskCompleteStatus.valueOf(task[10]);
                TaskApproveStatus approveStatus = TaskApproveStatus.valueOf(task[11]);
                StartEndTask taskExample = new StartEndTask(id,assigner,title,description,reward,startTime,endTime);
                taskExample.StartEndTaskHelper(approveStatus,completeStatus); // a helper method to assign a value to approveStatus and completeStatus.
                taskObjectList.add(taskExample);
            }
        }
        return taskObjectList;
    }
    public void filterTasksMonthly(){

    }
    public void filterTasksWeekly(){

    }
    public LocalDateTime getLocalDateTime(String year, String month, String day, String hour, String minute) {
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));

    }

}
