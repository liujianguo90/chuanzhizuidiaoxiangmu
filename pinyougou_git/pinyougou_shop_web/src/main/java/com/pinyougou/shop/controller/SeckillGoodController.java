package com.pinyougou.shop.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeckillGoods;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pinyougou.entity.Result;
import service.SeckillGood;

/**
 * @ClassName SeckillGoodController
 * @Author Lenovo
 * @Description //TODO
 * @Date 2019-06-27 上午 10:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("/seckillGood")
public class SeckillGoodController {
    @Reference
    private SeckillGood seckillGood;
    @RequestMapping("/createSeckillGood")
    public Result createSeckillGood(@RequestBody TbSeckillGoods seckillGoods){
        try {
            seckillGood.createSeckilGood(seckillGoods);
            return  new Result("创建秒杀商品成功",true);
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result("创建秒杀商品失败",false);
        }
    }
}
