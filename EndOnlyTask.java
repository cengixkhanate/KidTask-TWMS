import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndOnlyTask extends Task{
    LocalDateTime deadline;
    char taskType = '1';

    public EndOnlyTask(int taskId, char taskAssigner, String title, String description, int taskReward,LocalDateTime deadline) {
        super(taskId, taskAssigner, title, description, taskReward);
        this.deadline = deadline;
    }
    public void EndOnlyTaskHelper(TaskApproveStatus approveStatus, TaskCompleteStatus completeStatus) {
        this.approveStatus = approveStatus;
        this.completeStatus = completeStatus;
    }
    public String getStringOfEndOnlyTask() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm");
        return this.taskId + "|" + this.taskType + "|" + this.taskAssigner + "|" + this.title + "|" + this.description + "|" + this.deadline.format(formatter) + "|" + this.taskReward + "|" + this.completeStatus + "|" + this.approveStatus;

    }
}
