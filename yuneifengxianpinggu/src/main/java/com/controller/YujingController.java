
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 狱警
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yujing")
public class YujingController {
    private static final Logger logger = LoggerFactory.getLogger(YujingController.class);

    private static final String TABLE_NAME = "yujing";

    @Autowired
    private YujingService yujingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("狱警".equals(role))
            params.put("yujingId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yujingService.queryPage(params);

        //字典表数据转换
        List<YujingView> list =(List<YujingView>)page.getList();
        for(YujingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YujingEntity yujing = yujingService.selectById(id);
        if(yujing !=null){
            //entity转view
            YujingView view = new YujingView();
            BeanUtils.copyProperties( yujing , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YujingEntity yujing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yujing:{}",this.getClass().getName(),yujing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YujingEntity> queryWrapper = new EntityWrapper<YujingEntity>()
            .eq("username", yujing.getUsername())
            .or()
            .eq("yujing_phone", yujing.getYujingPhone())
            .or()
            .eq("yujing_id_number", yujing.getYujingIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujingEntity yujingEntity = yujingService.selectOne(queryWrapper);
        if(yujingEntity==null){
            yujing.setCreateTime(new Date());
            yujing.setPassword("123456");
            yujingService.insert(yujing);
            return R.ok();
        }else {
            return R.error(511,"账户或者狱警手机号或者狱警身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YujingEntity yujing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yujing:{}",this.getClass().getName(),yujing.toString());
        YujingEntity oldYujingEntity = yujingService.selectById(yujing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YujingEntity> queryWrapper = new EntityWrapper<YujingEntity>()
            .notIn("id",yujing.getId())
            .andNew()
            .eq("username", yujing.getUsername())
            .or()
            .eq("yujing_phone", yujing.getYujingPhone())
            .or()
            .eq("yujing_id_number", yujing.getYujingIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujingEntity yujingEntity = yujingService.selectOne(queryWrapper);
        if("".equals(yujing.getYujingPhoto()) || "null".equals(yujing.getYujingPhoto())){
                yujing.setYujingPhoto(null);
        }
        if(yujingEntity==null){
            yujingService.updateById(yujing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者狱警手机号或者狱警身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YujingEntity> oldYujingList =yujingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yujingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yujingId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YujingEntity> yujingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YujingEntity yujingEntity = new YujingEntity();
//                            yujingEntity.setUsername(data.get(0));                    //账户 要改的
//                            //yujingEntity.setPassword("123456");//密码
//                            yujingEntity.setYujingUuidNumber(data.get(0));                    //狱警编号 要改的
//                            yujingEntity.setYujingName(data.get(0));                    //狱警姓名 要改的
//                            yujingEntity.setYujingPhone(data.get(0));                    //狱警手机号 要改的
//                            yujingEntity.setYujingIdNumber(data.get(0));                    //狱警身份证号 要改的
//                            yujingEntity.setYujingPhoto("");//详情和图片
//                            yujingEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            yujingEntity.setYujingEmail(data.get(0));                    //电子邮箱 要改的
//                            yujingEntity.setCreateTime(date);//时间
                            yujingList.add(yujingEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //狱警编号
                                if(seachFields.containsKey("yujingUuidNumber")){
                                    List<String> yujingUuidNumber = seachFields.get("yujingUuidNumber");
                                    yujingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yujingUuidNumber = new ArrayList<>();
                                    yujingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yujingUuidNumber",yujingUuidNumber);
                                }
                                //狱警手机号
                                if(seachFields.containsKey("yujingPhone")){
                                    List<String> yujingPhone = seachFields.get("yujingPhone");
                                    yujingPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yujingPhone = new ArrayList<>();
                                    yujingPhone.add(data.get(0));//要改的
                                    seachFields.put("yujingPhone",yujingPhone);
                                }
                                //狱警身份证号
                                if(seachFields.containsKey("yujingIdNumber")){
                                    List<String> yujingIdNumber = seachFields.get("yujingIdNumber");
                                    yujingIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yujingIdNumber = new ArrayList<>();
                                    yujingIdNumber.add(data.get(0));//要改的
                                    seachFields.put("yujingIdNumber",yujingIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<YujingEntity> yujingEntities_username = yujingService.selectList(new EntityWrapper<YujingEntity>().in("username", seachFields.get("username")));
                        if(yujingEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YujingEntity s:yujingEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //狱警编号
                        List<YujingEntity> yujingEntities_yujingUuidNumber = yujingService.selectList(new EntityWrapper<YujingEntity>().in("yujing_uuid_number", seachFields.get("yujingUuidNumber")));
                        if(yujingEntities_yujingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YujingEntity s:yujingEntities_yujingUuidNumber){
                                repeatFields.add(s.getYujingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [狱警编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //狱警手机号
                        List<YujingEntity> yujingEntities_yujingPhone = yujingService.selectList(new EntityWrapper<YujingEntity>().in("yujing_phone", seachFields.get("yujingPhone")));
                        if(yujingEntities_yujingPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YujingEntity s:yujingEntities_yujingPhone){
                                repeatFields.add(s.getYujingPhone());
                            }
                            return R.error(511,"数据库的该表中的 [狱警手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //狱警身份证号
                        List<YujingEntity> yujingEntities_yujingIdNumber = yujingService.selectList(new EntityWrapper<YujingEntity>().in("yujing_id_number", seachFields.get("yujingIdNumber")));
                        if(yujingEntities_yujingIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YujingEntity s:yujingEntities_yujingIdNumber){
                                repeatFields.add(s.getYujingIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [狱警身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yujingService.insertBatch(yujingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YujingEntity yujing = yujingService.selectOne(new EntityWrapper<YujingEntity>().eq("username", username));
        if(yujing==null || !yujing.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(yujing.getId(),username, "yujing", "狱警");
        R r = R.ok();
        r.put("token", token);
        r.put("role","狱警");
        r.put("username",yujing.getYujingName());
        r.put("tableName","yujing");
        r.put("userId",yujing.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YujingEntity yujing, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YujingEntity> queryWrapper = new EntityWrapper<YujingEntity>()
            .eq("username", yujing.getUsername())
            .or()
            .eq("yujing_phone", yujing.getYujingPhone())
            .or()
            .eq("yujing_id_number", yujing.getYujingIdNumber())
            ;
        YujingEntity yujingEntity = yujingService.selectOne(queryWrapper);
        if(yujingEntity != null)
            return R.error("账户或者狱警手机号或者狱警身份证号已经被使用");
        yujing.setYujingUuidNumber(String.valueOf(new Date().getTime()));
        yujing.setCreateTime(new Date());
        yujingService.insert(yujing);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        YujingEntity yujing = yujingService.selectById(id);
        yujing.setPassword("123456");
        yujingService.updateById(yujing);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YujingEntity yujing = yujingService.selectOne(new EntityWrapper<YujingEntity>().eq("username", username));
        if(yujing!=null){
            yujing.setPassword("123456");
            boolean b = yujingService.updateById(yujing);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYujing(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YujingEntity yujing = yujingService.selectById(id);
        if(yujing !=null){
            //entity转view
            YujingView view = new YujingView();
            BeanUtils.copyProperties( yujing , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}
