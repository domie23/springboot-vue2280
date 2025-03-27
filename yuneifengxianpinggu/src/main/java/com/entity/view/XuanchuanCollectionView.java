package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.XuanchuanCollectionEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
* 宣传收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanchuan_collection")
public class XuanchuanCollectionView extends XuanchuanCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String xuanchuanCollectionValue;

	//级联表 宣传
		/**
		* 宣传名称
		*/

		@ColumnInfo(comment="宣传名称",type="varchar(200)")
		private String xuanchuanName;
		/**
		* 宣传编号
		*/

		@ColumnInfo(comment="宣传编号",type="varchar(200)")
		private String xuanchuanUuidNumber;
		/**
		* 宣传照片
		*/

		@ColumnInfo(comment="宣传照片",type="varchar(200)")
		private String xuanchuanPhoto;
		/**
		* 宣传视频
		*/

		@ColumnInfo(comment="宣传视频",type="varchar(200)")
		private String xuanchuanVideo;
		/**
		* 附件
		*/

		@ColumnInfo(comment="附件",type="varchar(200)")
		private String xuanchuanFile;
		/**
		* 宣传类型
		*/
		@ColumnInfo(comment="宣传类型",type="int(11)")
		private Integer xuanchuanTypes;
			/**
			* 宣传类型的值
			*/
			@ColumnInfo(comment="宣传类型的字典表值",type="varchar(200)")
			private String xuanchuanValue;
		/**
		* 宣传热度
		*/

		@ColumnInfo(comment="宣传热度",type="int(11)")
		private Integer xuanchuanClicknum;
		/**
		* 宣传内容
		*/

		@ColumnInfo(comment="宣传内容",type="text")
		private String xuanchuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xuanchuanDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;



	public XuanchuanCollectionView() {

	}

	public XuanchuanCollectionView(XuanchuanCollectionEntity xuanchuanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, xuanchuanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getXuanchuanCollectionValue() {
		return xuanchuanCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setXuanchuanCollectionValue(String xuanchuanCollectionValue) {
		this.xuanchuanCollectionValue = xuanchuanCollectionValue;
	}


	//级联表的get和set 宣传

		/**
		* 获取： 宣传名称
		*/
		public String getXuanchuanName() {
			return xuanchuanName;
		}
		/**
		* 设置： 宣传名称
		*/
		public void setXuanchuanName(String xuanchuanName) {
			this.xuanchuanName = xuanchuanName;
		}

		/**
		* 获取： 宣传编号
		*/
		public String getXuanchuanUuidNumber() {
			return xuanchuanUuidNumber;
		}
		/**
		* 设置： 宣传编号
		*/
		public void setXuanchuanUuidNumber(String xuanchuanUuidNumber) {
			this.xuanchuanUuidNumber = xuanchuanUuidNumber;
		}

		/**
		* 获取： 宣传照片
		*/
		public String getXuanchuanPhoto() {
			return xuanchuanPhoto;
		}
		/**
		* 设置： 宣传照片
		*/
		public void setXuanchuanPhoto(String xuanchuanPhoto) {
			this.xuanchuanPhoto = xuanchuanPhoto;
		}

		/**
		* 获取： 宣传视频
		*/
		public String getXuanchuanVideo() {
			return xuanchuanVideo;
		}
		/**
		* 设置： 宣传视频
		*/
		public void setXuanchuanVideo(String xuanchuanVideo) {
			this.xuanchuanVideo = xuanchuanVideo;
		}

		/**
		* 获取： 附件
		*/
		public String getXuanchuanFile() {
			return xuanchuanFile;
		}
		/**
		* 设置： 附件
		*/
		public void setXuanchuanFile(String xuanchuanFile) {
			this.xuanchuanFile = xuanchuanFile;
		}
		/**
		* 获取： 宣传类型
		*/
		public Integer getXuanchuanTypes() {
			return xuanchuanTypes;
		}
		/**
		* 设置： 宣传类型
		*/
		public void setXuanchuanTypes(Integer xuanchuanTypes) {
			this.xuanchuanTypes = xuanchuanTypes;
		}


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

		/**
		* 获取： 宣传热度
		*/
		public Integer getXuanchuanClicknum() {
			return xuanchuanClicknum;
		}
		/**
		* 设置： 宣传热度
		*/
		public void setXuanchuanClicknum(Integer xuanchuanClicknum) {
			this.xuanchuanClicknum = xuanchuanClicknum;
		}

		/**
		* 获取： 宣传内容
		*/
		public String getXuanchuanContent() {
			return xuanchuanContent;
		}
		/**
		* 设置： 宣传内容
		*/
		public void setXuanchuanContent(String xuanchuanContent) {
			this.xuanchuanContent = xuanchuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXuanchuanDelete() {
			return xuanchuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXuanchuanDelete(Integer xuanchuanDelete) {
			this.xuanchuanDelete = xuanchuanDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "XuanchuanCollectionView{" +
			", xuanchuanCollectionValue=" + xuanchuanCollectionValue +
			", xuanchuanName=" + xuanchuanName +
			", xuanchuanUuidNumber=" + xuanchuanUuidNumber +
			", xuanchuanPhoto=" + xuanchuanPhoto +
			", xuanchuanVideo=" + xuanchuanVideo +
			", xuanchuanFile=" + xuanchuanFile +
			", xuanchuanClicknum=" + xuanchuanClicknum +
			", xuanchuanContent=" + xuanchuanContent +
			", xuanchuanDelete=" + xuanchuanDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
