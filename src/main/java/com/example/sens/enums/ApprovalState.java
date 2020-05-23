package com.example.sens.enums;

/**
 * 审批状态
 * @author 言曌
 */

public enum ApprovalState {

    /**
     * 待审批
     */
    NOT_APPROVAL(0),

    /**
     * 第一次审批通过
     */
    FIRST_FINISH(1),

    /**
     * 第二次审批通过
     */
    SECOND_FINISH(2),

    /**
     * 驳回
     */
    REFUSE(-1)


    ;



    private Integer value;

    ApprovalState(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
