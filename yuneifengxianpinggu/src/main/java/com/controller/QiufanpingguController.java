
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
 * 囚犯评估
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiufanpinggu")
public class QiufanpingguController {
    private static final Logger logger = LoggerFactory.getLogger(QiufanpingguController.class);

    private static final String TABLE_NAME = "qiufanpinggu";

    @Autowired
    private QiufanpingguService qiufanpingguService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private QiufanService qiufanService;
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
        PageUtils page = qiufanpingguService.queryPage(params);

        //字典表数据转换
        List<QiufanpingguView> list =(List<QiufanpingguView>)page.getList();
        for(QiufanpingguView c:list){
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
        QiufanpingguEntity qiufanpinggu = qiufanpingguService.selectById(id);
        if(qiufanpinggu !=null){
            //entity转view
            QiufanpingguView view = new QiufanpingguView();
            BeanUtils.copyProperties( qiufanpinggu , view );//把实体数据重构到view中
            //级联表 囚犯
            //级联表
            QiufanEntity qiufan = qiufanService.selectById(qiufanpinggu.getQiufanId());
            if(qiufan != null){
            BeanUtils.copyProperties( qiufan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiufanId(qiufan.getId());
            }
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
    public R save(@RequestBody QiufanpingguEntity qiufanpinggu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiufanpinggu:{}",this.getClass().getName(),qiufanpinggu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

            Integer defen=0;
            if (qiufanpinggu.getTaotuoTypes()==2){
                defen=defen+30;
            }
            if (qiufanpinggu.getBaoliTypes()==2){
                defen=defen+30;
            }
            if (qiufanpinggu.getWeijinTypes()==2){
                defen=defen+20;
            }
            if (qiufanpinggu.getBianguTypes()==2){
                defen=defen+15;
            }
            if (qiufanpinggu.getCuozheTypes()==2){
                defen=defen+15;
            }

            if(defen<=30){
                qiufanpinggu.setJieguoTypes(1);//正常
            }else if(defen<=60){
                qiufanpinggu.setJieguoTypes(2);//危险
            }else if(defen<=80){
                qiufanpinggu.setJieguoTypes(3);//高度危险
            }else{
                qiufanpinggu.setJieguoTypes(4);//80以上  极度危险
            }

            qiufanpinggu.setDefen(defen);
            qiufanpinggu.setInsertTime(new Date());
            qiufanpinggu.setCreateTime(new Date());
            qiufanpingguService.insert(qiufanpinggu);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiufanpingguEntity qiufanpinggu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiufanpinggu:{}",this.getClass().getName(),qiufanpinggu.toString());
        QiufanpingguEntity oldQiufanpingguEntity = qiufanpingguService.selectById(qiufanpinggu.getId());//查询原先数据

            qiufanpingguService.updateById(qiufanpinggu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QiufanpingguEntity> oldQiufanpingguList =qiufanpingguService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qiufanpingguService.deleteBatchIds(Arrays.asList(ids));

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
            List<QiufanpingguEntity> qiufanpingguList = new ArrayList<>();//上传的东西
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
                            QiufanpingguEntity qiufanpingguEntity = new QiufanpingguEntity();
//                            qiufanpingguEntity.setQiufanId(Integer.valueOf(data.get(0)));   //囚犯 要改的
//                            qiufanpingguEntity.setQiufanpingguUuidNumber(data.get(0));                    //囚犯评估编号 要改的
//                            qiufanpingguEntity.setQiufanpingguName(data.get(0));                    //评估标题 要改的
//                            qiufanpingguEntity.setTaotuoTypes(Integer.valueOf(data.get(0)));   //存在逃脱 要改的
//                            qiufanpingguEntity.setBaoliTypes(Integer.valueOf(data.get(0)));   //暴力倾向 要改的
//                            qiufanpingguEntity.setWeijinTypes(Integer.valueOf(data.get(0)));   //违禁物品 要改的
//                            qiufanpingguEntity.setBianguTypes(Integer.valueOf(data.get(0)));   //重大变故 要改的
//                            qiufanpingguEntity.setCuozheTypes(Integer.valueOf(data.get(0)));   //改造中的重大挫折 要改的
//                            qiufanpingguEntity.setDefen(Integer.valueOf(data.get(0)));   //得分 要改的
//                            qiufanpingguEntity.setJieguoTypes(Integer.valueOf(data.get(0)));   //评价结果 要改的
//                            qiufanpingguEntity.setQiufanpingguContent("");//详情和图片
//                            qiufanpingguEntity.setInsertTime(date);//时间
//                            qiufanpingguEntity.setCreateTime(date);//时间
                            qiufanpingguList.add(qiufanpingguEntity);


                            //把要查询是否重复的字段放入map中
                                //囚犯评估编号
                                if(seachFields.containsKey("qiufanpingguUuidNumber")){
                                    List<String> qiufanpingguUuidNumber = seachFields.get("qiufanpingguUuidNumber");
                                    qiufanpingguUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qiufanpingguUuidNumber = new ArrayList<>();
                                    qiufanpingguUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qiufanpingguUuidNumber",qiufanpingguUuidNumber);
                                }
                        }

                        //查询是否重复
                         //囚犯评估编号
                        List<QiufanpingguEntity> qiufanpingguEntities_qiufanpingguUuidNumber = qiufanpingguService.selectList(new EntityWrapper<QiufanpingguEntity>().in("qiufanpinggu_uuid_number", seachFields.get("qiufanpingguUuidNumber")));
                        if(qiufanpingguEntities_qiufanpingguUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QiufanpingguEntity s:qiufanpingguEntities_qiufanpingguUuidNumber){
                                repeatFields.add(s.getQiufanpingguUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [囚犯评估编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qiufanpingguService.insertBatch(qiufanpingguList);
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
