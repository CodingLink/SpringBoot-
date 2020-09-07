package tech.codinglink.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.codinglink.demo.entity.CustomsInfo;
import tech.codinglink.demo.mapper.CustomsMapper;

import java.util.List;

/**
 * 调用CustomersMapper实现服务
 */
@Service
public class CustomsService {
    private CustomsMapper customsMapper;

    @Autowired
    public CustomsService(CustomsMapper customsMapper){
        this.customsMapper=customsMapper;
    }

    /**
     * 显示所有用户的集合
     */
    public List<CustomsInfo> getAllCustoms(){
        List<CustomsInfo> customsInfos=customsMapper.getAllCustoms();
        if(customsInfos!=null){
            System.out.println(customsInfos);
            return customsInfos;
        }
        return null;
    }

    /**
     * 查找某个用户
     */
    public List<CustomsInfo> getCustomsByUid(Integer uid){
        List<CustomsInfo> customsInfos=customsMapper.getCustomsByUid(uid);
        if(customsInfos!=null){
            return customsInfos;
        }
        return null;
    }
}
