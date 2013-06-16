#!/bin/sh
# Shows the server version
export ASTIVE_HOME="$PWD"
java -Duser.country=US -Duser.language=en -classpath $ASTIVE_HOME/lib/commons-1* org.astivetoolkit.Version
