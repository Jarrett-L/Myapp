package com.dao;

import java.math.*;

public class Decimal2Fraction {
	public String Repeating2Smallest(String repeating, String separate){
        String separate_l = separate.substring(0,1);//[
        String separate_r = separate.substring(1,2);//]
        String separate_p = ".";
        //��¼�·ָ����ŵ�����λ��
        int index_p = repeating.indexOf(separate_p);//.������λ��
        int index_l = repeating.indexOf(separate_l);//[������λ��
        int index_r = repeating.indexOf(separate_r);//]������λ��
        BigInteger number = new BigInteger(repeating.substring(0,index_p));//��������
        int n = index_l-index_p-1;
        BigInteger a = BigInteger.ZERO;
        if(n>0)a = new BigInteger(repeating.substring(index_p+1,index_l));
        int m = index_r-index_l-1;
        BigInteger b = BigInteger.ZERO;
        if(m<=0) return "��������ȷ��ѭ����";
        if(m>0)b= new BigInteger(repeating.substring(index_l+1,index_r));
        BigInteger numerator = NumeratorFormula(n, m, a, b);//��÷��Ӳ���
        BigInteger denominator = DenominatorFormula(n , m);//��÷�ĸ����
        BigInteger GCD = BigInteger.ZERO;
        while(!GCD.equals(BigInteger.ONE)){
            GCD = numerator.gcd(denominator);
            numerator = numerator.divide(GCD);
            denominator = denominator.divide(GCD);
        }
        return number+"'"+numerator+"/"+denominator;
    }
    public BigInteger NumeratorFormula(int n,int m,BigInteger a,BigInteger b){
        return BigInteger.TEN.pow(m).subtract(BigInteger.ONE).multiply(a).add(b);
    }
    public BigInteger DenominatorFormula(int n,int m){
        return BigInteger.TEN.pow(m).subtract(BigInteger.ONE).multiply(BigInteger.TEN.pow(n));
    }
    public static void  Console(Object o){System.out.println(o.toString());}
}
//Decimal2Fraction d2f = new Decimal2Fraction();
// String s = "0.3[3]";
 //Console(d2f.Repeating2Smallest(s,"[]"));