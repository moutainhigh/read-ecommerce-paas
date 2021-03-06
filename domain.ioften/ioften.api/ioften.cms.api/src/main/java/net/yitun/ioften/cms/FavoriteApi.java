package net.yitun.ioften.cms;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.yitun.basic.model.PageResult;
import net.yitun.basic.model.Result;
import net.yitun.ioften.cms.conf.Conf;
import net.yitun.ioften.cms.model.favorite.FavoriteDetail;
import net.yitun.ioften.cms.model.favorite.FavoriteQuery;

/**
 * <pre>
 * <b>资讯 收藏接口.</b>
 * <b>Description:</b>
 *
 * <b>Author:</b> XJN
 * <b>Date:</b> 2018-11-12 11:17:00.202
 * <b>Copyright:</b> Copyright ©2018 cn.tb. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                    Author                Detail
 *   ----------------------------------------------------------------------
 *   0.1   2018年11月12日 上午11:17:06 XJN
 *         new file.
 * </pre>
 */
public interface FavoriteApi {

    /**
     * 收藏列表
     *
     * @param query 查询参数
     * @return PageResult<FavoriteDetail> 查询结果
     */
    @GetMapping(value = Conf.ROUTE //
            + "/favorites", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PageResult<FavoriteDetail> query(FavoriteQuery query);

    /**
     * 收藏资讯
     *
     * @param aid 资讯ID
     * @return Result<?> 收藏结果, true:已收藏; false:已取消
     */
    @PutMapping(value = Conf.ROUTE //
            + "/favorite/{aid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Boolean> collect(@PathVariable("aid") Long aid);

    /**
     * 取消收藏
     * 
     * @param ids 收藏ID
     * @return Result<?> 取消结果
     */
    @DeleteMapping(value = Conf.ROUTE //
            + "/favorite", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<?> delete(@RequestParam("id") Set<Long> ids);

}
