package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.QiufanshijiEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.utils.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
* 囚犯事迹
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiufanshiji")
public class QiufanshijiView extends QiufanshijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 囚犯事迹类型的值
	*/
	@ColumnInfo(comment="囚犯事迹类型的字典表值",type="varchar(200)")
	private String qiufanshijiValue;

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



	public QiufanshijiView() {

	}

	public QiufanshijiView(QiufanshijiEntity qiufanshijiEntity) {
		try {
			BeanUtils.copyProperties(this, qiufanshijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 囚犯事迹类型的值
	*/
	public String getQiufanshijiValue() {
		return qiufanshijiValue;
	}
	/**
	* 设置： 囚犯事迹类型的值
	*/
	public void setQiufanshijiValue(String qiufanshijiValue) {
		this.qiufanshijiValue = qiufanshijiValue;
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
		return "QiufanshijiView{" +
			", qiufanshijiValue=" + qiufanshijiValue +
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
