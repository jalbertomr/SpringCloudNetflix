package com.bext.model;

public class Info {
	static String port;
	static String ServiceInstance_Uri;

	public static String getServiceInstance_Uri() {
		return ServiceInstance_Uri;
	}

	public static void setServiceInstance_Uri(String serviceInstance_Uri) {
		ServiceInstance_Uri = serviceInstance_Uri;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		Info.port = port;
	}
}
