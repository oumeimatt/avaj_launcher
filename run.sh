javac  @sources.txt; javac -d . src/ro/academyplus/avaj/simulator/Simulator.java
java src.ro.academyplus.avaj.simulator.Simulator senario.txt

if $1="clear"
    find . -name "*.class" -type f -delete