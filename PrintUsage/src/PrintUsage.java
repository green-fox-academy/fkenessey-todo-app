public class PrintUsage {
  public static void main(String[] args) {
    System.out.println("Command Line Todo application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task\n");

    TaskList taskList = new TaskList();
    taskList.readFileContent();

    if (args.length > 0) {
      if (args[0].equals("-l")) {
        taskList.listTasks();
      } else if (args[0].equals("-a")) {
        taskList.addTasks(args);
      } else if (args[0].equals("-r")) {
        taskList.removeTasks(args);
      } else if (args[0].equals("-c")) {
        taskList.checkTask(args);
      }
    }
  }
}
