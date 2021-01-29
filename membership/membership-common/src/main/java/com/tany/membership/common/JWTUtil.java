package com.tany.membership.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JWTUtil {
	// 过期时间1天
    private static final long EXPIRE_TIME = 24*60*60*1000;
    
    private static final String SECRET = "membership-tany";
    /**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    //.withClaim(Constant.USER_ID, userId)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static Map<String, Claim> getClaim(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaims();//getClaim(Constant.USER_ID).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,指定时间后过期,一经生成不可修改，令牌在指定时间内一直有效
     * @param userId 用户ID
     * @param openId 用户的openid
     * @return 加密的token
     */
    public static String sign(String userId,String openId,Set<String> permissionSet) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            
            
            if (permissionSet==null) {
            	permissionSet = new HashSet<String>();
			}
            
            return JWT.create()
                    .withClaim(Constant.USER_ID, userId)
                    .withClaim(Constant.OPEN_ID, openId)
                    .withArrayClaim(Constant.PERMISSION_KEY,permissionSet.toArray(new String[permissionSet.size()]))
                    .withExpiresAt(date).sign(algorithm);
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
}
