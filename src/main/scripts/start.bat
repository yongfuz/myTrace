@echo off & setlocal enabledelayedexpansion
cd ..
java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -Dloader.path="config/" -jar zhang-yong-fu.jar
goto end

:debug
java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -Dloader.path="lib/,config/" -jar zhang-yong-fu.jar 
goto end

:jmx
java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dloader.path="lib/,config/" -jar zhang-yong-fu.jar 

:end
pause