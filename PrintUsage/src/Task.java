import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task {
  private boolean finished;
  Path filePath;
  List<String> fileContentLines;

  public Task() {
    this.finished = false;
    //for GitBash change for "../file.txt"
    this.filePath = Paths.get("file.txt");
    this.fileContentLines = new ArrayList<>();
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public void readFileContent() {
    try {
      fileContentLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Cannot read file");
    }
    if (fileContentLines.size() < 1) {
      System.out.println("No todos for today! :)");
    }
  }

  public void listTasks() {
    for (int i = 0; i < fileContentLines.size(); i++) {
      System.out.println((i + 1) + " - " + fileContentLines.get(i));
    }
  }

  public void addTasks(String[] args) {
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
  }

  public void removeTasks(String[] args) {
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
