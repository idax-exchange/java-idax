package pro.idax.api.client.util;

import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @program: SignUtils
 * @description: SignUtils
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
@Slf4j
public class SignUtils {

    /**
     * sha256_HMAC
     *
     * @param message
     * @param secret
     * @return String
     */
    public static String hmacSha256(String message, String secret) {

        String hash = "";
        try {
            String data = message;
            Mac sha256Hmac = Mac.getInstance(IdaxApiConstants.HMACSHA256);
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(IdaxApiConstants.UTF_8), IdaxApiConstants.HMACSHA256);

            sha256Hmac.init(secretKey);
            byte[] bytes = sha256Hmac.doFinal(data.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            log.error("hmacSha256 exception:" + e.getMessage());
        }

        return hash;
    }

    /**
     * Converting an encrypted byte array to a string
     *
     * @param b
     * @return String
     */
    private static String byteArrayToHexString(byte[] b) {

        StringBuilder hs = new StringBuilder();
        String stmp = null;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }

        return hs.toString().toLowerCase();
    }

}
