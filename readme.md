## Synopsis

This project is responsible for generating the Adempiere Universal Installer.
In order to be multi platform the installer will be a jar file.

## Requirements

To run this installer generator you must to install izpack  (> v.5) from http://izpack.org/downloads/

## Code Example

Put the Adempiere installer files into the "program/Adempiere" directory to make the package.

Run:
/usr/local/IzPack/bin/compile izpack_installer_definition.xml -o adempiere_installer.jar


_______________________________________


## Sinopsis

Este proyecto es responsable de generar el Instalador Universal de Adempiere
Para que sea multiplataforma, el instalador será un archivo jar.

## Requerimientos

Para correr el generador del instalador, será necesario instalar izpack (> v.5) desde http://izpack.org/downloads/

## Ejemplo de código

Dejar los archivos para instalación de Adempiere en el directorio "program/Adempiere" para realizar el empaquetado.

Ejecutar:
/usr/local/IzPack/bin/compile definicion_instalador_izpack.xml -o instalador_adempiere.jar


