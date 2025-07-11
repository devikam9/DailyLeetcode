class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0){
            sb.append("-");
        }
        
        long divisor = (Math.abs((long)denominator));
        long dividend = (Math.abs((long)numerator));
        sb.append(dividend / divisor);
        long remainder = (dividend % divisor);
        if(remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
               int index = map.get(remainder);
               sb.insert(index,"(");
               sb.append(")");
               break;
            }
                map.put(remainder,sb.length());
                remainder *= 10;
                sb.append(remainder / divisor);
                remainder = remainder % divisor;
            
        }
        return sb.toString();
    }
}