package util;

/**
 *
 * @since 2013-10-3
 * @author lwh
 */

public class StringUtil {
	
	public static final String comma = ",";
	
	public static boolean isBlank(String str){
		return str == null || str.equals("");
	}

	
	public static String orderBy(String sort, String order){
		if(!isBlank(order) && !isBlank(sort)){
			String[] sorts = sort.split(comma);
			String[] orders = order.split(comma);
			if(sorts.length > 0 && (sorts.length == orders.length)){
				StringBuilder sb = new StringBuilder("order by");
				for (int i = 0; i < sorts.length; i++) {
					sb.append(" ");
					sb.append(sorts[i]);
					sb.append(" ");
					sb.append(orders[i]);
					sb.append(",");
				}
				return sb.substring(0, sb.length() - 1);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		String sort = "code name";
		String order = "asc desc";
		
		System.out.println(StringUtil.orderBy(sort, order));
	}
}
