package com.dyneinfo.zazh.util;

import java.util.Random;

/** 
* ������漴�ַ��� 
*/ 
public class RandomUtils { 
        public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        public static final String numberChar = "0123456789"; 
        public static final String entryStr = "dyne2009";
        /** 
         * ����һ���������ַ�(ֻ������) 
         * 
         * @param length ����ַ��� 
         * @return ����ַ� 
         */ 
        public static String generateIntString(int length) { 
                StringBuffer sb = new StringBuffer(); 
                Random random = new Random(); 
                for (int i = 0; i < length; i++) { 
                        sb.append(numberChar.charAt(random.nextInt(numberChar.length()))); 
                } 
                return sb.toString(); 
        } 
        /** 
         * ����һ���������ַ�(ֻ���Сд��ĸ������) 
         * 
         * @param length ����ַ��� 
         * @return ����ַ� 
         */ 
        public static String generateString(int length) { 
                StringBuffer sb = new StringBuffer(); 
                Random random = new Random(); 
                for (int i = 0; i < length; i++) { 
                        sb.append(allChar.charAt(random.nextInt(allChar.length()))); 
                } 
                return sb.toString(); 
        } 
        /** 
         * ����һ����������ĸ�ַ�(ֻ���Сд��ĸ) 
         * 
         * @param length ����ַ��� 
         * @return ����ַ� 
         */ 
        public static String generateMixString(int length) { 
                StringBuffer sb = new StringBuffer(); 
                Random random = new Random(); 
                for (int i = 0; i < length; i++) { 
                        sb.append(allChar.charAt(random.nextInt(letterChar.length()))); 
                } 
                return sb.toString(); 
        } 

        /** 
         * ����һ���������д��ĸ�ַ�(ֻ���Сд��ĸ) 
         * 
         * @param length ����ַ��� 
         * @return ����ַ� 
         */ 
        public static String generateLowerString(int length) { 
                return generateMixString(length).toLowerCase(); 
        } 

        /** 
         * ����һ��������Сд��ĸ�ַ�(ֻ���Сд��ĸ) 
         * 
         * @param length ����ַ��� 
         * @return ����ַ� 
         */ 
        public static String generateUpperString(int length) { 
                return generateMixString(length).toUpperCase(); 
        } 

        /** 
         * ���һ����Ĵ�0�ַ� 
         * 
         * @param length �ַ��� 
         * @return ��0�ַ� 
         */ 
        public static String generateZeroString(int length) { 
                StringBuffer sb = new StringBuffer(); 
                for (int i = 0; i < length; i++) { 
                        sb.append('0'); 
                } 
                return sb.toString(); 
        } 

        /** 
         * ����������һ������ַ����Ȳ���ǰ�油0 
         * 
         * @param num             ���� 
         * @param fixdlenth �ַ��� 
         * @return �������ַ� 
         */ 
        public static String toFixdLengthString(long num, int fixdlenth) { 
                StringBuffer sb = new StringBuffer(); 
                String strNum = String.valueOf(num); 
                if (fixdlenth - strNum.length() >= 0) { 
                        sb.append(generateZeroString(fixdlenth - strNum.length())); 
                } else { 
                        throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ" + fixdlenth + "���ַ����쳣��"); 
                } 
                sb.append(strNum); 
                return sb.toString(); 
        } 

        /** 
         * ����������һ������ַ����Ȳ���ǰ�油0 
         * 
         * @param num             ���� 
         * @param fixdlenth �ַ��� 
         * @return �������ַ� 
         */ 
        public static String toFixdLengthString(int num, int fixdlenth) { 
                StringBuffer sb = new StringBuffer(); 
                String strNum = String.valueOf(num); 
                if (fixdlenth - strNum.length() >= 0) { 
                        sb.append(generateZeroString(fixdlenth - strNum.length())); 
                } else { 
                        throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ" + fixdlenth + "���ַ����쳣��"); 
                } 
                sb.append(strNum); 
                return sb.toString(); 
        } 

        public static void main(String[] args) { 
                System.out.println(generateIntString(8));
                
//                System.out.println(generateMixString(15)); 
//                System.out.println(generateLowerString(15)); 
//                System.out.println(generateUpperString(15)); 
//                System.out.println(generateZeroString(15)); 
                System.out.println(toFixdLengthString(123, 15)); 
                System.out.println(toFixdLengthString(123L, 8)); 
        } 
}