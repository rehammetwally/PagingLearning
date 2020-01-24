
package com.rehammetwally.paginglearning.data.model;

import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("answer_id")
    private Long mAnswerId;
    @SerializedName("creation_date")
    private Long mCreationDate;
    @SerializedName("is_accepted")
    private Boolean mIsAccepted;
    @SerializedName("last_activity_date")
    private Long mLastActivityDate;
    @SerializedName("last_edit_date")
    private Long mLastEditDate;
    @SerializedName("owner")
    private Owner mOwner;
    @SerializedName("question_id")
    private Long mQuestionId;
    @SerializedName("score")
    private Long mScore;

    public Long getAnswerId() {
        return mAnswerId;
    }

    public void setAnswerId(Long answerId) {
        mAnswerId = answerId;
    }

    public Long getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(Long creationDate) {
        mCreationDate = creationDate;
    }

    public Boolean getIsAccepted() {
        return mIsAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        mIsAccepted = isAccepted;
    }

    public Long getLastActivityDate() {
        return mLastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        mLastActivityDate = lastActivityDate;
    }

    public Long getLastEditDate() {
        return mLastEditDate;
    }

    public void setLastEditDate(Long lastEditDate) {
        mLastEditDate = lastEditDate;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public Long getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(Long questionId) {
        mQuestionId = questionId;
    }

    public Long getScore() {
        return mScore;
    }

    public void setScore(Long score) {
        mScore = score;
    }

}
