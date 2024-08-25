package src.GradeCalculatorAPI;

public class GradeCalculatorAPI {
    Root assignments;

    void addAssignment(int points, int totalPoints, String name, boolean isGraded){
        assignments.addAssignment(name, points, totalPoints, isGraded);
    }

    void addAssignment(int points, int totalPoints, String name){
        assignments.addAssignment(name, points, totalPoints);
    }

    void addAssignment(int maxPoints, String name){
        assignments.addAssignment(name, maxPoints);
    }

    void addAssignment(String name){
        assignments.addAssignment(name);
    }
 
    boolean checkAssignmentExists(String title){
        return assignments.checkAssignmentExists(title);
    }

    void deleteAssignment(String title){
        assignments.removeAssignment(title);
    }

    void changePoints(String title, int newPoints){
        assignments.getAssignment(title).changePoints(newPoints);
    }

    void changeTotalPoints(String title, int totalPoints){
        assignments.getAssignment(title).changeMaxPoints(totalPoints);
    }


}
