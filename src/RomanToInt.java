public class RomanToInt {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int n = 0;
        char prev = 'A';
        for(char ch: arr){
            switch(ch){
                case 'I':{
                    n+=1;
                    break;
                }
                case 'V': {
                    n+= prev == 'I' ? 3 : 5;
                    break;
                }
                case 'X':{
                    n+= prev == 'I' ? 8 : 10;
                    break;
                }
                case 'L':{
                    n+= prev == 'X' ? 30 : 50;
                    break;
                }
                case 'C':{
                    n+= prev == 'X' ? 80 : 100;
                    break;
                }
                case 'D':{
                    n+= prev == 'C' ? 300 : 500;
                    break;
                }
                
                case 'M':{
                    n+= prev == 'C' ? 800 : 1000;
                    break;
                }
                
            }
            prev = ch;
        }
        return n;
    }
}