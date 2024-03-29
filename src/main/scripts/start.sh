#!/bin/bash
SERVER_NAME='zhang-yong-fu'
# jar名称
JAR_NAME='zhang-yong-fu.jar'
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/config
LIB_DIR=$DEPLOY_DIR/lib

# 获取应用的端口号
SERVER_PORT=`sed '/server.port/!d;s/.*=//' ./application.properties | tr -d '\r'`

PIDS=`ps -f | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ "$1" = "status" ]; then  
  if [ -n "$PIDS" ]; then
    echo "The $SERVER_NAME is running...!"
    echo "PID: $PIDS"
    exit 0
  else
    echo "The $SERVER_NAME is stopped"
    exit 0
  fi
fi
if [ -n "$PIDS" ]; then
  echo "ERROR: The $SERVER_NAME already started!"
  echo "PID: $PIDS"
  exit 1
fi
if [ -n "$SERVER_PORT" ]; then
  SERVER_PORT_COUNT=`netstat -tln | grep $SERVER_PORT | wc -l`
  if [ $SERVER_PORT_COUNT -gt 0 ]; then
    echo "ERROR: The $SERVER_NAME port $SERVER_PORT already used!"
    exit 1
  fi
fi
LOGS_DIR=$DEPLOY_DIR/logs
if [ ! -d $LOGS_DIR ]; then
  mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log
JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
  JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi

JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
  JAVA_MEM_OPTS=" -server -Xmx64m -Xms64m -Xmn64m  -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
  JAVA_MEM_OPTS=" -server -Xmx64m -Xms64m -Xmn64m -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi
CONFIG_FILES=" -Dlogging.path=$LOGS_DIR -Dlogging.config=$CONF_DIR/logback.xml -Dspring.config.location=$CONF_DIR/application.properties,$CONF_DIR/config.properties "
echo -e "Starting the $SERVER_NAME ..."
nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS -Dloader.path=$LIB_DIR,$CONF_DIR  -jar $JAR_NAME > $STDOUT_FILE 2>&1 &
COUNT=0
while [ $COUNT -lt 1 ]; do
  echo -e ".\c"
  sleep 1
  if [ -n "$SERVER_PORT" ]; then
    COUNT=`netstat -an | grep $SERVER_PORT | wc -l`
  else
   COUNT=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
  fi
  if [ $COUNT -gt 0 ]; then
    break
  fi
done
echo "OK!"
PIDS=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"
