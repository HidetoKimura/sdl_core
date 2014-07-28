package com.ford.syncV4.service.secure;

/**
 * Created with Android Studio.
 * Author: Chernyshov Yuriy - Mobile Development
 * Date: 3/5/14
 * Time: 12:44 PM
 */

/**
 * Response codes for the Secure Service enabling request
 */
public enum SecurityInternalError {

    ERROR_SUCCESS  ,                 // = 0x00,
    ERROR_INVALID_QUERY_SIZE ,       // = 0x01,  // wrong size of query data
    ERROR_INVALID_QUERY_ID,           //= 0x02,  // unknown query id
    ERROR_NOT_SUPPORTED ,             //= 0x03,  // SDL does not support encryption
    ERROR_SERVICE_ALREADY_PROTECTED , //= 0x04,
    ERROR_SERVICE_NOT_PROTECTED ,     //= 0x05,  // got handshake or encrypted data
    // for not protected service
    ERROR_DECRYPTION_FAILED,         // = 0x06,
    ERROR_ENCRYPTION_FAILED  ,       // = 0x07,
    ERROR_SSL_INVALID_DATA  ,        // = 0x08,
    ERROR_INTERNAL   ,               // = 0xFF,
    ERROR_UNKWOWN_INTERNAL_ERROR ,   // = 0xFE  // error valeu for testing
    UNKNOWN;

    public static int getErrorCode(SecurityInternalError securityInternalError) {
        switch (securityInternalError) {
            case ERROR_SUCCESS:
                return 0;
            case ERROR_INVALID_QUERY_SIZE:
                return 0x01;
            case ERROR_INVALID_QUERY_ID:
                return 0x02;
            case ERROR_NOT_SUPPORTED:
                return 0x03;
            case ERROR_SERVICE_ALREADY_PROTECTED:
                return 0x04;
            case ERROR_SERVICE_NOT_PROTECTED:
                return 0x05;
            case ERROR_DECRYPTION_FAILED:
                return 0x06;
            case ERROR_ENCRYPTION_FAILED:
                return 0x07;
            case ERROR_SSL_INVALID_DATA:
                return 0x08;
            case ERROR_INTERNAL:
                return 0xFF;
            case ERROR_UNKWOWN_INTERNAL_ERROR:
                return 0xFE;
            case UNKNOWN:
                return -1;
            default:
                return -1;
        }
    }

    public static SecurityInternalError getError(int errorCode) {
        switch (errorCode) {
            case 0:
                return ERROR_SUCCESS;
            case 0x01:
                return ERROR_INVALID_QUERY_SIZE;
            case 0x02:
                return ERROR_INVALID_QUERY_ID;
            case 0x03:
                return ERROR_NOT_SUPPORTED;
            case 0x04:
                return ERROR_SERVICE_ALREADY_PROTECTED;
            case 0x05:
                return ERROR_SERVICE_NOT_PROTECTED;
            case 0x06:
                return ERROR_DECRYPTION_FAILED;
            case 0x07:
                return ERROR_ENCRYPTION_FAILED;
            case 0x08:
                return ERROR_SSL_INVALID_DATA;
            case 0xFF:
                return ERROR_INTERNAL;
            case 0xFE:
                return ERROR_UNKWOWN_INTERNAL_ERROR;
            case -1:
                return UNKNOWN;
            default:
                return UNKNOWN;
        }
    }
}