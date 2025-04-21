import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartEndWish extends Wish{
    public LocalDateTime startingTime;
    public LocalDateTime endingTime;
    public char wishType = '2';
    public StartEndWish(String wishId, String title, String description,LocalDateTime startingTime, LocalDateTime endingTime) {
        super(wishId, title, description);
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }
    public String getStringOfStartEndWish()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm");
        return this.wishID + "|" + this.wishType + "|" + this.title + "|" + this.description + "|" + this.startingTime.format(formatter) + "|" + this.endingTime.format(formatter) + "|" + this.approveStatus + "|" + this.requiredLevel;

    }
}
