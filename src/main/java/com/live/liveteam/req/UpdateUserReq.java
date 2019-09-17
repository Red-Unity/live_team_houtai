package com.live.liveteam.req;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 作者：木木豹
 * 时间2019-09-05 11:36
 * 描述：修改用户非公开信息vo
 */
@ApiModel("UpdateUserReq(修改用户公开信)")
public class UpdateUserReq {
    /**
     * 市
     */
    @ApiModelProperty(value = "所在城市", required = true)
    private String city;
    /**
     * 省
     */
    @ApiModelProperty(value = "所在省份", required = true)
    private String province;
    /**
     * 国
     */
    @ApiModelProperty(value = "所在国家", required = true)
    private String country;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址URL", required = true)
    private String avatarUrl;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别0-女 1-男", required = true)
    private Byte gender;
    /**
     * 网名
     */
    @ApiModelProperty(value = "网名", required = true)
    private String nickName;
    /**
     * 用户生日时间戳
     */
    @ApiModelProperty(value = "用户生日", required = true)
    private Long userBirthday;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String userIphone;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Long userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserIphone() {
        return userIphone;
    }

    public void setUserIphone(String userIphone) {
        this.userIphone = userIphone;
    }
}
