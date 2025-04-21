import java.util.LinkedList;
enum TaskApproveStatus {
    PENDING,
    APPROVED,
    REJECTED,
}
enum TaskCompleteStatus {
    UNCOMPLETED,
    COMPLETE,
}

public class Task {
    public int taskId;
    public char taskAssigner;
    public String title;
    public String description;
    public int taskReward;
    public TaskApproveStatus approveStatus = TaskApproveStatus.PENDING;
    public TaskCompleteStatus completeStatus = TaskCompleteStatus.UNCOMPLETED;


    public Task(int taskId, char taskAssigner, String title, String description, int taskReward) {
        this.taskId = taskId;
        this.taskAssigner = taskAssigner;
        this.title = title;
        this.description = description;
        this.taskReward = taskReward;
    }
    public int getTaskId()
    {
        return this.taskId;
    }
    public void completeThisTask()
    {
        this.completeStatus = TaskCompleteStatus.COMPLETE;
    }
    public void approveThisTask(){
        this.approveStatus = TaskApproveStatus.APPROVED;
    }
    public void rejectThisTask(){
        this.approveStatus = TaskApproveStatus.REJECTED;
    }

}
