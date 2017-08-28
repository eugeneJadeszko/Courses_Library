REM Compile classes
cd src
dir /s /B *.java > ../sources.txt
cd ..
javac -classpath ./WebContent/WEB-INF/lib/* -d bin @sources.txt

REM Copy configs, properties and other files
xcopy /Y resources\* bin\ /e

pause