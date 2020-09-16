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

    /**
     * 添加商品
     */
    public boolean addGood(Integer gid,String gname,Double price,String description,Integer num){
        if(goodsMapper.addGood(gid, gname, price, description, num)>0){
            return true;
        }
        return false;
    }

    /**
     * 修改商品
     */
    public boolean updateGood(String gname,Double price,String description,Integer num,Integer gid){
        if(goodsMapper.updateGood(gname, price, description, num, gid)>0){
            return true;
        }
        return false;
    }

    /**
     * 通过gid删除商品
     */
    public boolean deleteGoodByGid(Integer gid){
        if(goodsMapper.deleteGoodByGId(gid)>0){
            return true;
        }
        return false;
    }
}
