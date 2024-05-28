package umc.spring.study.apiPayload;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
