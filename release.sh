#!/bin/sh
# this is a script for release to maven central
git pull
mvn -DpreparationGoals=compile clean release:prepare release:perform
