package com.news.api;

import com.common.base.constant.ApplicationConst;
import com.common.base.dto.common.OperateLog;
import com.common.base.result.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "operateLogApi", name = ApplicationConst.ADMIN)
public interface OperateLogApi {
    @PostMapping("/operate_log/add")
    R add(@RequestBody OperateLog operateLog);
}
