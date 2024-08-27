package src.GradeCalculatorAPI;

public class GradeCalculatorAPI {
    Root assignments;

    void addAssignment(int points, int totalPoints, String name, boolean isGraded){
        assignments.addAssignment(AssignmentFactory.makeAssignment(name, points, totalPoints, isGraded));
    }

    void addAssignment(String name){
        assignments.addAssignment(AssignmentFactory.makeAssignmentOnlyName(name));
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
