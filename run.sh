find * -name "*.java" > sources.txt
javac  @sources.txt
java src.ro.academyplus.avaj.simulator.Simulator senario.txt

find . -name "*.class" -type f -delete;
