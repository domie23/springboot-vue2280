package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 囚犯
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiufanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 囚犯编号
     */
    private String qiufanUuidNumber;


    /**
     * 囚犯姓名
     */
    private String qiufanName;


    /**
     * 囚犯身份证号
     */
    private String qiufanIdNumber;


    /**
     * 囚犯照片
     */
    private String qiufanPhoto;


    /**
     * 囚犯年龄
     */
    private Integer age;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 入狱时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruyuTime;


    /**
     * 判刑年限
     */
    private String qiufanNianxian;


    /**
     * 囚犯介绍
     */
    private String qiufanContent;


    /**
     * 犯罪事由
     */
    private String fanzuishiyouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
