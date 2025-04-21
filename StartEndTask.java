import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartEndTask extends Task {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    char taskType = '2';

    public StartEndTask(int taskId, char taskAssigner, String title, String description, int taskReward, LocalDateTime startTime, LocalDateTime endTime) {
        super(taskId, taskAssigner, title, description, taskReward);
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void StartEndTaskHelper(TaskApproveStatus approveStatus, TaskCompleteStatus completeStatus) {
        this.approveStatus = approveStatus;
        this.completeStatus = completeStatus;
    }
    public String getStringOfStartEndTask() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm");
        return this.taskId  + "|" + this.taskType + "|" + this.taskAssigner + "|" + this.title + "|" + this.description + "|" + this.startTime.format(formatter) + "|" + this.endTime.format(formatter) + "|" + this.taskReward + "|" + this.completeStatus + "|" + this.approveStatus;

    }
}
