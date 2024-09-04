

main:
	javac Node.java GradeCalculatorAPI.java

compiletest: main
	javac -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" Node.java GradeCalculatorAPI.java NodeTest.java

test:
	java -cp ".;lib\hamcrest-core-1.3.jar;lib\junit-4.10.jar" org.junit.runner.JUnitCore src\GradeCacluatorAPI\NodeTest