package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 囚犯事迹
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiufanshiji")
public class QiufanshijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 囚犯
     */

    @TableField(value = "qiufan_id")
    private Integer qiufanId;


    /**
     * 事迹编号
     */

    @TableField(value = "qiufanshiji_uuid_number")
    private String qiufanshijiUuidNumber;


    /**
     * 事迹标题
     */

    @TableField(value = "qiufanshiji_name")
    private String qiufanshijiName;


    /**
     * 囚犯事迹类型
     */

    @TableField(value = "qiufanshiji_types")
    private Integer qiufanshijiTypes;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fasheng_time")
    private Date fashengTime;


    /**
     * 发生地点
     */

    @TableField(value = "qiufanshiji_address")
    private String qiufanshijiAddress;


    /**
     * 附件
     */

    @TableField(value = "qiufanshiji_file")
    private String qiufanshijiFile;


    /**
     * 事迹描述
     */

    @TableField(value = "qiufanshiji_content")
    private String qiufanshijiContent;


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
	 * 设置：囚犯
	 */
    public Integer getQiufanId() {
        return qiufanId;
    }


    /**
	 * 获取：囚犯
	 */

    public void setQiufanId(Integer qiufanId) {
        this.qiufanId = qiufanId;
    }
    /**
	 * 设置：事迹编号
	 */
    public String getQiufanshijiUuidNumber() {
        return qiufanshijiUuidNumber;
    }


    /**
	 * 获取：事迹编号
	 */

    public void setQiufanshijiUuidNumber(String qiufanshijiUuidNumber) {
        this.qiufanshijiUuidNumber = qiufanshijiUuidNumber;
    }
    /**
	 * 设置：事迹标题
	 */
    public String getQiufanshijiName() {
        return qiufanshijiName;
    }


    /**
	 * 获取：事迹标题
	 */

    public void setQiufanshijiName(String qiufanshijiName) {
        this.qiufanshijiName = qiufanshijiName;
    }
    /**
	 * 设置：囚犯事迹类型
	 */
    public Integer getQiufanshijiTypes() {
        return qiufanshijiTypes;
    }


    /**
	 * 获取：囚犯事迹类型
	 */

    public void setQiufanshijiTypes(Integer qiufanshijiTypes) {
        this.qiufanshijiTypes = qiufanshijiTypes;
    }
    /**
	 * 设置：发生时间
	 */
    public Date getFashengTime() {
        return fashengTime;
    }


    /**
	 * 获取：发生时间
	 */

    public void setFashengTime(Date fashengTime) {
        this.fashengTime = fashengTime;
    }
    /**
	 * 设置：发生地点
	 */
    public String getQiufanshijiAddress() {
        return qiufanshijiAddress;
    }


    /**
	 * 获取：发生地点
	 */

    public void setQiufanshijiAddress(String qiufanshijiAddress) {
        this.qiufanshijiAddress = qiufanshijiAddress;
    }
    /**
	 * 设置：附件
	 */
    public String getQiufanshijiFile() {
        return qiufanshijiFile;
    }


    /**
	 * 获取：附件
	 */

    public void setQiufanshijiFile(String qiufanshijiFile) {
        this.qiufanshijiFile = qiufanshijiFile;
    }
    /**
	 * 设置：事迹描述
	 */
    public String getQiufanshijiContent() {
        return qiufanshijiContent;
    }


    /**
	 * 获取：事迹描述
	 */

    public void setQiufanshijiContent(String qiufanshijiContent) {
        this.qiufanshijiContent = qiufanshijiContent;
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
