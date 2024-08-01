package GradeCalculatorAPI;

import java.util.Map;
import java.util.HashMap;

interface Node{

}

class Root implements Node{
    Map<String,Node> assignments;

    Root(){
        assignments = new HashMap<String,Node>();
    }

    void addAssignment(String title, int points, int maxPoint){
        this.assignments.put(title, new Assignment(points, points, title));
    }

    void addAssignment(String title){
        this.assignments.put(title, new Assignment(title));
    }

    boolean checkAssignmentExists(String title){
        return assignments.containsKey(title);
    }

    Node getAssignment(String title){
        return assignments.get(title);
    }

    void removeAssignment(String title){
        assignments.remove(title);
    }
}

class Assignment implements Node{
    String name;
    int points;
    int totalPoints;
    boolean isGraded;

    Assignment(int points, int totalPoints, String name){
        this.name = name;
        this.points = points;
        this.totalPoints = totalPoints;
    }

    Assignment(int totalPoints, String name){
        this.totalPoints = totalPoints;
        this.name = name;
    }

    Assignment(String name){
        this.name = name;
    }

    void changePoints(int newPoints){
        this.points = newPoints;
    }

    void changeMaxPoints(int maxPoints){
        this.totalPoints = maxPoints;
    }

    boolean isGraded(){
        return this.isGraded;
    }

    void changeGraded(boolean newGraded){
        this.isGraded = newGraded;
    }
}