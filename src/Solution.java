import java.util.*;

public class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int n = prerequisites.length;

    Map<Integer, Course> courseMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int id = prerequisites[i][0];
      int preId = prerequisites[i][1];
      if (courseMap.get(i) == null) {
        Course course = new Course(id);
        course.preIds.add(preId);
        courseMap.put(id, course);
      } else {
        Course course = courseMap.get(id);
        course.preIds.add(preId);
        courseMap.put(id, course);
      }

      if (courseMap.get(preId) == null) {
        Course course = new Course(preId);
        course.inDegree++;
        courseMap.put(preId, course);
      } else {
        Course course = courseMap.get(preId);
        course.inDegree++;
        courseMap.put(preId, course);
      }
    }

    Stack<Course> stack = new Stack<>();
    for (Integer id : courseMap.keySet()) {
      if (courseMap.get(id).inDegree == 0) {
        stack.push(courseMap.get(id));
      }
    }

    int count = 0;
    while (!stack.isEmpty()) {
      Course course = stack.pop();
      courseMap.remove(course.id);
      count++;
      if (count >= numCourses) {
        return true;
      }

      for (Integer preId : course.preIds) {
        Course preCourse = courseMap.get(preId);
        if (preCourse.inDegree == 1) {
          stack.push(preCourse);
        }
        preCourse.inDegree--;
        courseMap.put(preId, preCourse);
      }
    }
    if (courseMap.size() == 0) {
      return true;
    }
    return false;
  }

  class Course {
    int id;
    List<Integer> preIds;
    int inDegree;

    Course(int id) {
      this.id = id;
      this.preIds = new ArrayList<>();
      this.inDegree = 0;
    }
  }
}
