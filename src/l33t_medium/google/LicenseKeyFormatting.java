package l33t_medium.google;
/**
 * #482
 * 
 * @author qiaozhizhao
 *
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int cnt = 0;
        for(int i = chars.length - 1; i>=0; i--){
        	if(chars[i] == '-') continue;
        	if(chars[i] >= 'a' && chars[i] <= 'z'){
        		sb.append(Character.toUpperCase(chars[i]));
        	}else{
        		sb.append(chars[i]);
        	}
        	cnt++;
        	if(cnt == K) {
        		sb.append('-');
        		cnt = 0;
        	}
        }
        if(sb.length() > 0 && sb.charAt(sb.length()-1 ) == '-') sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }
}
