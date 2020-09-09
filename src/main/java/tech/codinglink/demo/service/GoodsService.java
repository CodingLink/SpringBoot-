package tech.codinglink.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.codinglink.demo.entity.GoodsInfo;
import tech.codinglink.demo.mapper.GoodsMapper;

import java.util.List;

/**
 * 调用GoodsMapper实现服务
 */
@Service
public class GoodsService {
    private GoodsMapper goodsMapper;

    @Autowired
    public GoodsService(GoodsMapper goodsMapper){
        this.goodsMapper=goodsMapper;
    }


    /**
     * 显示所有商品的集合
     */
    public List<GoodsInfo> getAllGoods(){
        List<GoodsInfo> goodsInfos=goodsMapper.getAllGoods();
        if(goodsInfos!=null){
            System.out.println(goodsInfos);
            return goodsInfos;
        }
        return null;
    }
}
