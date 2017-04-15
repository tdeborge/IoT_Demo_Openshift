package com.redhat.demo.iot.gateway.rules_cep;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dataSet")
@XmlType(propOrder = { "timestamp", "deviceType", "deviceID","count", "payload","required","average","errorMessage" ,"errorCode"})
public class Dataset {
	private String	timestamp;
	private String	deviceType;
	private int		deviceID;	
	private	int		payload;
	private int		required;
	private	float	average;
	private String 	errorMessage;
	private int  	errorCode;
	private int 	count;
	
	public Dataset()
	{
		this.timestamp 	= "";
		this.deviceType = "";
		this.deviceID	= 0;
		this.payload	= 0;
		this.required	= 0;
		this.average	= 0;
		this.count		= 0;
	}
	
	public Dataset(String time, String devType, int devID, int pay, int required, float average, int count)
	{
		this.timestamp 	= time;
		this.deviceType = devType;
		this.deviceID	= devID;
		this.payload	= pay;
		this.required	= required;
		this.average	= average;
		this.count		= count;
	}

	public String toCSV() {
		return ( deviceType+", "+deviceID+", "+payload+", "+count);
	}
	
	/**
	 * @return the required
	 */
	public int getRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	@XmlElement
	public void setRequired(int required) {
		this.required = required;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	@XmlElement
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	@XmlElement
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceID
	 */
	public int getDeviceID() {
		return deviceID;
	}

	/**
	 * @param deviceID the deviceID to set
	 */
	@XmlElement
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}

	/**
	 * @return the payload
	 */
	public int getPayload() {
		return payload;
	}

	/**
	 * @param payload the payload to set
	 */
	@XmlElement
	public void setPayload(int payload) {
		this.payload = payload;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@XmlElement
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@XmlElement
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public float getAverage() {
		return average;
	}

	@XmlElement
	public void setAverage(float average) {
		this.average = average;
	}

	public int getCount() {
		return count;
	}

	@XmlElement
	public void setCount(int count) {
		this.count = count;
	}
	
}
	