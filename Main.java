import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the first day of the last menstrual period (YYYY-MM-DD): ");
            String lmpDateString = scanner.nextLine();

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date lmpDate = dateFormat.parse(lmpDateString);

                Date dueDate = calculateDueDate(lmpDate);

                System.out.println("Estimated Due Date: " + dateFormat.format(dueDate));
            } catch (ParseException e){
                System.out.println("Invalid date format. Please use the format YYYY-MM-DD. ");
            }
        }
       
    }

    private static Date calculateDueDate(Date lmpDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lmpDate);

        //add  280days to lmp date
        calendar.add(Calendar.DAY_OF_YEAR, 280);

        return calendar.getTime();
    }
}