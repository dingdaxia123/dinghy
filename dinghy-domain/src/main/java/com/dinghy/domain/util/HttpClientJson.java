package com.dinghy.domain.util;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinghy on 2017/11/8.
 */
public class HttpClientJson {

    private HttpPost httpPost;
    private CloseableHttpClient client= HttpClients.createDefault();
    private String resContent = null;
    private List<BasicNameValuePair> list = new ArrayList<>();

//    public String setList(String add){
//        List<BasicNameValuePair> list = new ArrayList<>();
//        return null;
//    }

    public void setList(String key , String value) {
        this.list.add(new BasicNameValuePair(key, value));
    }

    public String send(String url) throws IOException {
        httpPost = new HttpPost(url);

        httpPost.setEntity(new UrlEncodedFormEntity(this.list, "utf-8"));

        HttpResponse response = client.execute(httpPost);

        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            resContent = EntityUtils.toString(httpEntity, "utf-8");
        }
        return resContent;
    }

    public static void main(String[] args) throws EncoderException, UnsupportedEncodingException {
        HttpClientJson httpClientJson = new HttpClientJson();
        String sign = "merCode=16886&orderNumber=10086123456789&refundNumber=10086123456789d"
                +"&refundAmount=0.01&noticeUrl=http://180.173.165.224:10045/adviceUrl&zhuxiang";
        Md5Utils md5Utils = new Md5Utils();
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<root tx=\"1002\">" +
                "<merCode>16886</merCode>" +
                "<orderNumber>10086123456789</orderNumber>" +
                "<refundNumber>10086123456789d</refundNumber>" +
                "<refundAmount>0.01</refundAmount>" +
                "<noticeUrl>http://180.173.165.224:10045/adviceUrl</noticeUrl>" +
                "<sign>"+md5Utils.getMD5ofStr(sign)+"</sign>" +
                "</root>";
        Base64 base64 = new Base64();
        String type = new String(base64.encode(xml.getBytes("UTF-8")));
//        httpClientJson.setList("requestDomain" , "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHJvb3QgdHg9IjEwMDEiPgogICA8bWVyQ29kZT4xNjg4NjwvbWVyQ29kZT4KICAgPG9yZGVyTnVtYmVyPjEwMDg2MTIzNDU2Nzg5PC9vcmRlck51bWJlcj4KICAgPHNpZ24+ODIzMUJGMjYxNEU4Mzg2RjEwMUMxMkYxMzhERkExQzE8L3NpZ24+Cjwvcm9vdD4=");
//        httpClientJson.setList("password" , "123456");
        httpClientJson.setList("MerNo", "16886");
        httpClientJson.setList("BillNo", "Pay20171128105924");
        httpClientJson.setList("Amount", "0.01");
        httpClientJson.setList("ReturnURL", "http://180.173.165.224:10045/login");
        httpClientJson.setList("AdviceURL", "http://180.173.165.224:10045/adviceUrl");
        httpClientJson.setList("SignInfo", "CBFDD852616915793969671451C32CBC");
        httpClientJson.setList("OrderTime", "20171128105924");
        try {
            System.out.println(httpClientJson.send("http://localhost:8888/pay/sslpayment"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
