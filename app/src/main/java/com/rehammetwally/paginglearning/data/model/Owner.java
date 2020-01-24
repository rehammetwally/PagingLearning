
package com.rehammetwally.paginglearning.data.model;

import com.google.gson.annotations.SerializedName;


public class Owner {

    @SerializedName("display_name")
    private String mDisplayName;
    @SerializedName("link")
    private String mLink;
    @SerializedName("profile_image")
    private String mProfileImage;
    @SerializedName("reputation")
    private Long mReputation;
    @SerializedName("user_id")
    private Long mUserId;
    @SerializedName("user_type")
    private String mUserType;

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(String profileImage) {
        mProfileImage = profileImage;
    }

    public Long getReputation() {
        return mReputation;
    }

    public void setReputation(Long reputation) {
        mReputation = reputation;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }

}
