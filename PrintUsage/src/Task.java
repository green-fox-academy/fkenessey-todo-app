public class Task {
  private boolean ifFinished;
  private String content;

  public Task(String content) {
    this.ifFinished = false;
    this.content = content;
  }

  public boolean isIfFinished() {
    return ifFinished;
  }

  public String getContent() {
    return content;
  }

  public void setIfFinished(boolean ifFinished) {
    this.ifFinished = ifFinished;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
