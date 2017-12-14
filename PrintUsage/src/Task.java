public class Task {
  private boolean finished;
  private String content;

  public Task(String content) {
    this.finished = false;
    this.content = content;
  }

  public boolean isFinished() {
    return finished;
  }

  public String getContent() {
    return content;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
