
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
 * 囚犯
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiufan")
public class QiufanController {
    private static final Logger logger = LoggerFactory.getLogger(QiufanController.class);

    private static final String TABLE_NAME = "qiufan";

    @Autowired
    private QiufanService qiufanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YujingService yujingService;


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
        PageUtils page = qiufanService.queryPage(params);

        //字典表数据转换
        List<QiufanView> list =(List<QiufanView>)page.getList();
        for(QiufanView c:list){
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
        QiufanEntity qiufan = qiufanService.selectById(id);
        if(qiufan !=null){
            //entity转view
            QiufanView view = new QiufanView();
            BeanUtils.copyProperties( qiufan , view );//把实体数据重构到view中
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
    public R save(@RequestBody QiufanEntity qiufan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiufan:{}",this.getClass().getName(),qiufan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QiufanEntity> queryWrapper = new EntityWrapper<QiufanEntity>()
            .eq("qiufan_name", qiufan.getQiufanName())
            .eq("qiufan_id_number", qiufan.getQiufanIdNumber())
            .eq("age", qiufan.getAge())
            .eq("sex_types", qiufan.getSexTypes())
            .eq("qiufan_nianxian", qiufan.getQiufanNianxian())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiufanEntity qiufanEntity = qiufanService.selectOne(queryWrapper);
        if(qiufanEntity==null){
            qiufan.setInsertTime(new Date());
            qiufan.setCreateTime(new Date());
            qiufanService.insert(qiufan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiufanEntity qiufan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiufan:{}",this.getClass().getName(),qiufan.toString());
        QiufanEntity oldQiufanEntity = qiufanService.selectById(qiufan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<QiufanEntity> queryWrapper = new EntityWrapper<QiufanEntity>()
            .notIn("id",qiufan.getId())
            .andNew()
            .eq("qiufan_name", qiufan.getQiufanName())
            .eq("qiufan_id_number", qiufan.getQiufanIdNumber())
            .eq("age", qiufan.getAge())
            .eq("sex_types", qiufan.getSexTypes())
            .eq("qiufan_nianxian", qiufan.getQiufanNianxian())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiufanEntity qiufanEntity = qiufanService.selectOne(queryWrapper);
        if("".equals(qiufan.getQiufanPhoto()) || "null".equals(qiufan.getQiufanPhoto())){
                qiufan.setQiufanPhoto(null);
        }
        if(qiufanEntity==null){
            qiufanService.updateById(qiufan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QiufanEntity> oldQiufanList =qiufanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qiufanService.deleteBatchIds(Arrays.asList(ids));

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
            List<QiufanEntity> qiufanList = new ArrayList<>();//上传的东西
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
                            QiufanEntity qiufanEntity = new QiufanEntity();
//                            qiufanEntity.setQiufanUuidNumber(data.get(0));                    //囚犯编号 要改的
//                            qiufanEntity.setQiufanName(data.get(0));                    //囚犯姓名 要改的
//                            qiufanEntity.setQiufanIdNumber(data.get(0));                    //囚犯身份证号 要改的
//                            qiufanEntity.setQiufanPhoto("");//详情和图片
//                            qiufanEntity.setAge(Integer.valueOf(data.get(0)));   //囚犯年龄 要改的
//                            qiufanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            qiufanEntity.setRuyuTime(sdf.parse(data.get(0)));          //入狱时间 要改的
//                            qiufanEntity.setQiufanNianxian(data.get(0));                    //判刑年限 要改的
//                            qiufanEntity.setQiufanContent("");//详情和图片
//                            qiufanEntity.setFanzuishiyouContent("");//详情和图片
//                            qiufanEntity.setInsertTime(date);//时间
//                            qiufanEntity.setCreateTime(date);//时间
                            qiufanList.add(qiufanEntity);


                            //把要查询是否重复的字段放入map中
                                //囚犯编号
                                if(seachFields.containsKey("qiufanUuidNumber")){
                                    List<String> qiufanUuidNumber = seachFields.get("qiufanUuidNumber");
                                    qiufanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qiufanUuidNumber = new ArrayList<>();
                                    qiufanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qiufanUuidNumber",qiufanUuidNumber);
                                }
                                //囚犯身份证号
                                if(seachFields.containsKey("qiufanIdNumber")){
                                    List<String> qiufanIdNumber = seachFields.get("qiufanIdNumber");
                                    qiufanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qiufanIdNumber = new ArrayList<>();
                                    qiufanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("qiufanIdNumber",qiufanIdNumber);
                                }
                        }

                        //查询是否重复
                         //囚犯编号
                        List<QiufanEntity> qiufanEntities_qiufanUuidNumber = qiufanService.selectList(new EntityWrapper<QiufanEntity>().in("qiufan_uuid_number", seachFields.get("qiufanUuidNumber")));
                        if(qiufanEntities_qiufanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QiufanEntity s:qiufanEntities_qiufanUuidNumber){
                                repeatFields.add(s.getQiufanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [囚犯编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //囚犯身份证号
                        List<QiufanEntity> qiufanEntities_qiufanIdNumber = qiufanService.selectList(new EntityWrapper<QiufanEntity>().in("qiufan_id_number", seachFields.get("qiufanIdNumber")));
                        if(qiufanEntities_qiufanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QiufanEntity s:qiufanEntities_qiufanIdNumber){
                                repeatFields.add(s.getQiufanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [囚犯身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qiufanService.insertBatch(qiufanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
