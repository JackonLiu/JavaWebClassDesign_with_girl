package util;

import java.util.List;

public class Page
{
	private int pageSize = 4;//每页显示的记录条数
	private int pageNum;//当前页码
	
	private int totalPageSize;//总页数
	private int startIndex;//每页开始的记录索引
	private int totalRecordsNum;//总记录条数
	
	private int prePageNum;//上一页
	private int nextPageNum;//下一页
	
	private String url;//查询分页的地址
	private List records;
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}
	public void setTotalRecordsNum(int totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	public Page(int pageNum,int totalRecordsNum){
		this.pageNum = pageNum;
		this.totalRecordsNum = totalRecordsNum;
		//计算总页数
		totalPageSize = totalRecordsNum%pageSize==0?totalRecordsNum/pageSize:totalRecordsNum/pageSize+1;
		//开始记录的索引
		startIndex = (pageNum-1)*pageSize;
		prePageNum = pageNum-1<1?1:pageNum-1;
		nextPageNum = pageNum+1>totalPageSize?totalPageSize:pageNum+1;
	}
	

	int start;
	int count=5;
	int total;
	String param;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
/*	public void setCount(int count) {
		this.count = count;
	}*/

	public boolean isHasPreviouse(){
		if(start==0)
			return false;
		return true;
		
	}
	public boolean isHasNext(){
		if(start==getLast())
			return false;
		return true;
	}
	
	public int getTotalPage(){
		int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
        // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;
        
        if(0==totalPage)
        	totalPage = 1;
        return totalPage;
		
	}
	
	public int getLast(){
		int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
        // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;
        
        last = last<0?0:last;
        return last;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}
