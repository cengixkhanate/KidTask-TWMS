import java.time.LocalDateTime;
import java.util.LinkedList;

public class WishManager {
    public WishManager() {

    }

    public LinkedList<Wish> createWishesFromWishesTxt(LinkedList<String[]> wishList) {
        LinkedList<Wish> wishes = new LinkedList<>();
        for (String[] wish : wishList) {
            if(wish[1].equals("1")){
                String wishId = wish[0];
                String wishTitle = wish[2];
                String wishDescription = wish[3];
                WishApproveStatus approveStatus = WishApproveStatus.valueOf(wish[4]);
                WishRequiredLevel requiredLevel = WishRequiredLevel.valueOf(wish[5]);
                Wish wishExample = new Wish(wishId,wishTitle,wishDescription);
                wishExample.WishHelper(approveStatus, requiredLevel);
                wishes.add(wishExample);

            } else if (wish[1].equals("2")) {
                String wishId = wish[0];
                String wishTitle = wish[2];
                String wishDescription = wish[3];
                String[] sYearMonthDay = wish[4].split("-");
                String sYear = sYearMonthDay[0];
                String sMonth = sYearMonthDay[1];
                String sDay = sYearMonthDay[2];
                String[] sHourMinute = wish[5].split(":");
                String sHour = sHourMinute[0];
                String sMinute = sHourMinute[1];
                LocalDateTime startTime = getLocalDateTime(sYear, sMonth, sDay, sHour, sMinute);
                String [] eYearMontDay = wish[6].split("-");
                String eYear = eYearMontDay[0];
                String eMonth = eYearMontDay[1];
                String eDay = eYearMontDay[2];
                String[] eHourMinute = wish[7].split(":");
                String eHour = eHourMinute[0];
                String eMinute = eHourMinute[1];
                LocalDateTime endTime = getLocalDateTime(eYear, eMonth, eDay, eHour, eMinute);
                WishApproveStatus approveStatus = WishApproveStatus.valueOf(wish[8]);
                WishRequiredLevel requiredLevel = WishRequiredLevel.valueOf(wish[9]);
                StartEndWish wishExample = new StartEndWish(wishId,wishTitle,wishDescription,startTime,endTime);
                wishExample.WishHelper(approveStatus, requiredLevel);
                wishes.add(wishExample);

            }
        }
        return wishes;
    }
    public LocalDateTime getLocalDateTime(String year, String month, String day, String hour, String minute) {
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));

    }
}
