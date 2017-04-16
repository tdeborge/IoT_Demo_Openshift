#!/bin/bash

export deviceType="Temperature"
export deviceID="4711"
export initialValue="20"
export count="50"
export waitTime="1"
export receiverURL="broker-amq-mqtt-smartgateway.rhel-cdk.10.1.2.2.xip.io"
export receiverURLPort="30883"
export brokerUID="admin"
export brokerPassword="change12_me"

echo "Starting the producer to send messages "
java -DbrokerUID=$brokerUID -DbrokerPassword=$brokerPassword -DreceiverURL=$receiverURL -DreceiverURLPort=$receiverURLPort -DdeviceType=$deviceType -DdeviceID=$deviceID -DinitialValue=$initialValue -Dcount=$count -DwaitTime=$waitTime -jar Software_Sensor/target/softwareSensor-jar-with-dependencies.jar
