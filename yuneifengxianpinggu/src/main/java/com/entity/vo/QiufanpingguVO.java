package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 囚犯评估
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiufanpinggu")
public class QiufanpingguVO implements Serializable {
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
     * 囚犯评估编号
     */

    @TableField(value = "qiufanpinggu_uuid_number")
    private String qiufanpingguUuidNumber;


    /**
     * 评估标题
     */

    @TableField(value = "qiufanpinggu_name")
    private String qiufanpingguName;


    /**
     * 存在逃脱
     */

    @TableField(value = "taotuo_types")
    private Integer taotuoTypes;


    /**
     * 暴力倾向
     */

    @TableField(value = "baoli_types")
    private Integer baoliTypes;


    /**
     * 违禁物品
     */

    @TableField(value = "weijin_types")
    private Integer weijinTypes;


    /**
     * 重大变故
     */

    @TableField(value = "biangu_types")
    private Integer bianguTypes;


    /**
     * 改造中的重大挫折
     */

    @TableField(value = "cuozhe_types")
    private Integer cuozheTypes;


    /**
     * 得分
     */

    @TableField(value = "defen")
    private Integer defen;


    /**
     * 评价结果
     */

    @TableField(value = "jieguo_types")
    private Integer jieguoTypes;


    /**
     * 备注
     */

    @TableField(value = "qiufanpinggu_content")
    private String qiufanpingguContent;


    /**
     * 评估时间
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
	 * 设置：囚犯评估编号
	 */
    public String getQiufanpingguUuidNumber() {
        return qiufanpingguUuidNumber;
    }


    /**
	 * 获取：囚犯评估编号
	 */

    public void setQiufanpingguUuidNumber(String qiufanpingguUuidNumber) {
        this.qiufanpingguUuidNumber = qiufanpingguUuidNumber;
    }
    /**
	 * 设置：评估标题
	 */
    public String getQiufanpingguName() {
        return qiufanpingguName;
    }


    /**
	 * 获取：评估标题
	 */

    public void setQiufanpingguName(String qiufanpingguName) {
        this.qiufanpingguName = qiufanpingguName;
    }
    /**
	 * 设置：存在逃脱
	 */
    public Integer getTaotuoTypes() {
        return taotuoTypes;
    }


    /**
	 * 获取：存在逃脱
	 */

    public void setTaotuoTypes(Integer taotuoTypes) {
        this.taotuoTypes = taotuoTypes;
    }
    /**
	 * 设置：暴力倾向
	 */
    public Integer getBaoliTypes() {
        return baoliTypes;
    }


    /**
	 * 获取：暴力倾向
	 */

    public void setBaoliTypes(Integer baoliTypes) {
        this.baoliTypes = baoliTypes;
    }
    /**
	 * 设置：违禁物品
	 */
    public Integer getWeijinTypes() {
        return weijinTypes;
    }


    /**
	 * 获取：违禁物品
	 */

    public void setWeijinTypes(Integer weijinTypes) {
        this.weijinTypes = weijinTypes;
    }
    /**
	 * 设置：重大变故
	 */
    public Integer getBianguTypes() {
        return bianguTypes;
    }


    /**
	 * 获取：重大变故
	 */

    public void setBianguTypes(Integer bianguTypes) {
        this.bianguTypes = bianguTypes;
    }
    /**
	 * 设置：改造中的重大挫折
	 */
    public Integer getCuozheTypes() {
        return cuozheTypes;
    }


    /**
	 * 获取：改造中的重大挫折
	 */

    public void setCuozheTypes(Integer cuozheTypes) {
        this.cuozheTypes = cuozheTypes;
    }
    /**
	 * 设置：得分
	 */
    public Integer getDefen() {
        return defen;
    }


    /**
	 * 获取：得分
	 */

    public void setDefen(Integer defen) {
        this.defen = defen;
    }
    /**
	 * 设置：评价结果
	 */
    public Integer getJieguoTypes() {
        return jieguoTypes;
    }


    /**
	 * 获取：评价结果
	 */

    public void setJieguoTypes(Integer jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getQiufanpingguContent() {
        return qiufanpingguContent;
    }


    /**
	 * 获取：备注
	 */

    public void setQiufanpingguContent(String qiufanpingguContent) {
        this.qiufanpingguContent = qiufanpingguContent;
    }
    /**
	 * 设置：评估时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：评估时间
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
