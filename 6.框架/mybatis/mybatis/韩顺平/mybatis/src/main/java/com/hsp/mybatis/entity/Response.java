package com.hsp.mybatis.entity;

public class Response {
  private int code;

  private String msg;

  private Object data;

  public Response() {
    super();
  }

  public Response(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static Response success(Object data) {
    Response item = new Response(200, "success", data);
    return item;
  }

  public static Response failure(int errCode, String errorMessage) {
    Response item = new Response(errCode, errorMessage, null);
    return item;
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

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
