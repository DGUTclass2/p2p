package tools;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Tool {
	//从客户端获取分页、排序、删除等参数
	public static void getPgaeInformation(String tableName,HttpServletRequest request,PageInformation pageInformation){
		pageInformation.setTableName(tableName);
		
		String param=request.getParameter("pageSize");//获取每页显示数目
		if(param==null)
			pageInformation.setPageSize(5);//初始化每页显示数目，每页显示5个
		else
			pageInformation.setPageSize(Integer.parseInt(param));
		
		param=request.getParameter("totalPageCount");//获取最大页数
		if(param==null)
			pageInformation.setTotalPageCount(0);//初始化最大页数
		else
			pageInformation.setTotalPageCount(Integer.parseInt(param));
		
		param=request.getParameter("allRecordCount");//获取所有记录数
		if(param==null)
			pageInformation.setAllRecordCount(0);//初始化所有记录数
		else
			pageInformation.setAllRecordCount(Integer.parseInt(param));
		
		param=request.getParameter("page");//获取当前页数
		if(param==null)
			pageInformation.setPage(0);//初始化当前页数
		else
			pageInformation.setPage(Integer.parseInt(param));
		
		pageInformation.setOrderField(request.getParameter("orderField"));//设置排序字段
		pageInformation.setOrder(request.getParameter("order"));//设置排序方式
		pageInformation.setIds(request.getParameter("ids"));//设置查询或删除的字段
		pageInformation.setSearSql(request.getParameter("searSql"));//设置查询语句
	}
	
	//生成表的查询语句
	public static String getSql(PageInformation pageInformation,String type){
		String sql="";
		String tableName=pageInformation.getTableName().toLowerCase();
		
		//删除
		if("delect".equals(type)){
			if(pageInformation.getIds()!=null && !pageInformation.getIds().isEmpty()){
				sql+="delete * from "+tableName+" where "+tableName+"id in("+
						pageInformation.getIds()+")";
				//sql="delect * from XX where XXid in("ids")"
			}
		}else if("count".equals(type)){//返回符合查询条件的记录数目
			sql+="select count(*) as count1 from "+tableName;
			//查询条件
			if(pageInformation.getSearSql()!=null && !pageInformation.getSearSql().isEmpty())
				sql+=" where "+pageInformation.getSearSql();
		}else if("select".equals(type)){//一般查询
			sql+="select * from "+tableName;
			//查询条件
			if(pageInformation.getSearSql()!=null && !pageInformation.getSearSql().isEmpty())
				sql+=" where "+pageInformation.getSearSql();
			//排序，默认按主键降序顺序排序
			if(pageInformation.getOrderField()==null || pageInformation.getOrderField().isEmpty()){
				sql+=" ORDER BY "+tableName+"Id desc";
			}else{
				sql+=" ORDER BY "+pageInformation.getOrderField()+" "+pageInformation.getOrder();
			}
			//分页
			if(pageInformation.getPage()!=0 && pageInformation.getPage()>-1){
				Integer start=(pageInformation.getPage()-1)*pageInformation.getPageSize();
				sql+=" limit "+start+","+pageInformation.getPageSize();
			}
		}
		return sql;
	}
	
	//更新PageInformation的总页数等
	public static void setPageInformation(Integer allRecordCount,PageInformation pageinformation){
		pageinformation.setAllRecordCount(allRecordCount);
		Integer totalPageCount=(int)Math.ceil(1.0*allRecordCount/pageinformation.getPageSize());//总页数
		pageinformation.setTotalPageCount(totalPageCount);
		
		//防止页码越界，删除时有可能页码越界
		if(pageinformation.getPage()<1)
			pageinformation.setPage(1);
		if(pageinformation.getPage()>totalPageCount)
			pageinformation.setPage(totalPageCount);
	}
	
	//获取length位的随机字符串
	public static String getRandomString(int length) { // length 字符串长度
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}
}
