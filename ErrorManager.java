public class ErrorManager {
    public ErrorManager() {

    }
    public void permissionError() {
        System.out.println("You do not have permission to perform this action");
    }
    public void missingApproveOrRejectIndicatorError()
    {
        System.out.println("Please indicate whether you approve or reject the task.");
    }

}

