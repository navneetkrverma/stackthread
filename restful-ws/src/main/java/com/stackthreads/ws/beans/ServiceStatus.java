package com.stackthreads.ws.beans;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class ServiceStatus {

	public boolean isServiceUp() {
		return true;
	}

	public String getServiceName() {
		return "RestfulApp";
	}

	public String getFqdn() {
		String hostname = "Undefined";
		try {
			hostname = Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		;
		return hostname;
	}

	public int getInstances() {
		return 1;
	}
	public int getStatus() {
		return 200;
	}

	@Override
	public String toString() {
		return "ServiceStatus [isServiceUp=" + isServiceUp() + ", serviceName=" + getServiceName() + ", fqdn="
				+ getFqdn() + ", instances=" + getInstances() + ", status"+getStatus()+"]";
	}

}
