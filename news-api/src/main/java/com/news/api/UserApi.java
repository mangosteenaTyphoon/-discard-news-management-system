package com.news.api;

import com.common.base.dto.auth.UserIdReqDTO;
import com.common.base.constant.ApplicationConst;
import com.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/15 9:16
 */

@FeignClient(contextId = "userApi", name = ApplicationConst.UAA)
public interface UserApi {
    /**
     * 获取用户对应的角色菜单
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getPerm")
    R<List<String>> getPerm(@RequestBody UserIdReqDTO reqDTO);

    /**
     * 获取用户对应的角色
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getRole")
    R<List<String>> getRole(@RequestBody UserIdReqDTO reqDTO);
}
