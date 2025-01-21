package study.cursach;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;

class CursachApplicationTests {

    String url = "http://localhost:8080/";
    Answers answers = new Answers();

    @BeforeAll
    static void init(){
        try {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                    .build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .build();
            Unirest.setHttpClient(httpclient);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testInfo() throws UnirestException {
        var ans = Unirest.get(url + "info")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getInfo().replace(" ", "").replace("\n", ""), ans.getBody());
        var ans2 = Unirest.get(url + "infos")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(404, ans2.getStatus());
        Assertions.assertEquals(("Wrong url"), ans2.getBody());
    }

    @Test
    public void testCountries() throws UnirestException {
        var ans = Unirest.get(url + "countries")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getCountries().replace(" ", "").replace("\n", ""), ans.getBody());
    }

    @Test
    public void testJob() throws UnirestException {
        var ans = Unirest.get(url + "job")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getJob().replace(" ", "").replace("\n", ""), ans.getBody());
    }

    @Test
    public void testCriminal() throws UnirestException {
        var ans = Unirest.get(url + "criminal")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getCriminal().replace(" ", "").replace("\n", ""), ans.getBody());
    }

    @Test
    public void testInstruction() throws UnirestException {
        var ans = Unirest.get(url + "instruction")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getInstruction(), ans.getBody());
    }

    @Test
    public void testCustom() throws UnirestException {
        var ans = Unirest.get(url + "customs_param")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getCustoms_param().replace(" ", "").replace("\n", ""), ans.getBody());
    }

    @Test
    public void testValidate() throws UnirestException {
        var ans = Unirest.get(url + "validate")
                .header("Content-Type","application/json")
                .asString();
        Assertions.assertEquals(200, ans.getStatus());
        Assertions.assertEquals(answers.getValidate(), ans.getBody());
    }

}
