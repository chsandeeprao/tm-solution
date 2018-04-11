package com.sandeep.events.vo;

public enum ServiceStatus {

    SUCCESS(200), CREATE_SUCCESS(201), BAD_REQUEST(400), UNAUTHORIZED(401), DUPLICATE_RECORD(409), RECORD_NOT_FOUND(
            404), INTERNAL_SERVER_ERROR(500), SOCKET_TIME_OUT(504), ACCEPTED_NOT_PROCESSED(202);

    private final Integer code;

    ServiceStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static ServiceStatus getServiceStatus(Integer code){
        for (ServiceStatus serviceStatus : values()) {
            if (serviceStatus.getCode().equals(code)) {
                return serviceStatus;
            }
        }
        return ServiceStatus.SUCCESS;
    }
}
