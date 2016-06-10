#!/bin/bash

# OpenUp Ltda. - Uruguay
# @author Raúl Capecce
# @param $1 Adempiere dir install
# @param $2 Current Java to set envirnment


echo "Setting permissions to *.sh files ..."
chmod +x $1/*.sh
chmod +x $1/utils/*.sh
echo "done."
echo ""

echo "Setting environment variables ..."

#   Setting ADEMPIERE_HOME
if grep -c "export *ADEMPIERE_HOME" /etc/profile
then
   #ADEMPIERE_HOME is defined
   echo "ADEMPIERE_HOME already setted"
else
   #ADEMPIERE_HOME is not defined
   #Adding ADEMPIERE_HOME
   echo "export ADEMPIERE_HOME=$1" >> /etc/profile
fi

#   Setting JAVA_HOME   
if grep -c "export *JAVA_HOME" /etc/profile
then
   #JAVA_HOME is defined
   echo "JAVA_HOME already setted"
else
   #JAVA_HOME is not defined
   #Adding JAVA_HOME
   echo "export JAVA_HOME=$2" >> /etc/profile
fi

source /etc/profile

echo "done."

echo "Deleting tmp files..."
rm -rf $1/AdempiereAfterInstall.bat
echo "done."

echo ""


sleep 1

exit 0

