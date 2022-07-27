package com.todo.demo.exception;

public class TaskSkillException extends BaseException{
    private static final long SerialVersionUID=1L;

    public TaskSkillException(String message, int status, Object data, Object[] dynamicData) {
        super(message, status, data, dynamicData);
    }

    public TaskSkillException(String message, int status) {
        super(message, status);
    }

    public TaskSkillException(String message, int status, Object data) {
        super(message, status, data);
    }
}
