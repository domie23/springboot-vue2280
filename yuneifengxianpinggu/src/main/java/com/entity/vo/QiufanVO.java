package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 囚犯
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiufan")
public class QiufanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 囚犯编号
     */

    @TableField(value = "qiufan_uuid_number")
    private String qiufanUuidNumber;


    /**
     * 囚犯姓名
     */

    @TableField(value = "qiufan_name")
    private String qiufanName;


    /**
     * 囚犯身份证号
     */

    @TableField(value = "qiufan_id_number")
    private String qiufanIdNumber;


    /**
     * 囚犯照片
     */

    @TableField(value = "qiufan_photo")
    private String qiufanPhoto;


    /**
     * 囚犯年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 入狱时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruyu_time")
    private Date ruyuTime;


    /**
     * 判刑年限
     */

    @TableField(value = "qiufan_nianxian")
    private String qiufanNianxian;


    /**
     * 囚犯介绍
     */

    @TableField(value = "qiufan_content")
    private String qiufanContent;


    /**
     * 犯罪事由
     */

    @TableField(value = "fanzuishiyou_content")
    private String fanzuishiyouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：囚犯编号
	 */
    public String getQiufanUuidNumber() {
        return qiufanUuidNumber;
    }


    /**
	 * 获取：囚犯编号
	 */

    public void setQiufanUuidNumber(String qiufanUuidNumber) {
        this.qiufanUuidNumber = qiufanUuidNumber;
    }
    /**
	 * 设置：囚犯姓名
	 */
    public String getQiufanName() {
        return qiufanName;
    }


    /**
	 * 获取：囚犯姓名
	 */

    public void setQiufanName(String qiufanName) {
        this.qiufanName = qiufanName;
    }
    /**
	 * 设置：囚犯身份证号
	 */
    public String getQiufanIdNumber() {
        return qiufanIdNumber;
    }


    /**
	 * 获取：囚犯身份证号
	 */

    public void setQiufanIdNumber(String qiufanIdNumber) {
        this.qiufanIdNumber = qiufanIdNumber;
    }
    /**
	 * 设置：囚犯照片
	 */
    public String getQiufanPhoto() {
        return qiufanPhoto;
    }


    /**
	 * 获取：囚犯照片
	 */

    public void setQiufanPhoto(String qiufanPhoto) {
        this.qiufanPhoto = qiufanPhoto;
    }
    /**
	 * 设置：囚犯年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：囚犯年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：入狱时间
	 */
    public Date getRuyuTime() {
        return ruyuTime;
    }


    /**
	 * 获取：入狱时间
	 */

    public void setRuyuTime(Date ruyuTime) {
        this.ruyuTime = ruyuTime;
    }
    /**
	 * 设置：判刑年限
	 */
    public String getQiufanNianxian() {
        return qiufanNianxian;
    }


    /**
	 * 获取：判刑年限
	 */

    public void setQiufanNianxian(String qiufanNianxian) {
        this.qiufanNianxian = qiufanNianxian;
    }
    /**
	 * 设置：囚犯介绍
	 */
    public String getQiufanContent() {
        return qiufanContent;
    }


    /**
	 * 获取：囚犯介绍
	 */

    public void setQiufanContent(String qiufanContent) {
        this.qiufanContent = qiufanContent;
    }
    /**
	 * 设置：犯罪事由
	 */
    public String getFanzuishiyouContent() {
        return fanzuishiyouContent;
    }


    /**
	 * 获取：犯罪事由
	 */

    public void setFanzuishiyouContent(String fanzuishiyouContent) {
        this.fanzuishiyouContent = fanzuishiyouContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
