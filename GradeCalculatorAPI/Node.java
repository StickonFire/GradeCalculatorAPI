package GradeCalculatorAPI;

import java.util.Map;
import java.util.HashMap;

enum GradingStyle{
    PointSystemTotalDefined, 
    PointSystemAddUp
}

interface Node{
    void setPoints(int points);
    void setTotalPoints(int maxPoints);
}

class Root implements Node{
    Map<String,Node> assignments;

    int totalPoints = 0;
    GradingStyle grader = GradingStyle.PointSystemAddUp;

    Root(Map<String, Node> assignments){
        this.assignments = assignments;
    }


    void addAssignment(Assignment assignment){
        this.assignments.put(assignment.name,assignment);
    }

    boolean checkAssignmentExists(String title){
        return assignments.containsKey(title);
    }

    public void setPoints(int newPoints) throws IllegalStateException{
        throw new IllegalStateException("Root doesn't have points to change.");
    }

    public void setGradingStyle(GradingStyle grader){
        this.grader = grader;
    }

    public void setTotalPoints(int maxPoints) {
        this.totalPoints = maxPoints;
    }

    Node getAssignment(String title){
        return assignments.get(title);
    }

    void removeAssignment(String title){
        assignments.remove(title);
    }
}

/**
 * A class that generates assignments.
 */
class AssignmentFactory{

    public static Assignment makeAssignmentOnlyName(String title){
        return new Assignment(title);
    }

    public static Assignment makeAssignment(String title, int points, int totalPoints, boolean isGraded){
        return new Assignment(points,totalPoints,title,isGraded);
    }
}

class RootFactory{
    public static Root makeRoot(){
        return new Root(new HashMap<String,Node>());
    }
}

class Assignment implements Node{
    String name;
    int points = 0;
    int totalPoints = 0;
    boolean isGraded = false;

    Assignment(int points, int totalPoints, String name, boolean isGraded){
        this.name = name;
        this.points = points;
        this.totalPoints = totalPoints;
        this.isGraded = isGraded;
    }

    Assignment(String name){
        this.name = name;
    }

    public void setPoints(int newPoints){
        this.points = newPoints;
    }

    public void setTotalPoints(int maxPoints){
        this.totalPoints = maxPoints;
    }

    boolean isGraded(){
        return this.isGraded;
    }

    void setIsGraded(boolean newGraded){
        this.isGraded = newGraded;
    }

    @Override
    public boolean equals(Object argument){
        Assignment other;
        if(argument instanceof Assignment)
            other = (Assignment) argument;
        else
            return false;
        return this.name.equals(other.name) && this.points == other.points && 
          this.totalPoints == other.totalPoints && this.isGraded == other.isGraded;
    }
}