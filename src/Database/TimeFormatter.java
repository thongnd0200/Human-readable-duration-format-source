package Database;

public class TimeFormatter {
	 	final static long MtoS = 60;
	    final static long HtoS = MtoS*60;
	    final static long DtoS = HtoS*24;
	    final static long YtoS = DtoS*365;
	    public static String formatDuration(Long seconds) {
	        if (seconds == 0)
	            return "now";
	        long times[]  = new long[5];
	        times[0] = seconds/YtoS;// years
	        seconds %= YtoS;
	        times[1] = seconds/DtoS;// days
	        seconds %= DtoS;
	        times[2] = seconds/HtoS;//hour
	        seconds %= HtoS;
	        times[3] = seconds/MtoS;// minutes
	        seconds %= MtoS; 
	        times[4] = seconds; // sec
	        
	        int count = 0;
	        String result = "";
	        String[] timeFormats = {" year", " day", " hour", " minute", " second"};
	        for (int i = 0; i < times.length; i++){
	            if (times[i] == 0)
	                continue;
	            if (times[i] == 1)
	                result += times[i] + timeFormats[i];
	            else
	                result += times[i] + timeFormats[i] + "s";
	            count++;
	            result += ", ";
	        }
	        result = result.substring(0, result.lastIndexOf(","));
	        if (count == 1)
	            return result; 
	        return result.substring(0, result.lastIndexOf(",")) + " and " 
	        + result.substring(result.lastIndexOf(",")+2,result.length());
	    }
}
