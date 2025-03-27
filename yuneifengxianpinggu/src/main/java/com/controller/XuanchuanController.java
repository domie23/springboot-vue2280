
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.XuanchuanEntity;
import com.entity.view.XuanchuanCollectionView;
import com.entity.view.XuanchuanView;
import com.service.*;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 宣传
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanchuan")
public class XuanchuanController {
    private static final Logger logger = LoggerFactory.getLogger(XuanchuanController.class);

    private static final String TABLE_NAME = "xuanchuan";

    @Autowired
    private XuanchuanService xuanchuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private XuanchuanCollectionService xuanchuanCollectionService;
    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
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
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("狱警".equals(role))
            params.put("yujingId",request.getSession().getAttribute("userId"));
        params.put("xuanchuanDeleteStart",1);params.put("xuanchuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xuanchuanService.queryPage(params);

        //字典表数据转换
        List<XuanchuanView> list =(List<XuanchuanView>)page.getList();
        for(XuanchuanView c:list){
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
        XuanchuanEntity xuanchuan = xuanchuanService.selectById(id);
        if(xuanchuan !=null){
            //entity转view
            XuanchuanView view = new XuanchuanView();
            BeanUtils.copyProperties( xuanchuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuanchuanEntity> queryWrapper = new EntityWrapper<XuanchuanEntity>()
            .eq("xuanchuan_name", xuanchuan.getXuanchuanName())
            .eq("xuanchuan_video", xuanchuan.getXuanchuanVideo())
            .eq("xuanchuan_types", xuanchuan.getXuanchuanTypes())
            .eq("xuanchuan_clicknum", xuanchuan.getXuanchuanClicknum())
            .eq("xuanchuan_delete", xuanchuan.getXuanchuanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanchuanEntity xuanchuanEntity = xuanchuanService.selectOne(queryWrapper);
        if(xuanchuanEntity==null){
            xuanchuan.setXuanchuanClicknum(1);
            xuanchuan.setXuanchuanDelete(1);
            xuanchuan.setInsertTime(new Date());
            xuanchuan.setCreateTime(new Date());
            xuanchuanService.insert(xuanchuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());
        XuanchuanEntity oldXuanchuanEntity = xuanchuanService.selectById(xuanchuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XuanchuanEntity> queryWrapper = new EntityWrapper<XuanchuanEntity>()
            .notIn("id",xuanchuan.getId())
            .andNew()
            .eq("xuanchuan_name", xuanchuan.getXuanchuanName())
            .eq("xuanchuan_video", xuanchuan.getXuanchuanVideo())
            .eq("xuanchuan_types", xuanchuan.getXuanchuanTypes())
            .eq("xuanchuan_clicknum", xuanchuan.getXuanchuanClicknum())
            .eq("xuanchuan_delete", xuanchuan.getXuanchuanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanchuanEntity xuanchuanEntity = xuanchuanService.selectOne(queryWrapper);
        if("".equals(xuanchuan.getXuanchuanPhoto()) || "null".equals(xuanchuan.getXuanchuanPhoto())){
                xuanchuan.setXuanchuanPhoto(null);
        }
        if("".equals(xuanchuan.getXuanchuanVideo()) || "null".equals(xuanchuan.getXuanchuanVideo())){
                xuanchuan.setXuanchuanVideo(null);
        }
        if("".equals(xuanchuan.getXuanchuanFile()) || "null".equals(xuanchuan.getXuanchuanFile())){
                xuanchuan.setXuanchuanFile(null);
        }
        if(xuanchuanEntity==null){
            xuanchuanService.updateById(xuanchuan);//根据id更新
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
        List<XuanchuanEntity> oldXuanchuanList =xuanchuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XuanchuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XuanchuanEntity xuanchuanEntity = new XuanchuanEntity();
            xuanchuanEntity.setId(id);
            xuanchuanEntity.setXuanchuanDelete(2);
            list.add(xuanchuanEntity);
        }
        if(list != null && list.size() >0){
            xuanchuanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XuanchuanEntity> xuanchuanList = new ArrayList<>();//上传的东西
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
                            XuanchuanEntity xuanchuanEntity = new XuanchuanEntity();
//                            xuanchuanEntity.setXuanchuanName(data.get(0));                    //宣传名称 要改的
//                            xuanchuanEntity.setXuanchuanUuidNumber(data.get(0));                    //宣传编号 要改的
//                            xuanchuanEntity.setXuanchuanPhoto("");//详情和图片
//                            xuanchuanEntity.setXuanchuanVideo(data.get(0));                    //宣传视频 要改的
//                            xuanchuanEntity.setXuanchuanFile(data.get(0));                    //附件 要改的
//                            xuanchuanEntity.setXuanchuanTypes(Integer.valueOf(data.get(0)));   //宣传类型 要改的
//                            xuanchuanEntity.setXuanchuanClicknum(Integer.valueOf(data.get(0)));   //宣传热度 要改的
//                            xuanchuanEntity.setXuanchuanContent("");//详情和图片
//                            xuanchuanEntity.setXuanchuanDelete(1);//逻辑删除字段
//                            xuanchuanEntity.setInsertTime(date);//时间
//                            xuanchuanEntity.setCreateTime(date);//时间
                            xuanchuanList.add(xuanchuanEntity);


                            //把要查询是否重复的字段放入map中
                                //宣传编号
                                if(seachFields.containsKey("xuanchuanUuidNumber")){
                                    List<String> xuanchuanUuidNumber = seachFields.get("xuanchuanUuidNumber");
                                    xuanchuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuanchuanUuidNumber = new ArrayList<>();
                                    xuanchuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuanchuanUuidNumber",xuanchuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //宣传编号
                        List<XuanchuanEntity> xuanchuanEntities_xuanchuanUuidNumber = xuanchuanService.selectList(new EntityWrapper<XuanchuanEntity>().in("xuanchuan_uuid_number", seachFields.get("xuanchuanUuidNumber")).eq("xuanchuan_delete", 1));
                        if(xuanchuanEntities_xuanchuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuanchuanEntity s:xuanchuanEntities_xuanchuanUuidNumber){
                                repeatFields.add(s.getXuanchuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [宣传编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuanchuanService.insertBatch(xuanchuanList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XuanchuanView> returnXuanchuanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = xuanchuanCollectionService.queryPage(params1);
        List<XuanchuanCollectionView> collectionViewsList =(List<XuanchuanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XuanchuanCollectionView collectionView:collectionViewsList){
            Integer xuanchuanTypes = collectionView.getXuanchuanTypes();
            if(typeMap.containsKey(xuanchuanTypes)){
                typeMap.put(xuanchuanTypes,typeMap.get(xuanchuanTypes)+1);
            }else{
                typeMap.put(xuanchuanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xuanchuanTypes",type);
            PageUtils pageUtils1 = xuanchuanService.queryPage(params2);
            List<XuanchuanView> xuanchuanViewList =(List<XuanchuanView>)pageUtils1.getList();
            returnXuanchuanViewList.addAll(xuanchuanViewList);
            if(returnXuanchuanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xuanchuanService.queryPage(params);
        if(returnXuanchuanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXuanchuanViewList.size();//要添加的数量
            List<XuanchuanView> xuanchuanViewList =(List<XuanchuanView>)page.getList();
            for(XuanchuanView xuanchuanView:xuanchuanViewList){
                Boolean addFlag = true;
                for(XuanchuanView returnXuanchuanView:returnXuanchuanViewList){
                    if(returnXuanchuanView.getId().intValue() ==xuanchuanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXuanchuanViewList.add(xuanchuanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXuanchuanViewList = returnXuanchuanViewList.subList(0, limit);
        }

        for(XuanchuanView c:returnXuanchuanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXuanchuanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuanchuanService.queryPage(params);

        //字典表数据转换
        List<XuanchuanView> list =(List<XuanchuanView>)page.getList();
        for(XuanchuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanchuanEntity xuanchuan = xuanchuanService.selectById(id);
            if(xuanchuan !=null){

                //点击数量加1
                xuanchuan.setXuanchuanClicknum(xuanchuan.getXuanchuanClicknum()+1);
                xuanchuanService.updateById(xuanchuan);

                //entity转view
                XuanchuanView view = new XuanchuanView();
                BeanUtils.copyProperties( xuanchuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());
        Wrapper<XuanchuanEntity> queryWrapper = new EntityWrapper<XuanchuanEntity>()
            .eq("xuanchuan_name", xuanchuan.getXuanchuanName())
            .eq("xuanchuan_uuid_number", xuanchuan.getXuanchuanUuidNumber())
            .eq("xuanchuan_video", xuanchuan.getXuanchuanVideo())
            .eq("xuanchuan_types", xuanchuan.getXuanchuanTypes())
            .eq("xuanchuan_clicknum", xuanchuan.getXuanchuanClicknum())
            .eq("xuanchuan_delete", xuanchuan.getXuanchuanDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanchuanEntity xuanchuanEntity = xuanchuanService.selectOne(queryWrapper);
        if(xuanchuanEntity==null){
            xuanchuan.setXuanchuanDelete(1);
            xuanchuan.setInsertTime(new Date());
            xuanchuan.setCreateTime(new Date());
        xuanchuanService.insert(xuanchuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
