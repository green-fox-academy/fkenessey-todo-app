public class PrintUsage {
  public static void main(String[] args) {
    System.out.println("Command Line Todo application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task\n");

    Task task = new Task();
    task.readFileContent();

    if (args.length > 0) {
      if (args[0].equals("-l")) {
        task.listTasks();
      } else if (args[0].equals("-a")) {
        task.addTasks(args);
      } else if (args[0].equals("-r")) {
        task.removeTasks(args);
      }
    }
  }
}
