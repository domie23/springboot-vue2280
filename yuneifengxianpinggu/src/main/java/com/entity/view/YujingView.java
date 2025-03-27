package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.YujingEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
* 狱警
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yujing")
public class YujingView extends YujingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;




	public YujingView() {

	}

	public YujingView(YujingEntity yujingEntity) {
		try {
			BeanUtils.copyProperties(this, yujingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}




	@Override
	public String toString() {
		return "YujingView{" +
			", sexValue=" + sexValue +
			"} " + super.toString();
	}
}
