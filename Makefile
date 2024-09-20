all:
	javac GradeCalculatorAPI\Node.java GradeCalculatorAPI\GradeCalculatorAPI.java gradeCalculatorAPI\Fraction.java

compileTestAll:
	javac -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" GradeCalculatorAPI\Node.java GradeCalculatorAPI\GradeCalculatorAPI.java GradeCalculatorAPI\NodeTest.java GradeCalculatorAPI\Fraction.java GradeCalculatorAPI\FractionTest.java GradeCalculatorAPI\GetGradeTest.java GradeCalculatorAPI\GradeCalculatorAPITest.java GradeCalculatorAPI\NodeTest.java

testGradeCalculatorAPI: compileAllTest
	java -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" org.junit.runner.JUnitCore GradeCalculatorAPI.GradeCalculatorAPITest

testGetGrade: compileAllTest
	java -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" org.junit.runner.JUnitCore GradeCalculatorAPI.GetGradeTest

compileTestNode: 
	javac -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" GradeCalculatorAPI\Fraction.java GradeCalculatorAPI\Node.java GradeCalculatorAPI\NodeTest.java

testNode: compileTestNode
	java -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" org.junit.runner.JUnitCore GradeCalculatorAPI.NodeTest

compileTestFraction:
	javac -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" GradeCalculatorAPI\Fraction.java GradeCalculatorAPI\FractionTest.java

testFraction: compileTestFraction
	java -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" org.junit.runner.JUnitCore GradeCalculatorAPI.FractionTest