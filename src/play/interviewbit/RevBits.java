package play.interviewbit;

public class RevBits {
	public long reverse(long a) {
		long x = 0;
		
		x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
		x = (((x & 0xcccccccc) >> 2) | ((x & 0x33333333) << 2));
		x = (((x & 0xf0f0f0f0) >> 4) | ((x & 0x0f0f0f0f) << 4));
		x = (((x & 0xff00ff00) >> 8) | ((x & 0x00ff00ff) << 8));
		return ((x >> 16) | (x << 16));
	}
	
	public static void main(String[] args) {
		
	}
}
