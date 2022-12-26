import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthlyReport {

    ArrayList<DataByMonth> datasByMonths = new ArrayList<>();
    public void loadFile(String path, int month) {

        List<String> lines = readFileContents(path, month);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i); // item_name,is_expense,quantity,sum_of_one
            String[] parts = line.split(",");
            String title = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            DataByMonth dataByMonth = new DataByMonth(title, isExpense, quantity, price, month);
            datasByMonths.add(dataByMonth);
        }
        if (!lines.isEmpty())
            System.out.println("Отчет за месяц № " + month + " считан!");
    }

    private List<String> readFileContents(String path, int month) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            // TODO: 27.12.2022 Разобраться как красиво впихнуть название месяца вместо цифры.
            System.out.println("Невозможно прочитать файл с месячным отчётом за месяц № " + month + ". " +
                    "Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
