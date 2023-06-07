find * -name "*.java" > sources.txt
javac  @sources.txt ; javac -d . src/ro/academyplus/avaj/simulator/Simulator.java
java src.ro.academyplus.avaj.simulator.Simulator senario.txt

find . -name "*.class" -type f -delete;
