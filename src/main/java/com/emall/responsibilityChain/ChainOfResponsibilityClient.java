package com.emall.responsibilityChain;

import java.util.ArrayList;

public class ChainOfResponsibilityClient {
	private ArrayList<RequestHandler> requestHandlers;
	 
    public ChainOfResponsibilityClient() {
         requestHandlers = new ArrayList<RequestHandler>();
    }

    /**
     * 方法描述：为了展示“责任链模式”的真正的迷人之处（可扩展性），在这里构造该方法以便添加自定义的“责任人”
     *
     * @param requestHandler
     */
    public void addRatifys(RequestHandler requestHandler) {
         requestHandlers.add(requestHandler);
    }

    /**
     * 方法描述：执行请求
     *
     * @param request
     * @return
     */
    public Result execute(Request request) {
         ArrayList<RequestHandler> arrayList = new ArrayList<RequestHandler>();
         arrayList.addAll(requestHandlers);
         arrayList.add(new GroupLeader());
         arrayList.add(new Manager());
         arrayList.add(new DepartmentHeader());
         
         Chain chain = new Chain( arrayList, request, 0);
         return chain.proceed(request);
    }

}
