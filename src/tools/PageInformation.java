package tools;

public class PageInformation {
	private String type;	//操作类型
	private String tableName;	//表名
	private int page;	//页码
	private int pageSize;	//每页最大记录数
	private int totalPageCount;	//总页数
	private int allRecordCount;	//总记录数
	private String order;	//升降序
	private String orderField;	//排序字段
	private String ids;//主键id，用逗号隔开，用户删除操作
	private String searSql;	//查询条件
	private int result;	//更新操作是否成功
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getAllRecordCount() {
		return allRecordCount;
	}
	public void setAllRecordCount(int allRecordCount) {
		this.allRecordCount = allRecordCount;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getSearSql() {
		return searSql;
	}
	public void setSearSql(String searSql) {
		this.searSql = searSql;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
