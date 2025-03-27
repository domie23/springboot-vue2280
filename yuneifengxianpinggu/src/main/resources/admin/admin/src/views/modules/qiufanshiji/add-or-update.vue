<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='qiufan'">
                    <el-form-item class="select" v-if="type!='info'"  label="囚犯" prop="qiufanId">
                        <el-select v-model="ruleForm.qiufanId" :disabled="ro.qiufanId" filterable placeholder="请选择囚犯" @change="qiufanChange">
                            <el-option
                                    v-for="(item,index) in qiufanOptions"
                                    v-bind:key="item.id"
                                    :label="item.qiufanName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="囚犯编号" prop="qiufanUuidNumber">
                        <el-input v-model="qiufanForm.qiufanUuidNumber"
                                  placeholder="囚犯编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="囚犯编号" prop="qiufanUuidNumber">
                            <el-input v-model="ruleForm.qiufanUuidNumber"
                                      placeholder="囚犯编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="囚犯姓名" prop="qiufanName">
                        <el-input v-model="qiufanForm.qiufanName"
                                  placeholder="囚犯姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="囚犯姓名" prop="qiufanName">
                            <el-input v-model="ruleForm.qiufanName"
                                      placeholder="囚犯姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="囚犯身份证号" prop="qiufanIdNumber">
                        <el-input v-model="qiufanForm.qiufanIdNumber"
                                  placeholder="囚犯身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="囚犯身份证号" prop="qiufanIdNumber">
                            <el-input v-model="ruleForm.qiufanIdNumber"
                                      placeholder="囚犯身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='qiufan' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.qiufanPhoto" label="囚犯照片" prop="qiufanPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (qiufanForm.qiufanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.qiufanPhoto" label="囚犯照片" prop="qiufanPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.qiufanPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="囚犯年龄" prop="age">
                        <el-input v-model="qiufanForm.age"
                                  placeholder="囚犯年龄" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="囚犯年龄" prop="age">
                            <el-input v-model="ruleForm.age"
                                      placeholder="囚犯年龄" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="性别" prop="sexValue">
                        <el-input v-model="qiufanForm.sexValue"
                                  placeholder="性别" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="性别" prop="sexValue">
                            <el-input v-model="ruleForm.sexValue"
                                      placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="入狱时间" prop="ruyuTime">
                        <el-input v-model="qiufanForm.ruyuTime"
                                  placeholder="入狱时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="入狱时间" prop="ruyuTime">
                            <el-input v-model="ruleForm.ruyuTime"
                                      placeholder="入狱时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='qiufan' ">
                    <el-form-item class="input" v-if="type!='info'"  label="判刑年限" prop="qiufanNianxian">
                        <el-input v-model="qiufanForm.qiufanNianxian"
                                  placeholder="判刑年限" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="判刑年限" prop="qiufanNianxian">
                            <el-input v-model="ruleForm.qiufanNianxian"
                                      placeholder="判刑年限" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="qiufanId" name="qiufanId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="事迹编号" prop="qiufanshijiUuidNumber">
                       <el-input v-model="ruleForm.qiufanshijiUuidNumber"
                                 placeholder="事迹编号" clearable  :readonly="ro.qiufanshijiUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="事迹编号" prop="qiufanshijiUuidNumber">
                           <el-input v-model="ruleForm.qiufanshijiUuidNumber"
                                     placeholder="事迹编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="事迹标题" prop="qiufanshijiName">
                       <el-input v-model="ruleForm.qiufanshijiName"
                                 placeholder="事迹标题" clearable  :readonly="ro.qiufanshijiName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="事迹标题" prop="qiufanshijiName">
                           <el-input v-model="ruleForm.qiufanshijiName"
                                     placeholder="事迹标题" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="囚犯事迹类型" prop="qiufanshijiTypes">
                        <el-select v-model="ruleForm.qiufanshijiTypes" :disabled="ro.qiufanshijiTypes" placeholder="请选择囚犯事迹类型">
                            <el-option
                                v-for="(item,index) in qiufanshijiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="囚犯事迹类型" prop="qiufanshijiValue">
                        <el-input v-model="ruleForm.qiufanshijiValue"
                            placeholder="囚犯事迹类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="发生时间" prop="fashengTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.fashengTime"
                                type="datetime"
                                placeholder="发生时间"
                                :disabled="ro.fashengTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.fashengTime" label="发生时间" prop="fashengTime">
                            <span v-html="ruleForm.fashengTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="发生地点" prop="qiufanshijiAddress">
                       <el-input v-model="ruleForm.qiufanshijiAddress"
                                 placeholder="发生地点" clearable  :readonly="ro.qiufanshijiAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="发生地点" prop="qiufanshijiAddress">
                           <el-input v-model="ruleForm.qiufanshijiAddress"
                                     placeholder="发生地点" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.qiufanshijiFile" label="附件" prop="qiufanshijiFile">
                        <file-upload
                                tip="点击上传附件"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.qiufanshijiFile?$base.url+ruleForm.qiufanshijiFile:''"
                                @change="qiufanshijiFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.qiufanshijiFile" label="附件" prop="qiufanshijiFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="$base.url+ruleForm.qiufanshijiFile"  >附件下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="事迹描述" prop="qiufanshijiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.qiufanshijiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.qiufanshijiContent" label="事迹描述" prop="qiufanshijiContent">
                            <span v-html="ruleForm.qiufanshijiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                qiufanForm: {},
                ro:{
                    qiufanId: false,
                    qiufanshijiUuidNumber: false,
                    qiufanshijiName: false,
                    qiufanshijiTypes: false,
                    fashengTime: false,
                    qiufanshijiAddress: false,
                    qiufanshijiFile: false,
                    qiufanshijiContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    qiufanId: '',
                    qiufanshijiUuidNumber: new Date().getTime(),
                    qiufanshijiName: '',
                    qiufanshijiTypes: '',
                    fashengTime: '',
                    qiufanshijiAddress: '',
                    qiufanshijiFile: '',
                    qiufanshijiContent: '',
                    insertTime: '',
                },
                qiufanshijiTypesOptions : [],
                qiufanOptions : [],
                rules: {
                   qiufanId: [
                              { required: true, message: '囚犯不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   qiufanshijiUuidNumber: [
                              { required: true, message: '事迹编号不能为空', trigger: 'blur' },
                          ],
                   qiufanshijiName: [
                              { required: true, message: '事迹标题不能为空', trigger: 'blur' },
                          ],
                   qiufanshijiTypes: [
                              { required: true, message: '囚犯事迹类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   fashengTime: [
                              { required: true, message: '发生时间不能为空', trigger: 'blur' },
                          ],
                   qiufanshijiAddress: [
                              { required: true, message: '发生地点不能为空', trigger: 'blur' },
                          ],
                   qiufanshijiFile: [
                              { required: true, message: '附件不能为空', trigger: 'blur' },
                          ],
                   qiufanshijiContent: [
                              { required: true, message: '事迹描述不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '录入时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=qiufanshiji_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.qiufanshijiTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `qiufan/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.qiufanOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            qiufanChange(id){
                this.$http({
                    url: `qiufan/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.qiufanForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `qiufanshiji/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.qiufanChange(data.data.qiufanId)
                        _this.ruleForm.qiufanshijiContent = _this.ruleForm.qiufanshijiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.qiufanshijiContent = this.ruleForm.qiufanshijiContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`qiufanshiji/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.qiufanshijiCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.qiufanshijiCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            qiufanshijiFileUploadChange(fileUrls){
                this.ruleForm.qiufanshijiFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

