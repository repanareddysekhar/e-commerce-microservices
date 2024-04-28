package com.repana.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Errors {
    PR_01("Product Not found"),
    CAT_01("Category Not found");

    private String msg;
    private static Map<String, String> errorCodes = new HashMap<>();

    Errors(String errorMSg) {
        this.msg = errorMSg;
    }

    public static Map<String, String> getErroCodes() {
        return errorCodes;
    }

    public void setErrorCodes(Map<String, String> eMsg) {
        Errors.errorCodes = eMsg;
    }

    public static String getCodeByErrorMsg(String code) {
        return Errors.errorCodes.get(code);
    }
}
