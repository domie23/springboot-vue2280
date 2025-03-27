package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 囚犯事迹
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiufanshijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 囚犯
     */
    private Integer qiufanId;


    /**
     * 事迹编号
     */
    private String qiufanshijiUuidNumber;


    /**
     * 事迹标题
     */
    private String qiufanshijiName;


    /**
     * 囚犯事迹类型
     */
    private Integer qiufanshijiTypes;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fashengTime;


    /**
     * 发生地点
     */
    private String qiufanshijiAddress;


    /**
     * 附件
     */
    private String qiufanshijiFile;


    /**
     * 事迹描述
     */
    private String qiufanshijiContent;


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
	 * 获取：囚犯
	 */
    public Integer getQiufanId() {
        return qiufanId;
    }


    /**
	 * 设置：囚犯
	 */
    public void setQiufanId(Integer qiufanId) {
        this.qiufanId = qiufanId;
    }
    /**
	 * 获取：事迹编号
	 */
    public String getQiufanshijiUuidNumber() {
        return qiufanshijiUuidNumber;
    }


    /**
	 * 设置：事迹编号
	 */
    public void setQiufanshijiUuidNumber(String qiufanshijiUuidNumber) {
        this.qiufanshijiUuidNumber = qiufanshijiUuidNumber;
    }
    /**
	 * 获取：事迹标题
	 */
    public String getQiufanshijiName() {
        return qiufanshijiName;
    }


    /**
	 * 设置：事迹标题
	 */
    public void setQiufanshijiName(String qiufanshijiName) {
        this.qiufanshijiName = qiufanshijiName;
    }
    /**
	 * 获取：囚犯事迹类型
	 */
    public Integer getQiufanshijiTypes() {
        return qiufanshijiTypes;
    }


    /**
	 * 设置：囚犯事迹类型
	 */
    public void setQiufanshijiTypes(Integer qiufanshijiTypes) {
        this.qiufanshijiTypes = qiufanshijiTypes;
    }
    /**
	 * 获取：发生时间
	 */
    public Date getFashengTime() {
        return fashengTime;
    }


    /**
	 * 设置：发生时间
	 */
    public void setFashengTime(Date fashengTime) {
        this.fashengTime = fashengTime;
    }
    /**
	 * 获取：发生地点
	 */
    public String getQiufanshijiAddress() {
        return qiufanshijiAddress;
    }


    /**
	 * 设置：发生地点
	 */
    public void setQiufanshijiAddress(String qiufanshijiAddress) {
        this.qiufanshijiAddress = qiufanshijiAddress;
    }
    /**
	 * 获取：附件
	 */
    public String getQiufanshijiFile() {
        return qiufanshijiFile;
    }


    /**
	 * 设置：附件
	 */
    public void setQiufanshijiFile(String qiufanshijiFile) {
        this.qiufanshijiFile = qiufanshijiFile;
    }
    /**
	 * 获取：事迹描述
	 */
    public String getQiufanshijiContent() {
        return qiufanshijiContent;
    }


    /**
	 * 设置：事迹描述
	 */
    public void setQiufanshijiContent(String qiufanshijiContent) {
        this.qiufanshijiContent = qiufanshijiContent;
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
