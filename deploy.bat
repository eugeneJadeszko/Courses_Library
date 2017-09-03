REM Your Tomcat directory:
set tomcat=c:\apache-tomcat-9.0.0.M22

XCOPY /Y bin\* WebContent\WEB-INF\classes\ /e

cd WebContent
jar cvf library.war .

RMDIR /s/q %tomcat%\webapps\library

MOVE /Y library.war %tomcat%\webapps\
cd /d %tomcat%\bin
startup.bat
