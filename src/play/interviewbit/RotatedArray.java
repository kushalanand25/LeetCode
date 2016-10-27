package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotatedArray {
	// DO NOT MODIFY THE LIST
		public static int findMin(final List<Integer> a) {
		    int n = a.size();
		    int beg = 0;
		    int end = n-1;
		    int mid;
		    int prev, next;
		    
		    if(n == 1)
		        return a.get(0);
		    
		    while(beg < end){
	    	    if(a.get(beg) < a.get(end)){
//	    	        System.out.println("c1 ");
	    	        return a.get(beg);
	    	    } 
	    	    
	    	    mid = (beg+end)/2;
	    	    prev = (mid+n-1)%n;
	    	    next = (mid+1)%n;
	    	    if(a.get(mid) < a.get(prev) && a.get(mid) < a.get(next)){
//	    	        System.out.println("c2 ");  
	    	        return a.get(mid);
	    	    } else if(a.get(mid) <= a.get(end)) {
	    	        end = mid; 
//	    	        System.out.println("c3 "+mid);
	    	    } else if(a.get(mid) >= a.get(beg)) {
	    	        beg = mid+1; 
//	    	        System.out.println("c4 "+mid);
	    	    }
		    }  

	        return -1;	   
		}
		
		public static void main(String[] args) {
			String data = "78960 79034 79169 79249 79350 79392 79464 79475 79501 79582 79583 79858 80116 80162 80417 80430 80436 80479 80548 80605 80650 80669 80706 80716 80949 81129 81197 81223 81257 81304 81342 81502 81524 81528 81579 81611 81636 81785 81805 81878 82156 82224 82312 82471 82650 82685 82694 83239 83356 83361 83380 83406 83463 83551 83605 83625 83804 83876 83879 84205 84331 84456 84596 84777 84846 84866 85100 85212 85480 85913 86096 86326 86374 86424 86528 86593 86701 86853 87091 87126 87189 87605 87649 87766 87789 88095 88231 88251 88268 88337 88528 88597 88665 88677 88796 88809 88903 89203 89246 89370 89409 89507 89537 89748 89834 89894 90150 90247 90346 90398 90416 91239 91355 91373 91453 91523 91550 91569 91586 91645 91720 91909 91911 91931 92224 92345 92389 92482 92483 92543 92610 92740 92754 92849 92872 92879 92935 93013 93136 93269 93681 93703 93706 93712 93749 93896 94154 94431 94618 94873 94920 95159 95186 95324 95330 95497 95520 95536 95722 95905 95995 96087 96234 96532 96551 96592 96595 96772 96906 97024 97461 97485 97639 97700 97795 97845 97919 98021 98184 98237 98282 98296 98337 98403 98435 98710 98803 98896 98916 99120 99157 99190 99207 99291 99383 99540 99605 99621 99701 99912 23 24 96 200 922 1104 1188 1488 1571 1633 1737 2044 2049 2702 2727 2788 2886 3091 3125 3179 3236 3278 3287 3312 3341 3415 3506 3512 3531 3983 4041 4044 4218 4321 4358 4434 4485 4634 4731 4865 4916 4982 4986 5053 5377 5769 5873 5874 5889 5900 5912 6042 6150 6558 6613 6690 6764 6878 6995 7010 7083 7121 7152 7313 7355 7437 7593 7631 7675 7858 7868 8042 8291 8399 8451 8592 8688 8710 8718 8744 8896 9042 9066 9310 9394 9416 9480 9487 9534 9573 9613 9668 9708 9737 9778 9924 10207 10673 10916 10991 11027 11076 11139 11172 11310 11468 11548 11576 11727 11791 11860 11886 11978 12025 12167 12177 12259 12554 12597 12977 12990 13129 13423 13458 13562 13610 13707 13744 13844 13848 13901 13916 13925 14183 14433 14593 14625 14656 14709 14733 14777 14866 15235 15429 15439 15643 15697 15787 15937 16037 16038 16141 16484 16540 16607 16944 16945 16953 16986 17184 17210 17569 17634 17642 17681 17718 17885 17886 17951 18006 18096 18233 18327 18491 18538 18913 19018 19240 19438 19488 19514 19595 19631 19653 19663 19684 19803 19837 19898 19967 20020 20268 20278 20310 20320 20377 20483 20542 20871 20934 20942 20974 21028 21212 21392 21445 21563 21635 21671 21693 21808 21907 21950 22036 22194 22522 22596 22677 22821 22842 23020 23066 23141 23498 23617 23730 24174 24444 24470 24496 24514 24630 24663 24864 24910 25183 25212 25269 25311 25375 25424 25589 25619 25735 25776 25919 26092 26271 26566 26582 26583 26597 26650 26753 26767 26838 26850 26893 27067 27128 27133 27195 27243 27425 27470 27558 27597 27724 27738 27819 27898 28014 28034 28044 28097 28154 28279 28747 28759 28802 29025 29027 29068 29248 29266 29398 29431 29528 29725 29862 29923 30065 30111 30125 30220 30539 30549 30713 30759 30853 31046 31079 31106 31834 31974 32038 32095 32296 32365 32394 32468 32605 32701 32859 33075 33106 33208 33465 33566 33692 33859 33913 33919 33979 34191 34278 34529 34681 34727 34751 34752 35059 35070 35212 35435 35488 35573 36060 36113 36163 36271 36373 36402 36419 36664 36735 36870 37087 37090 37275 37668 37741 37757 37951 38045 38171 38187 38291 38342 38553 38631 38747 38765 38855 38939 39191 39353 39378 39407 39496 39611 39828 39867 39907 40342 40364 40451 40491 40571 40577 40601 40622 40748 41196 41481 41610 41626 41814 41818 41845 41866 41873 41889 41943 42043 42131 42143 42193 42229 42404 42494 42496 42671 42675 42754 42766 42842 43056 43160 43181 43182 43279 43307 43468 43653 43668 43758 43768 43807 44012 44060 44105 44530 44890 44958 45033 45072 45246 45378 45462 45470 45508 45604 45666 45892 46211 46393 46479 46487 46619 47044 47080 47177 47237 47357 47390 47443 47880 47982 48005 48070 48115 48163 48181 48236 48261 48546 48594 48744 48771 48879 49084 49282 49298 49396 50019 50254 50257 50371 50493 50497 50501 50612 50707 50867 50877 50924 50942 50954 51033 51411 52156 52168 52357 52460 52468 52524 52554 52718 52946 53001 53372 53444 53546 53617 53655 53749 53754 53757 53877 53932 54105 54115 54118 54210 54260 54275 54373 54475 54657 54801 54899 54918 54942 54977 55095 55157 55171 55210 55284 55316 55414 55440 55495 55643 55768 55787 55827 56133 56176 56192 56194 56334 56460 56618 56628 56636 56929 57077 57490 57646 57773 57797 57837 58028 58220 58306 58369 58522 58697 58748 58868 59002 59027 59093 59116 59141 59194 59376 59402 59652 59807 59843 60013 60094 60281 60366 60575 60627 60852 60889 60925 60984 61177 61337 61509 61625 61744 61869 62020 62064 62076 62122 62247 62278 62357 62548 62549 62689 62810 62940 63034 63061 63063 63351 63359 63365 63826 63842 63921 64035 64384 64620 64647 64678 64893 64930 64982 65009 65253 65280 65394 65614 65654 65697 65736 65800 66131 66269 66336 66393 66511 66552 66686 66895 66935 66961 67184 67224 67226 67384 67518 67524 67529 67620 67755 67826 67841 67917 67922 68236 68336 68414 68591 68627 68764 68782 68863 68868 68911 68935 68950 68967 69028 69206 69296 69411 69513 69609 69627 69653 69680 69815 69957 70153 70177 70203 70263 70330 70592 70669 70711 70759 70775 70914 70964 70985 71005 71066 71197 71357 71366 71711 71757 71816 71819 71975 72213 72364 72469 72487 72560 72580 72637 72931 72942 72958 73059 73067 73593 73706 73791 74029 74471 74493 74580 74586 74841 74954 75004 75137 75168 75306 75311 75446 75708 75716 75746 75840 75891 75896 76330 76386 76578 76674 76834 76838 76963 76993 77046 77065 77128 77317 77348 77709 77887 78085 78185 78299 78428 78465 78644 78750 78841 78882";
//			List<Integer> a = 
			
			ArrayList<Integer> al = (ArrayList<Integer>) Arrays.asList(data.split("[\\s]"))
										.stream()
										.map(Integer::parseInt)
										.collect(Collectors.toList());
			System.out.println(findMin(al));
//			System.out.println(al.indexOf(23));
		}
}
