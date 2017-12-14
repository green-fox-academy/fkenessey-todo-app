import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrintUsage {
  public static void main(String[] args) {
    System.out.println("Command Line Todo application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task\n");

    Path filePath = Paths.get("file.txt");
    List<String> fileContentLines = new ArrayList<>();
    try {
      fileContentLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Cannot read file");
    }
    if (fileContentLines.size() < 1) {
      System.out.println("No todos for today! :)");
    }

    if (args.length > 0) {
      if (args[0].equals("-l")) {
        for (int i = 0; i < fileContentLines.size(); i++) {
          System.out.println((i + 1) + " - " + fileContentLines.get(i));
        }
      }
      else if (args[0].equals("-a")) {
        try {
          String addSentence = "";
          for (int i = 1; i < args.length; i++) {
            addSentence += args[i] + " ";
          }
          fileContentLines.add(addSentence);
          try {
            Files.write(filePath, fileContentLines);
            System.out.println("New task has been added!");
          } catch (IOException e) {
            System.out.println("Cannot write file");
          }
        } catch (Exception e) {
          System.out.println("No task has been entered!");
        }
      } else if (args[0].equals("-r")) {
        try {
          int index = (Integer.valueOf(args[1])) - 1;
          fileContentLines.remove(index - 1);
        }catch (Exception e){
          System.out.println("Incorrect command!");
        }
        try {
          Files.write(filePath, fileContentLines);
          System.out.println(args[1] + " task has been removed!");
        } catch (IOException e) {
          System.out.println("Cannot write file");
        }
      }
    }
  }
}
