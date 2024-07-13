//There are n 1-indexed robots, each having a position on a line, health, and movement direction.
//You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.

//All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.

//If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. 
//The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.

//Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.

//Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.

//Note: The positions may be unsorted.



class Robot {
  public int index;
  public int position;
  public int health;
  public char direction;
  public Robot(int index, int position, int health, char direction) {
    this.index = index;
    this.position = position;
    this.health = health;
    this.direction = direction;
  }
}

class Solution {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    List<Integer> ans = new ArrayList<>();
    Robot[] robots = new Robot[positions.length];
    List<Robot> stack = new ArrayList<>(); // running robots

    for (int i = 0; i < positions.length; ++i)
      robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));

    Arrays.sort(robots, (a, b) -> a.position - b.position);

    for (Robot robot : robots) {
      if (robot.direction == 'R') {
        stack.add(robot);
        continue;
      }
      // Collide with robots going right if any.
      while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
        if (stack.get(stack.size() - 1).health == robot.health) {
          stack.remove(stack.size() - 1);
          robot.health = 0;
        } else if (stack.get(stack.size() - 1).health < robot.health) {
          stack.remove(stack.size() - 1);
          robot.health -= 1;
        } else { // stack[-1].health > robot.health
          stack.get(stack.size() - 1).health -= 1;
          robot.health = 0;
        }
      }
      if (robot.health > 0)
        stack.add(robot);
    }

    stack.sort((a, b) -> a.index - b.index);

    for (Robot robot : stack)
      ans.add(robot.health);

    return ans;
  }
}
