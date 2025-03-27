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
 * 囚犯
 *
 * @author 
 * @email
 */
@TableName("qiufan")
public class QiufanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiufanEntity() {

	}

	public QiufanEntity(T t) {
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
     * 囚犯编号
     */
    @ColumnInfo(comment="囚犯编号",type="varchar(200)")
    @TableField(value = "qiufan_uuid_number")

    private String qiufanUuidNumber;


    /**
     * 囚犯姓名
     */
    @ColumnInfo(comment="囚犯姓名",type="varchar(200)")
    @TableField(value = "qiufan_name")

    private String qiufanName;


    /**
     * 囚犯身份证号
     */
    @ColumnInfo(comment="囚犯身份证号",type="varchar(200)")
    @TableField(value = "qiufan_id_number")

    private String qiufanIdNumber;


    /**
     * 囚犯照片
     */
    @ColumnInfo(comment="囚犯照片",type="varchar(200)")
    @TableField(value = "qiufan_photo")

    private String qiufanPhoto;


    /**
     * 囚犯年龄
     */
    @ColumnInfo(comment="囚犯年龄",type="int(11)")
    @TableField(value = "age")

    private Integer age;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 入狱时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入狱时间",type="timestamp")
    @TableField(value = "ruyu_time")

    private Date ruyuTime;


    /**
     * 判刑年限
     */
    @ColumnInfo(comment="判刑年限",type="varchar(200)")
    @TableField(value = "qiufan_nianxian")

    private String qiufanNianxian;


    /**
     * 囚犯介绍
     */
    @ColumnInfo(comment="囚犯介绍",type="text")
    @TableField(value = "qiufan_content")

    private String qiufanContent;


    /**
     * 犯罪事由
     */
    @ColumnInfo(comment="犯罪事由",type="text")
    @TableField(value = "fanzuishiyou_content")

    private String fanzuishiyouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：囚犯编号
	 */
    public String getQiufanUuidNumber() {
        return qiufanUuidNumber;
    }
    /**
	 * 设置：囚犯编号
	 */

    public void setQiufanUuidNumber(String qiufanUuidNumber) {
        this.qiufanUuidNumber = qiufanUuidNumber;
    }
    /**
	 * 获取：囚犯姓名
	 */
    public String getQiufanName() {
        return qiufanName;
    }
    /**
	 * 设置：囚犯姓名
	 */

    public void setQiufanName(String qiufanName) {
        this.qiufanName = qiufanName;
    }
    /**
	 * 获取：囚犯身份证号
	 */
    public String getQiufanIdNumber() {
        return qiufanIdNumber;
    }
    /**
	 * 设置：囚犯身份证号
	 */

    public void setQiufanIdNumber(String qiufanIdNumber) {
        this.qiufanIdNumber = qiufanIdNumber;
    }
    /**
	 * 获取：囚犯照片
	 */
    public String getQiufanPhoto() {
        return qiufanPhoto;
    }
    /**
	 * 设置：囚犯照片
	 */

    public void setQiufanPhoto(String qiufanPhoto) {
        this.qiufanPhoto = qiufanPhoto;
    }
    /**
	 * 获取：囚犯年龄
	 */
    public Integer getAge() {
        return age;
    }
    /**
	 * 设置：囚犯年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
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
	 * 获取：入狱时间
	 */
    public Date getRuyuTime() {
        return ruyuTime;
    }
    /**
	 * 设置：入狱时间
	 */

    public void setRuyuTime(Date ruyuTime) {
        this.ruyuTime = ruyuTime;
    }
    /**
	 * 获取：判刑年限
	 */
    public String getQiufanNianxian() {
        return qiufanNianxian;
    }
    /**
	 * 设置：判刑年限
	 */

    public void setQiufanNianxian(String qiufanNianxian) {
        this.qiufanNianxian = qiufanNianxian;
    }
    /**
	 * 获取：囚犯介绍
	 */
    public String getQiufanContent() {
        return qiufanContent;
    }
    /**
	 * 设置：囚犯介绍
	 */

    public void setQiufanContent(String qiufanContent) {
        this.qiufanContent = qiufanContent;
    }
    /**
	 * 获取：犯罪事由
	 */
    public String getFanzuishiyouContent() {
        return fanzuishiyouContent;
    }
    /**
	 * 设置：犯罪事由
	 */

    public void setFanzuishiyouContent(String fanzuishiyouContent) {
        this.fanzuishiyouContent = fanzuishiyouContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Qiufan{" +
            ", id=" + id +
            ", qiufanUuidNumber=" + qiufanUuidNumber +
            ", qiufanName=" + qiufanName +
            ", qiufanIdNumber=" + qiufanIdNumber +
            ", qiufanPhoto=" + qiufanPhoto +
            ", age=" + age +
            ", sexTypes=" + sexTypes +
            ", ruyuTime=" + DateUtil.convertString(ruyuTime,"yyyy-MM-dd") +
            ", qiufanNianxian=" + qiufanNianxian +
            ", qiufanContent=" + qiufanContent +
            ", fanzuishiyouContent=" + fanzuishiyouContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
