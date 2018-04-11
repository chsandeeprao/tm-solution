package com.sandeep.events.vo;

public class ServiceErrorVO {

	private String devMessage;
	
	public ServiceErrorVO(){
		
	}
	
	public ServiceErrorVO(String devMessage) {
		this.devMessage = devMessage;
	}

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }
}
