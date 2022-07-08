package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateHelper {
	static final SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
	 public static String toString (Date date,String... pa) {
		 if(pa.length >0) {
			 date_format.applyPattern(pa[0]);
		 }
		 if(date == null) date = DateHelper.now() ;
		return date_format.format(date);
		 
	 }
	 public static Date toDate(String date,String...pa) {
		 try {
			 if(pa.length >0) {
				 date_format.applyPattern(pa[0]);
			 }
			 if(date == null) return DateHelper.now();
			 return (Date) date_format.parse(date) ;
		 }catch (Exception e) {
			 throw new RuntimeException(e) ;
		}
	 }
	public static Date now() {
		
		return new Date();
	}

}
