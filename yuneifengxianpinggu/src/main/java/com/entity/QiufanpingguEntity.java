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
 * 囚犯评估
 *
 * @author 
 * @email
 */
@TableName("qiufanpinggu")
public class QiufanpingguEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiufanpingguEntity() {

	}

	public QiufanpingguEntity(T t) {
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
     * 囚犯评估编号
     */
    @ColumnInfo(comment="囚犯评估编号",type="varchar(200)")
    @TableField(value = "qiufanpinggu_uuid_number")

    private String qiufanpingguUuidNumber;


    /**
     * 评估标题
     */
    @ColumnInfo(comment="评估标题",type="varchar(200)")
    @TableField(value = "qiufanpinggu_name")

    private String qiufanpingguName;


    /**
     * 存在逃脱
     */
    @ColumnInfo(comment="存在逃脱",type="int(11)")
    @TableField(value = "taotuo_types")

    private Integer taotuoTypes;


    /**
     * 暴力倾向
     */
    @ColumnInfo(comment="暴力倾向",type="int(11)")
    @TableField(value = "baoli_types")

    private Integer baoliTypes;


    /**
     * 违禁物品
     */
    @ColumnInfo(comment="违禁物品",type="int(11)")
    @TableField(value = "weijin_types")

    private Integer weijinTypes;


    /**
     * 重大变故
     */
    @ColumnInfo(comment="重大变故",type="int(11)")
    @TableField(value = "biangu_types")

    private Integer bianguTypes;


    /**
     * 改造中的重大挫折
     */
    @ColumnInfo(comment="改造中的重大挫折",type="int(11)")
    @TableField(value = "cuozhe_types")

    private Integer cuozheTypes;


    /**
     * 得分
     */
    @ColumnInfo(comment="得分",type="int(11)")
    @TableField(value = "defen")

    private Integer defen;


    /**
     * 评价结果
     */
    @ColumnInfo(comment="评价结果",type="int(11)")
    @TableField(value = "jieguo_types")

    private Integer jieguoTypes;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "qiufanpinggu_content")

    private String qiufanpingguContent;


    /**
     * 评估时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="评估时间",type="timestamp")
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
	 * 获取：囚犯评估编号
	 */
    public String getQiufanpingguUuidNumber() {
        return qiufanpingguUuidNumber;
    }
    /**
	 * 设置：囚犯评估编号
	 */

    public void setQiufanpingguUuidNumber(String qiufanpingguUuidNumber) {
        this.qiufanpingguUuidNumber = qiufanpingguUuidNumber;
    }
    /**
	 * 获取：评估标题
	 */
    public String getQiufanpingguName() {
        return qiufanpingguName;
    }
    /**
	 * 设置：评估标题
	 */

    public void setQiufanpingguName(String qiufanpingguName) {
        this.qiufanpingguName = qiufanpingguName;
    }
    /**
	 * 获取：存在逃脱
	 */
    public Integer getTaotuoTypes() {
        return taotuoTypes;
    }
    /**
	 * 设置：存在逃脱
	 */

    public void setTaotuoTypes(Integer taotuoTypes) {
        this.taotuoTypes = taotuoTypes;
    }
    /**
	 * 获取：暴力倾向
	 */
    public Integer getBaoliTypes() {
        return baoliTypes;
    }
    /**
	 * 设置：暴力倾向
	 */

    public void setBaoliTypes(Integer baoliTypes) {
        this.baoliTypes = baoliTypes;
    }
    /**
	 * 获取：违禁物品
	 */
    public Integer getWeijinTypes() {
        return weijinTypes;
    }
    /**
	 * 设置：违禁物品
	 */

    public void setWeijinTypes(Integer weijinTypes) {
        this.weijinTypes = weijinTypes;
    }
    /**
	 * 获取：重大变故
	 */
    public Integer getBianguTypes() {
        return bianguTypes;
    }
    /**
	 * 设置：重大变故
	 */

    public void setBianguTypes(Integer bianguTypes) {
        this.bianguTypes = bianguTypes;
    }
    /**
	 * 获取：改造中的重大挫折
	 */
    public Integer getCuozheTypes() {
        return cuozheTypes;
    }
    /**
	 * 设置：改造中的重大挫折
	 */

    public void setCuozheTypes(Integer cuozheTypes) {
        this.cuozheTypes = cuozheTypes;
    }
    /**
	 * 获取：得分
	 */
    public Integer getDefen() {
        return defen;
    }
    /**
	 * 设置：得分
	 */

    public void setDefen(Integer defen) {
        this.defen = defen;
    }
    /**
	 * 获取：评价结果
	 */
    public Integer getJieguoTypes() {
        return jieguoTypes;
    }
    /**
	 * 设置：评价结果
	 */

    public void setJieguoTypes(Integer jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getQiufanpingguContent() {
        return qiufanpingguContent;
    }
    /**
	 * 设置：备注
	 */

    public void setQiufanpingguContent(String qiufanpingguContent) {
        this.qiufanpingguContent = qiufanpingguContent;
    }
    /**
	 * 获取：评估时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：评估时间
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
        return "Qiufanpinggu{" +
            ", id=" + id +
            ", qiufanId=" + qiufanId +
            ", qiufanpingguUuidNumber=" + qiufanpingguUuidNumber +
            ", qiufanpingguName=" + qiufanpingguName +
            ", taotuoTypes=" + taotuoTypes +
            ", baoliTypes=" + baoliTypes +
            ", weijinTypes=" + weijinTypes +
            ", bianguTypes=" + bianguTypes +
            ", cuozheTypes=" + cuozheTypes +
            ", defen=" + defen +
            ", jieguoTypes=" + jieguoTypes +
            ", qiufanpingguContent=" + qiufanpingguContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
