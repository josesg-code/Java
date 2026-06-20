import java.util.ArrayList;

// This program lets you "book" meetings.
// Before booking, it checks two things:
//   1) Is the input valid? (good title, good start/end time)
//   2) Does it clash with a meeting that is already booked?

public class datetime {

    // We will store every booked meeting in this list.
    // Each meeting is just three pieces of information:
    // a title, a start hour, and an end hour.
    static ArrayList<String> meetingTitles = new ArrayList<>();
    static ArrayList<Integer> meetingStartTimes = new ArrayList<>();
    static ArrayList<Integer> meetingEndTimes = new ArrayList<>();

    public static void main(String[] args) {

        // Let's try booking a few meetings.
        bookMeeting("Team Standup", 9, 10);
        bookMeeting("Client Call", 10, 11);
        bookMeeting("Lunch Sync", 10, 12);   // this should fail: clashes with Client Call
        bookMeeting("", 13, 14);             // this should fail: title is empty
        bookMeeting("Bad Time", 15, 14);     // this should fail: end is before start
        bookMeeting("Planning", 13, 14);     // this should work

        // Show everything that got booked successfully.
        showAllMeetings();
    }

    // This method tries to book one meeting.
    // It returns nothing — it just prints what happened.
    public static void bookMeeting(String title, int startHour, int endHour) {

        // STEP 1: Check the input is valid.
        if (!isInputValid(title, startHour, endHour)) {
            // isInputValid() already printed the reason, so we just stop here.
            return;
        }

        // STEP 2: Check it doesn't clash with an existing meeting.
        if (isThereAConflict(startHour, endHour)) {
            System.out.println("CANNOT book \"" + title + "\" — it clashes with another meeting.");
            return;
        }

        // STEP 3: If we reach here, everything is fine. Save the meeting.
        meetingTitles.add(title);
        meetingStartTimes.add(startHour);
        meetingEndTimes.add(endHour);

        System.out.println("Booked \"" + title + "\" from " + startHour + ":00 to " + endHour + ":00");
    }

    // Checks that the title and times make sense.
    // Returns true if everything is OK, false if something is wrong.
    public static boolean isInputValid(String title, int startHour, int endHour) {

        // Rule 1: the title must not be empty.
        if (title == null || title.trim().isEmpty()) {
            System.out.println("CANNOT book — the title is empty.");
            return false;
        }

        // Rule 2: the start time must be before the end time.
        if (startHour >= endHour) {
            System.out.println("CANNOT book \"" + title + "\" — start time must be before end time.");
            return false;
        }

        // Rule 3: times must be inside a normal 24-hour day.
        if (startHour < 0 || endHour > 24) {
            System.out.println("CANNOT book \"" + title + "\" — time must be between 0 and 24.");
            return false;
        }

        // If we passed every rule, the input is valid.
        return true;
    }

    // Checks if a new meeting (startHour to endHour) overlaps
    // with any meeting we already booked.
    public static boolean isThereAConflict(int startHour, int endHour) {

        // Look at every meeting we already have, one by one.
        for (int i = 0; i < meetingTitles.size(); i++) {

            int existingStart = meetingStartTimes.get(i);
            int existingEnd = meetingEndTimes.get(i);

            // Two meetings overlap if the new one starts before the
            // existing one ends, AND the existing one starts before
            // the new one ends. Draw it on paper if this feels tricky!
            //
            // Example: existing meeting is 10:00-11:00
            //   new meeting 10:30-10:45  -> overlaps (it's inside)
            //   new meeting 9:00-10:00   -> does NOT overlap (ends exactly when other starts)
            boolean overlap = startHour < existingEnd && existingStart < endHour;

            if (overlap) {
                return true; // found a clash, no need to check further
            }
        }

        // We checked every meeting and found no clash.
        return false;
    }

    // Prints out every meeting that was successfully booked.
    public static void showAllMeetings() {
        System.out.println("\n--- Final Schedule ---");

        if (meetingTitles.isEmpty()) {
            System.out.println("No meetings booked.");
            return;
        }

        for (int i = 0; i < meetingTitles.size(); i++) {
            String title = meetingTitles.get(i);
            int start = meetingStartTimes.get(i);
            int end = meetingEndTimes.get(i);
            System.out.println(title + ": " + start + ":00 to " + end + ":00");
        }
    }
}