package core.admin.service;

import core.admin.domain.GoodsPic;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/21.
 */
public interface GoodsPicService {
    public long savePic(GoodsPic goodsPic);

    public List<GoodsPic> queryPicList(Map<String,Object> search);

    public long deletePic(Long id);
}
