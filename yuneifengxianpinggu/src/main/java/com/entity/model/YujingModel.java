package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 狱警
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YujingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 狱警编号
     */
    private String yujingUuidNumber;


    /**
     * 狱警姓名
     */
    private String yujingName;


    /**
     * 狱警手机号
     */
    private String yujingPhone;


    /**
     * 狱警身份证号
     */
    private String yujingIdNumber;


    /**
     * 狱警头像
     */
    private String yujingPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String yujingEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：狱警编号
	 */
    public String getYujingUuidNumber() {
        return yujingUuidNumber;
    }


    /**
	 * 设置：狱警编号
	 */
    public void setYujingUuidNumber(String yujingUuidNumber) {
        this.yujingUuidNumber = yujingUuidNumber;
    }
    /**
	 * 获取：狱警姓名
	 */
    public String getYujingName() {
        return yujingName;
    }


    /**
	 * 设置：狱警姓名
	 */
    public void setYujingName(String yujingName) {
        this.yujingName = yujingName;
    }
    /**
	 * 获取：狱警手机号
	 */
    public String getYujingPhone() {
        return yujingPhone;
    }


    /**
	 * 设置：狱警手机号
	 */
    public void setYujingPhone(String yujingPhone) {
        this.yujingPhone = yujingPhone;
    }
    /**
	 * 获取：狱警身份证号
	 */
    public String getYujingIdNumber() {
        return yujingIdNumber;
    }


    /**
	 * 设置：狱警身份证号
	 */
    public void setYujingIdNumber(String yujingIdNumber) {
        this.yujingIdNumber = yujingIdNumber;
    }
    /**
	 * 获取：狱警头像
	 */
    public String getYujingPhoto() {
        return yujingPhoto;
    }


    /**
	 * 设置：狱警头像
	 */
    public void setYujingPhoto(String yujingPhoto) {
        this.yujingPhoto = yujingPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getYujingEmail() {
        return yujingEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setYujingEmail(String yujingEmail) {
        this.yujingEmail = yujingEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
