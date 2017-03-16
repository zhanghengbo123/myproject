package core.admin.util;

import core.admin.common.AdminConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xianglong on 16/3/7.
 */
public  class SearchMapUtils {

    /**
     * 根据城市code 生成不同的查询条件
     * @param code 城市名称
     * @return searchMaps
     */
    public static Map<String, Object> createSearchMap(String code){

        Map<String, Object> searchMap = new HashMap<>();
        //直辖市
        if(AdminConstants.proList.contains(code)){
            searchMap.put("provCode",code.replace("市",""));
        }else  if(code.contains("市")){
            searchMap.put("cityCode",code);
        }else{
            searchMap.put("areaCode",code);
        }
        return searchMap;



        //test
    }
}
