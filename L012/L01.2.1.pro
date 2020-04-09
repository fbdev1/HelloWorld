#java -jar proguard\proguard-base-5.3.1.jar @L01.2.1.pro

-injars       target/L012.jar
-outjars      target/L01.2.1-out.jar

-libraryjars  <java.home>/lib/rt.jar #contains all of the compiled class files for the base Java Runtime environment
-printmapping pgmapout.map
-dontwarn

-keep public class ru.svn.l012.Main {public static void main(java.lang.String[]);}