package com.entity;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.utils.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 狱警
 *
 * @author 
 * @email
 */
@TableName("yujing")
public class YujingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YujingEntity() {

	}

	public YujingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 狱警编号
     */
    @ColumnInfo(comment="狱警编号",type="varchar(200)")
    @TableField(value = "yujing_uuid_number")

    private String yujingUuidNumber;


    /**
     * 狱警姓名
     */
    @ColumnInfo(comment="狱警姓名",type="varchar(200)")
    @TableField(value = "yujing_name")

    private String yujingName;


    /**
     * 狱警手机号
     */
    @ColumnInfo(comment="狱警手机号",type="varchar(200)")
    @TableField(value = "yujing_phone")

    private String yujingPhone;


    /**
     * 狱警身份证号
     */
    @ColumnInfo(comment="狱警身份证号",type="varchar(200)")
    @TableField(value = "yujing_id_number")

    private String yujingIdNumber;


    /**
     * 狱警头像
     */
    @ColumnInfo(comment="狱警头像",type="varchar(200)")
    @TableField(value = "yujing_photo")

    private String yujingPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "yujing_email")

    private String yujingEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yujing{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yujingUuidNumber=" + yujingUuidNumber +
            ", yujingName=" + yujingName +
            ", yujingPhone=" + yujingPhone +
            ", yujingIdNumber=" + yujingIdNumber +
            ", yujingPhoto=" + yujingPhoto +
            ", sexTypes=" + sexTypes +
            ", yujingEmail=" + yujingEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
