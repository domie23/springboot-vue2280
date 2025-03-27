package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.QiufanpingguEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.utils.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
* 囚犯评估
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiufanpinggu")
public class QiufanpingguView extends QiufanpingguEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 存在逃脱的值
	*/
	@ColumnInfo(comment="存在逃脱的字典表值",type="varchar(200)")
	private String taotuoValue;
	/**
	* 暴力倾向的值
	*/
	@ColumnInfo(comment="暴力倾向的字典表值",type="varchar(200)")
	private String baoliValue;
	/**
	* 违禁物品的值
	*/
	@ColumnInfo(comment="违禁物品的字典表值",type="varchar(200)")
	private String weijinValue;
	/**
	* 重大变故的值
	*/
	@ColumnInfo(comment="重大变故的字典表值",type="varchar(200)")
	private String bianguValue;
	/**
	* 改造中的重大挫折的值
	*/
	@ColumnInfo(comment="改造中的重大挫折的字典表值",type="varchar(200)")
	private String cuozheValue;
	/**
	* 评价结果的值
	*/
	@ColumnInfo(comment="评价结果的字典表值",type="varchar(200)")
	private String jieguoValue;

	//级联表 囚犯
		/**
		* 囚犯编号
		*/

		@ColumnInfo(comment="囚犯编号",type="varchar(200)")
		private String qiufanUuidNumber;
		/**
		* 囚犯姓名
		*/

		@ColumnInfo(comment="囚犯姓名",type="varchar(200)")
		private String qiufanName;
		/**
		* 囚犯身份证号
		*/

		@ColumnInfo(comment="囚犯身份证号",type="varchar(200)")
		private String qiufanIdNumber;
		/**
		* 囚犯照片
		*/

		@ColumnInfo(comment="囚犯照片",type="varchar(200)")
		private String qiufanPhoto;
		/**
		* 囚犯年龄
		*/

		@ColumnInfo(comment="囚犯年龄",type="int(11)")
		private Integer age;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;
		/**
		* 入狱时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="入狱时间",type="timestamp")
		private Date ruyuTime;
		/**
		* 判刑年限
		*/

		@ColumnInfo(comment="判刑年限",type="varchar(200)")
		private String qiufanNianxian;
		/**
		* 囚犯介绍
		*/

		@ColumnInfo(comment="囚犯介绍",type="text")
		private String qiufanContent;
		/**
		* 犯罪事由
		*/

		@ColumnInfo(comment="犯罪事由",type="text")
		private String fanzuishiyouContent;



	public QiufanpingguView() {

	}

	public QiufanpingguView(QiufanpingguEntity qiufanpingguEntity) {
		try {
			BeanUtils.copyProperties(this, qiufanpingguEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 存在逃脱的值
	*/
	public String getTaotuoValue() {
		return taotuoValue;
	}
	/**
	* 设置： 存在逃脱的值
	*/
	public void setTaotuoValue(String taotuoValue) {
		this.taotuoValue = taotuoValue;
	}
	//当前表的
	/**
	* 获取： 暴力倾向的值
	*/
	public String getBaoliValue() {
		return baoliValue;
	}
	/**
	* 设置： 暴力倾向的值
	*/
	public void setBaoliValue(String baoliValue) {
		this.baoliValue = baoliValue;
	}
	//当前表的
	/**
	* 获取： 违禁物品的值
	*/
	public String getWeijinValue() {
		return weijinValue;
	}
	/**
	* 设置： 违禁物品的值
	*/
	public void setWeijinValue(String weijinValue) {
		this.weijinValue = weijinValue;
	}
	//当前表的
	/**
	* 获取： 重大变故的值
	*/
	public String getBianguValue() {
		return bianguValue;
	}
	/**
	* 设置： 重大变故的值
	*/
	public void setBianguValue(String bianguValue) {
		this.bianguValue = bianguValue;
	}
	//当前表的
	/**
	* 获取： 改造中的重大挫折的值
	*/
	public String getCuozheValue() {
		return cuozheValue;
	}
	/**
	* 设置： 改造中的重大挫折的值
	*/
	public void setCuozheValue(String cuozheValue) {
		this.cuozheValue = cuozheValue;
	}
	//当前表的
	/**
	* 获取： 评价结果的值
	*/
	public String getJieguoValue() {
		return jieguoValue;
	}
	/**
	* 设置： 评价结果的值
	*/
	public void setJieguoValue(String jieguoValue) {
		this.jieguoValue = jieguoValue;
	}


	//级联表的get和set 囚犯

		/**
		* 获取： 囚犯编号
		*/
		public String getQiufanUuidNumber() {
			return qiufanUuidNumber;
		}
		/**
		* 设置： 囚犯编号
		*/
		public void setQiufanUuidNumber(String qiufanUuidNumber) {
			this.qiufanUuidNumber = qiufanUuidNumber;
		}

		/**
		* 获取： 囚犯姓名
		*/
		public String getQiufanName() {
			return qiufanName;
		}
		/**
		* 设置： 囚犯姓名
		*/
		public void setQiufanName(String qiufanName) {
			this.qiufanName = qiufanName;
		}

		/**
		* 获取： 囚犯身份证号
		*/
		public String getQiufanIdNumber() {
			return qiufanIdNumber;
		}
		/**
		* 设置： 囚犯身份证号
		*/
		public void setQiufanIdNumber(String qiufanIdNumber) {
			this.qiufanIdNumber = qiufanIdNumber;
		}

		/**
		* 获取： 囚犯照片
		*/
		public String getQiufanPhoto() {
			return qiufanPhoto;
		}
		/**
		* 设置： 囚犯照片
		*/
		public void setQiufanPhoto(String qiufanPhoto) {
			this.qiufanPhoto = qiufanPhoto;
		}

		/**
		* 获取： 囚犯年龄
		*/
		public Integer getAge() {
			return age;
		}
		/**
		* 设置： 囚犯年龄
		*/
		public void setAge(Integer age) {
			this.age = age;
		}
		/**
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


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

		/**
		* 获取： 入狱时间
		*/
		public Date getRuyuTime() {
			return ruyuTime;
		}
		/**
		* 设置： 入狱时间
		*/
		public void setRuyuTime(Date ruyuTime) {
			this.ruyuTime = ruyuTime;
		}

		/**
		* 获取： 判刑年限
		*/
		public String getQiufanNianxian() {
			return qiufanNianxian;
		}
		/**
		* 设置： 判刑年限
		*/
		public void setQiufanNianxian(String qiufanNianxian) {
			this.qiufanNianxian = qiufanNianxian;
		}

		/**
		* 获取： 囚犯介绍
		*/
		public String getQiufanContent() {
			return qiufanContent;
		}
		/**
		* 设置： 囚犯介绍
		*/
		public void setQiufanContent(String qiufanContent) {
			this.qiufanContent = qiufanContent;
		}

		/**
		* 获取： 犯罪事由
		*/
		public String getFanzuishiyouContent() {
			return fanzuishiyouContent;
		}
		/**
		* 设置： 犯罪事由
		*/
		public void setFanzuishiyouContent(String fanzuishiyouContent) {
			this.fanzuishiyouContent = fanzuishiyouContent;
		}


	@Override
	public String toString() {
		return "QiufanpingguView{" +
			", taotuoValue=" + taotuoValue +
			", baoliValue=" + baoliValue +
			", weijinValue=" + weijinValue +
			", bianguValue=" + bianguValue +
			", cuozheValue=" + cuozheValue +
			", jieguoValue=" + jieguoValue +
			", qiufanUuidNumber=" + qiufanUuidNumber +
			", qiufanName=" + qiufanName +
			", qiufanIdNumber=" + qiufanIdNumber +
			", qiufanPhoto=" + qiufanPhoto +
			", age=" + age +
			", ruyuTime=" + DateUtil.convertString(ruyuTime,"yyyy-MM-dd") +
			", qiufanNianxian=" + qiufanNianxian +
			", qiufanContent=" + qiufanContent +
			", fanzuishiyouContent=" + fanzuishiyouContent +
			"} " + super.toString();
	}
}
