package com.zlg.cms.servlet.user;

import com.zlg.cms.utils.JsonForServlet;
import com.zlg.cms.utils.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/user/test.do")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strs [] = {"业务员","管理员"};
        int values [] = {10, 5} ;
//      select type , count(*) from c_user group by type ;   Map<type, count(*)>
//        Map<name , arrayList >  map.getKeys => Set<int>   list<keys>   list<values>   map  key-keys  value-values
        Map<String , List> map = new HashMap();
        List list = Arrays.asList(strs);
        List ints = Arrays.asList(values);
        map.put("keys", list);
        map.put("values",ints);

        JsonForServlet.writeJson(ResultData.successData("",map),response);
//        response.getWriter().println(map) ; // 数据中包含两个数组 [名字],[value]
    }
}
