package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.XuanchuanEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
* 宣传
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanchuan")
public class XuanchuanView extends XuanchuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 宣传类型的值
	*/
	@ColumnInfo(comment="宣传类型的字典表值",type="varchar(200)")
	private String xuanchuanValue;




	public XuanchuanView() {

	}

	public XuanchuanView(XuanchuanEntity xuanchuanEntity) {
		try {
			BeanUtils.copyProperties(this, xuanchuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 宣传类型的值
	*/
	public String getXuanchuanValue() {
		return xuanchuanValue;
	}
	/**
	* 设置： 宣传类型的值
	*/
	public void setXuanchuanValue(String xuanchuanValue) {
		this.xuanchuanValue = xuanchuanValue;
	}




	@Override
	public String toString() {
		return "XuanchuanView{" +
			", xuanchuanValue=" + xuanchuanValue +
			"} " + super.toString();
	}
}
