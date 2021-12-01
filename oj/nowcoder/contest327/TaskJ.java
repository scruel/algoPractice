package algsPractice.oj.nowcoder.contest327;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class TaskJ {
  class Course implements Comparable<Course>{
    private int time;
    private int cost;

    public Course(int time, int cost) {
      this.time = time;
      this.cost = cost;
    }

    @Override
    public int compareTo(Course o) {
      return this.time - o.time;
    }
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a[] = new int[n];
    PriorityQueue<Course> courses = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      courses.add(new Course(in.nextInt(), a[i]));
    }
    int c = 0;
    while (!courses.isEmpty()) {
      Course course = courses.poll();
      c += course.cost;
      if (course.time < c){
        out.println("NO");
        return;
      }
      c += 2;
    }
    out.println("YES");
  }
}
