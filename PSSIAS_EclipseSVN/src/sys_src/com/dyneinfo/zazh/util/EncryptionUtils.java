package com.dyneinfo.zazh.util;


import org.apache.commons.codec.digest.DigestUtils;
import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.math.BigInteger;

//import com.ibm.misc.BASE64Decoder; 
//import com.ibm.misc.BASE64Encoder; 


import static org.junit.Assert.*;   
import org.junit.Test;   

/**
 * 基础加密组件
 * 
 * @author lisc
 * @version 1.0
 * @since 1.0
 */
public abstract class EncryptionUtils {
	public static final String KEY_SHA = "SHA";//安全散列算法
	public static final String KEY_MD5 = "MD5";

	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 * HmacMD5 
	 * HmacSHA1 
	 * HmacSHA256 
	 * HmacSHA384 
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";
	
//	HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。使用一个密钥生成一个固定大小的小数据块，即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证等。 


	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);

		return sha.digest();

	}

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}
	//MD5加密
	public static String encodePassword(String password) {
		String result = DigestUtils.md5Hex(password);
		return result;
	}
	
	 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  try {
		   System.out.println(EncryptionUtils.encodePassword("dyne"));
			  
			  String inputStr = "简单加密";
				System.err.println("原文:\n" + inputStr);

				byte[] inputData = inputStr.getBytes();
				String code = EncryptionUtils.encryptBASE64(inputData);

				System.err.println("BASE64加密后:\n" + code);

				byte[] output = EncryptionUtils.decryptBASE64(code);

				String outputStr = new String(output);

				System.err.println("BASE64解密后:\n" + outputStr);

				// 验证BASE64加密解密一致性
				assertEquals(inputStr, outputStr);

				// 验证MD5对于同一内容加密是否一致
				assertArrayEquals(EncryptionUtils.encryptMD5(inputData), EncryptionUtils
						.encryptMD5(inputData));

				// 验证SHA对于同一内容加密是否一致
				assertArrayEquals(EncryptionUtils.encryptSHA(inputData), EncryptionUtils
						.encryptSHA(inputData));

				String key = EncryptionUtils.initMacKey();
				System.err.println("Mac密钥:\n" + key);

				// 验证HMAC对于同一内容，同一密钥加密是否一致
				assertArrayEquals(EncryptionUtils.encryptHMAC(inputData, key), EncryptionUtils.encryptHMAC(
						inputData, key));

				BigInteger md5 = new BigInteger(EncryptionUtils.encryptMD5(inputData));
				System.err.println("MD5:\n" + md5.toString(16));

				BigInteger sha = new BigInteger(EncryptionUtils.encryptSHA(inputData));
				System.err.println("SHA:\n" + sha.toString(32));

				BigInteger mac = new BigInteger(EncryptionUtils.encryptHMAC(inputData, inputStr));
				System.err.println("HMAC:\n" + mac.toString(16));
			  
			  
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		  }
		 }
}


