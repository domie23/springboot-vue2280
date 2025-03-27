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
 * 囚犯事迹
 *
 * @author 
 * @email
 */
@TableName("qiufanshiji")
public class QiufanshijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiufanshijiEntity() {

	}

	public QiufanshijiEntity(T t) {
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
     * 囚犯
     */
    @ColumnInfo(comment="囚犯",type="int(11)")
    @TableField(value = "qiufan_id")

    private Integer qiufanId;


    /**
     * 事迹编号
     */
    @ColumnInfo(comment="事迹编号",type="varchar(200)")
    @TableField(value = "qiufanshiji_uuid_number")

    private String qiufanshijiUuidNumber;


    /**
     * 事迹标题
     */
    @ColumnInfo(comment="事迹标题",type="varchar(200)")
    @TableField(value = "qiufanshiji_name")

    private String qiufanshijiName;


    /**
     * 囚犯事迹类型
     */
    @ColumnInfo(comment="囚犯事迹类型",type="int(11)")
    @TableField(value = "qiufanshiji_types")

    private Integer qiufanshijiTypes;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发生时间",type="timestamp")
    @TableField(value = "fasheng_time")

    private Date fashengTime;


    /**
     * 发生地点
     */
    @ColumnInfo(comment="发生地点",type="varchar(200)")
    @TableField(value = "qiufanshiji_address")

    private String qiufanshijiAddress;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "qiufanshiji_file")

    private String qiufanshijiFile;


    /**
     * 事迹描述
     */
    @ColumnInfo(comment="事迹描述",type="text")
    @TableField(value = "qiufanshiji_content")

    private String qiufanshijiContent;


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

    @Override
    public String toString() {
        return "Qiufanshiji{" +
            ", id=" + id +
            ", qiufanId=" + qiufanId +
            ", qiufanshijiUuidNumber=" + qiufanshijiUuidNumber +
            ", qiufanshijiName=" + qiufanshijiName +
            ", qiufanshijiTypes=" + qiufanshijiTypes +
            ", fashengTime=" + DateUtil.convertString(fashengTime,"yyyy-MM-dd") +
            ", qiufanshijiAddress=" + qiufanshijiAddress +
            ", qiufanshijiFile=" + qiufanshijiFile +
            ", qiufanshijiContent=" + qiufanshijiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
