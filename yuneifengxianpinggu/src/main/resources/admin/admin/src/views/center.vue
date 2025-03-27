<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='yujing'"  label='狱警编号' prop="yujingUuidNumber">
               <el-input v-model="ruleForm.yujingUuidNumber"  placeholder='狱警编号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yujing'"  label='狱警姓名' prop="yujingName">
               <el-input v-model="ruleForm.yujingName"  placeholder='狱警姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yujing'"  label='狱警手机号' prop="yujingPhone">
               <el-input v-model="ruleForm.yujingPhone"  placeholder='狱警手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yujing'"  label='狱警身份证号' prop="yujingIdNumber">
               <el-input v-model="ruleForm.yujingIdNumber"  placeholder='狱警身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yujing'" label='狱警头像' prop="yujingPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yujingPhoto?$base.url+ruleForm.yujingPhoto:''"
                         @change="yujingPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yujing'"  label='电子邮箱' prop="yujingEmail">
               <el-input v-model="ruleForm.yujingEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 狱警
    // 注册的类型字段 狱警
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 狱警
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 狱警 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    yujingPhotoUploadChange(fileUrls) {
        this.ruleForm.yujingPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.yujingUuidNumber)&& 'yujing'==this.flag){
                             this.$message.error('狱警编号不能为空');
                             return
                         }

                         if((!this.ruleForm.yujingName)&& 'yujing'==this.flag){
                             this.$message.error('狱警姓名不能为空');
                             return
                         }

                             if( 'yujing' ==this.flag && this.ruleForm.yujingPhone&&(!isMobile(this.ruleForm.yujingPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yujingIdNumber)&& 'yujing'==this.flag){
                             this.$message.error('狱警身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yujingPhoto)&& 'yujing'==this.flag){
                             this.$message.error('狱警头像不能为空');
                             return
                         }

                             if( 'yujing' ==this.flag && this.ruleForm.yujingEmail&&(!isEmail(this.ruleForm.yujingEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
