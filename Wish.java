enum WishApproveStatus {
    APPROVED,
    REJECTED,
    PENDING,
}
enum WishRequiredLevel{
    PENDING,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
}
public class Wish {
    public String wishID;
    public String title;
    public String description;
    public char wishType = '1';
    public WishRequiredLevel requiredLevel = WishRequiredLevel.PENDING;
    public WishApproveStatus approveStatus = WishApproveStatus.PENDING;
    public Wish(String wishID, String title, String description) {
        this.wishID = wishID;
        this.title = title;
        this.description = description;
    }
    public void WishHelper(WishApproveStatus approveStatus, WishRequiredLevel requiredLevel){
        this.approveStatus = approveStatus;
        this.requiredLevel = requiredLevel;
    }
    public String getStringOfWish() {
        return this.wishID + "|" + this.wishType + "|" + this.title + "|" + this.description + "|" + this.approveStatus + "|" + this.requiredLevel;

    }
    public void setRequiredLevelWhileApprovingRejecting(String requiredLevel) {
        WishRequiredLevel requiredLevelButEnum = WishRequiredLevel.valueOf(requiredLevel);
        this.requiredLevel =requiredLevelButEnum;
    }

    public void approveThisWish() {
        this.approveStatus = WishApproveStatus.APPROVED;
    }
    public void rejectThisWish() {
        this.approveStatus = WishApproveStatus.REJECTED;
    }
}
