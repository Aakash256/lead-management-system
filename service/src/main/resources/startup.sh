#!/bin/bash
sudo java -jar service-1.0.0.jar &
sudo echo $! > pid.file