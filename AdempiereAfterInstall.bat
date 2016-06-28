@echo off

rem OpenUp Ltda. - Uruguay
rem @author Raúl Capecce
rem @param %1 Adempiere installation folder
rem @param %2 Current Java to set envirnment


echo Setting environment variables ...

echo Setting ADEMPIERE_HOME

SET ADEMPIERE_HOME=%~1
SET ADEMPIERE_HOME="\"%ADEMPIERE_HOME%\""
rem SET ADEMPIERE_HOME=%ADEMPIERE_HOME:\=\\%
setx /M ADEMPIERE_HOME %ADEMPIERE_HOME%
echo OpenUp adempiere_home %ADEMPIERE_HOME%

echo Setting JAVA_HOME

SET JAVA_HOME=%~2
SET JAVA_HOME=%JAVA_HOME:\=\\%
setx /M JAVA_HOME "%JAVA_HOME%"
echo OpenUp java_home "%JAVA_HOME%"



echo RUN_silentsetup.sh

cd %1

RUN_silentsetup.bat
cd utils
RUN_ImportAdempiere.bat


echo done.
del %1\AdempiereAfterInstall.sh
start /b "" cmd /c del "%~f0"&exit /b
