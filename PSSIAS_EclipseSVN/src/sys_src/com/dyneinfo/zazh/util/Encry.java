package com.dyneinfo.zazh.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;



public class Encry {
	static Integer ModNumber=255;
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub	
		Encry en=new Encry();
		String input="123";
		int right=0,wrong=0;
		for(int i=0;i<1;i++)
		{
//			for(int j=0;j<50;j++)
//			{
//				int rs =random.nextInt(127);
//				if(rs>=48)
//				sb.append((char)rs);
//			}
//			input=sb.toString();
		//	String input1= en.str2Ascii(input);
			String re=en.crypt_pwd("d", "bslogyes", "3705028001");
			
			System.out.println(re);
		 String re1=en.crypt_pwd("e", "COFILES","ED5CDA57CCB1AD8DF865D0483A2E3229");
			//re1=en.ascii2Str(re1);
			if(input.equals(re1))
			{
				right++;
			}
			else
			{
				wrong++;
			}
			System.out.println(re1);
		}
		System.out.println("right:"+right);
		System.out.println("wrong:"+wrong);

	}
	public String ascii2Str(String astr)
	{
		String[]chars=astr.split(" ");
		StringBuffer sb=new StringBuffer();
		
        for(int i=0;i<chars.length;i++)
        { 
        	sb.append((char)Integer.parseInt(chars[i]));
		} 
    	return sb.toString();
	}
	public String str2Ascii(String str)
	{
		char[]chars=str.toCharArray(); //把字符中转换为字符数�?
		StringBuffer sb=new StringBuffer();
		
		  for(int i=0;i<chars.length;i++)
		  {//输出结果

		        sb.append((int)chars[i]);
		        if(i<chars.length-1)
		        {
		        	sb.append(" ");
		        }
		   
		  }
		return sb.toString();
	}
	public String crypt_pwd(String action,String key,String src)
	{
		String dest="";

		Integer KeyPos =0, KeyLen ,SrcAsc =0, Offset, TmpSrcAsc=0, srcPos, rnd1;
		 
		KeyLen = key.length();
	
		action=action.toUpperCase();	
		//加密
		if("D".equals(action))
		{

			rnd1=(int)(Math.random()*32767);
		
			Offset =rnd1 * 10000%ModNumber + 1;
	
	        dest=Long.toHexString(Offset); 
	        if(dest.length()<2)
	        {
	        	dest="0"+dest;
	        }
	        for(srcPos=0;srcPos<src.length();srcPos++)
	        {
	        	 SrcAsc = ((int)(src.substring(srcPos, srcPos+1)).charAt(0) + Offset)% ModNumber;
	             if( KeyPos < KeyLen)
	             {
	            	 KeyPos = KeyPos + 1;
	             }
	             else
	             {
	            	 KeyPos = 1;
	             }
	         
	 				
	 		SrcAsc = of_bitwisexor(SrcAsc,(int)key.substring( KeyPos-1,  KeyPos).charAt(0));

        	String tmp=Long.toHexString(SrcAsc);
        	if(tmp.length()<2)
        	{
        		tmp=" "+tmp;
        	}
	 		dest = dest + tmp;
	         Offset = SrcAsc;
	        }
		}
		//解密
		if("E".equals(action))
		{
			
			 Long temp=Long.parseLong(src.substring(0, 2),16);
			 Offset =temp.intValue();
			
			 for(srcPos=2;srcPos<src.length();srcPos=srcPos+2)
			 {
			
				
				 temp=Long.parseLong(Mid(src,srcPos,2).trim(),16);
				 SrcAsc = temp.intValue();
				 
				 if( KeyPos < KeyLen)
	             {
	            	 KeyPos = KeyPos + 1;
	             }
	             else
	             {
	            	 KeyPos = 1;
	             }
				 TmpSrcAsc = of_bitwisexor(SrcAsc, (int)key.substring( KeyPos-1,  KeyPos).charAt(0));
		
		
			
		         if(TmpSrcAsc<=Offset)
						
		         {
		                TmpSrcAsc = ModNumber + TmpSrcAsc - Offset;
		         }
		         else
		         {
		                TmpSrcAsc = TmpSrcAsc - Offset;
		         }
					
						
		            dest = dest + (char) Integer.parseInt(TmpSrcAsc.toString());
				
		            Offset = SrcAsc;
	     
			 }
			  
			 
			 
		}
		
		return dest;
	}
	public String Mid(String src,int index,int len)
	{
		if(len>src.length()-index)
		{
			len=src.length()-index;
		}
		return src.substring(index,index+len);
	}
	public  Integer of_bitwisexor(Integer al_value1, Integer al_value2)
	{
		int li_Cnt;
		Integer ll_Result=0; 
		Boolean lb_value1[]=new Boolean[32];
		Boolean lb_value2[]=new Boolean[32];

		if(al_value1 ==null||al_value2==null)
		{
			return ll_Result;
		}
		

		for(li_Cnt=1;li_Cnt<=32;li_Cnt++)
		{
			lb_value1[li_Cnt-1]=of_getbit(al_value1, li_Cnt);
			lb_value2[li_Cnt-1]=of_getbit(al_value2, li_Cnt);
		}
		

		for(li_Cnt=1;li_Cnt<=32;li_Cnt++)
		{
			if((lb_value1[li_Cnt-1]&&!lb_value2[li_Cnt-1])||
				(!lb_value1[li_Cnt-1]&&lb_value2[li_Cnt-1]))
			{
				ll_Result = ll_Result + (int)Math.pow(2,(li_Cnt - 1));
			}
		}

	
		return ll_Result;
	
	}
	
	Boolean of_getbit (Integer al_decimal, Integer ai_bit)
	{
		
		
		Boolean lb_null=null; 
		if(al_decimal==null || ai_bit==null)
		{
			return lb_null;
		}
		
		if((int)(al_decimal/(long)Math.pow(2,ai_bit-1))%2>0)
		{
			return true;
		}
	
		return false;	
	}
}
