package mt.edu.um.lesson_4;

public class Averager {

  private int sum;
  private int count;

  public void add(int n) {
    // Increment count
    count++;
    // Increment sum
    sum += n;
  }

  public void combine(Averager avg) {
    this.sum += avg.sum;
    this.count += avg.count;
  }

  public double average() {
    return sum / (double) count;
  }
}
