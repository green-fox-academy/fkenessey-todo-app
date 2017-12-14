import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
  private Path filePath;
  private List<String> fileRawContent;
  private List<Task> fileTaskLines;

  public TaskList() {
    //for GitBash change for "../file.txt"
    this.filePath = Paths.get("../file.txt");
    this.fileRawContent = new ArrayList<>();
    this.fileTaskLines = new ArrayList<>();
  }

  public void readFileContent() {
    try {
      fileRawContent = Files.readAllLines(filePath);
      for (int i = 0; i < fileRawContent.size(); i++) {
        Task taskTemp = new Task(fileRawContent.get(i));
        fileTaskLines.add(i,taskTemp);
      }

    } catch (IOException e) {
      System.out.println("Cannot read file");
    }
    if (fileTaskLines.size() < 1) {
      System.out.println("No todos for today! :)");
    }
  }

  public void listTasks() {
    for (int i = 0; i < fileTaskLines.size(); i++) {
      System.out.println((i + 1) + " - " + fileTaskLines.get(i).getContent());
    }
  }

  public void addTasks(String[] args) {
    try {
      String addSentence = "";
      for (int i = 1; i < args.length; i++) {
        addSentence += args[i] + " ";
      }
      Task tempTask = new Task(addSentence);
      fileTaskLines.add(tempTask);
      try {
        //fileRawContent = new ArrayList<>();
        fileRawContent.clear();
        for (int i = 0; i < fileTaskLines.size(); i++) {
          String stringTemp = fileTaskLines.get(i).getContent();
          fileRawContent.add(stringTemp);
        }
        Files.write(filePath, fileRawContent);
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
      fileTaskLines.remove(index);
    }catch (Exception e){
      System.out.println("Incorrect command!");
    }
    try {
      //fileRawContent = new ArrayList<>();
      fileRawContent.clear();
      for (int i = 0; i < fileTaskLines.size(); i++) {
        String stringTemp = fileTaskLines.get(i).getContent();
        fileRawContent.add(stringTemp);
      }
      Files.write(filePath, fileRawContent);
      System.out.println(args[1] + " task has been removed!");
    } catch (IOException e) {
      System.out.println("Cannot write file");
    }
  }

  /*public void setDoneTasks(String[] args) {
    int index = 0;
    try {

    }catch (Exception e){
      System.out.println("Incorrect command!");
    }
    if (Integer.valueOf(args[1]) > 1 && Integer.valueOf(args[1]) < args.length) {
      index = (Integer.valueOf(args[1])) - 1;
      fileTaskLines.get(index).
      try {
        Files.write(filePath, fileTaskLines);
        System.out.println(args[1] + " task has been removed!");
      } catch (IOException e) {
        System.out.println("Cannot write file");
      }
    } else {
      System.out.println("Incorrect command!");
    }
  }*/
}
