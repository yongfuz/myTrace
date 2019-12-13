package com.pactera.bg.budsc.bank.yongfu.po;

public class UserFriend {
    private String hostId;

    private String friendId;

    private String createTime;

    private String isDeleted;

    private String whoDeleted;

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId == null ? null : hostId.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getWhoDeleted() {
        return whoDeleted;
    }

    public void setWhoDeleted(String whoDeleted) {
        this.whoDeleted = whoDeleted == null ? null : whoDeleted.trim();
    }
}