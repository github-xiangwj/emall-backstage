package com.emall.responsibilityChain;

public interface RequestHandler {
     // 处理请求
     public Result deal(Chain chain);
 
}
