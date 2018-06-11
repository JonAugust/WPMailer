#!/bin/sh

JAVAHOME=/usr/
JARHOME=/www/jobcenter/jars
export JAVAHOME
export JARHOME

CLASSPATH=$JARHOME/commons-dbcp2-2.2.0.jar:$JARHOME/commons-io-2.6.jar:$JARHOME/commons-logging-1.2.jar:$JARHOME/commons-pool2-2.5.0.jar:$JARHOME/httpasyncclient-4.0.1.jar:$JARHOME/httpclient-4.5.5.jar:$JARHOME/httpcore-4.4.9.jar:$JARHOME/httpcore-nio-4.3.2.jar:$JARHOME/httpmime-4.5.5.jar:$JARHOME/json-20140107.jar:$JARHOME/mysql-connector-java-5.1.46-bin.jar:$JARHOME/unirest-java-1.4.9.jar:/www/jobcenter/java/WPMailer/out/production/WPMailer/.
export CLASSPATH

$JAVAHOME/bin/java com.washpress.mail.WPMailer