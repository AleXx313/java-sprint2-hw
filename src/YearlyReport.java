import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YearlyReport {
    public ArrayList<DataByYear> datasByYear = new ArrayList<>();

    public YearlyReport(String path) {
        List<String> lines = readFileContents(path);
        String[] pathParts = path.split("\\.");
        int year = Integer.parseInt(pathParts[1]);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i); // month,amount,is_expense
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);

            boolean isExpense = Boolean.parseBoolean(parts[2]);

            DataByYear dataByYear = new DataByYear(month, amount, isExpense, year);
            datasByYear.add(dataByYear);

        }
        System.out.println("Годовой отчет считан!");
    }

    private List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно файл не находится" +
                    "в нужной директории.");
            return Collections.emptyList();
        }
    }
}
