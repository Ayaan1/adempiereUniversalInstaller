@echo off

rem OpenUp Ltda. - Uruguay
rem @author Raúl Capecce
rem @param %1 Adempiere installation folder
rem @param %2 Current Java to set envirnment


echo Setting environment variables ...

echo Prueba Variables
echo ADEMPIERE_HOME %1
echo JAVA_HOME %2


echo Setting ADEMPIERE_HOME

rem set ADEMPIERE_HOME=%1
rem set ADEMPIERE_HOME=%ADEMPIERE_HOME:"=%
rem setx /M ADEMPIERE_HOME %ADEMPIERE_HOME%


echo Setting JAVA_HOME

rem set JAVA_HOME=%2
rem set JAVA_HOME=%JAVA_HOME:"=%
rem setx /M JAVA_HOME %JAVA_HOME%

setx /M ADEMPIERE_HOME %1
setx /M JAVA_HOME %2


echo done.
start /b "" cmd /c del "%~f0"&exit /b
