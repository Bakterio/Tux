#!/bin/bash
gradle shadowJar
java -Xms1G -jar build/libs/Tux-1.0-all.jar
