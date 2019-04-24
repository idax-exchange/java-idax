package pro.idax.api.client.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.enums.IdaxCodeEnum;

/**
 * @program: IdaxApiError
 * @description: Idax API error object.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdaxApiError {

  /**
   * Error code.
   */
  private int code;

  /**
   * Error message.
   */
  private String msg;

  public IdaxApiError() {
  }
  public IdaxApiError(IdaxCodeEnum idaxCodeEnum){
    this.code = idaxCodeEnum.getCode();
    this.msg = idaxCodeEnum.getDesc();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, IdaxApiConstants.TO_STRING_BUILDER_STYLE)
        .append("code", code)
        .append("msg", msg)
        .toString();
  }
}
