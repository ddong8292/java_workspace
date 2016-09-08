package com.sds.client.game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
	import java.util.TimeZone;

public class DataTest {

	public static void main(String[] args) {
		   String tzid = "UTC";
		    TimeZone tz = TimeZone.getTimeZone(tzid);

		    long utc = System.currentTimeMillis();  // supply your timestamp here
		    Date d = new Date(utc);

		    // timezone symbol (z) included in the format pattern for debug
		    DateFormat format = new SimpleDateFormat("yy/M/dd hh:mm a z");

		    // format date in default timezone
		    System.err.println(format.format(d)); //한국시간

		    // format date in target timezone
		    format.setTimeZone(tz);
		    System.err.println(format.format(d)); //유럽시간

	}

}
