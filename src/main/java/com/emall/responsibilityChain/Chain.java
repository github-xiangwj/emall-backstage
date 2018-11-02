package com.emall.responsibilityChain;

import java.util.List;

public class Chain {
	
    public Request request;
    public List<RequestHandler> ratifyList;
    public int index;

    /**
     * 构造方法
     *
     * @param ratifyList
     *            Ratify接口的实现类集合
     * @param request
     *            具体的请求Request实例
     * @param index
     *            已经处理过该request的责任人数量
     */
    public Chain(List<RequestHandler> ratifyList, Request request, int index) {
         this.ratifyList = ratifyList;
         this.request = request;
         this.index = index;
    }

    /**
     * 方法描述：具体转发功能
     */
    public Result proceed(Request request) {
         Result proceed = null;
         if (ratifyList.size() > index) {
             Chain chain = new Chain(ratifyList, request, index + 1);
             RequestHandler requestHandler = ratifyList.get(index);
             proceed = requestHandler.deal(chain);
         }

         return proceed;
    }

    /**
     * 方法描述：返回当前Request对象或者返回当前进行包装后的Request对象
     */
    public Request request() {
         return request;
    }

}
