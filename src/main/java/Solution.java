import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;

import com.google.gson.*;

class Data {
    private String date;
    private double open;
    private double close;
    private double high;
    private double low;

    public String stockInfo() {
        return date + " " + open + " " + close;
    }
}

class StockInfo {
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private Data[] data;

    public void setData(Data data[]) {
        this.data = data;
    }

    public Data[] getData() {
        return this.data;
    }
}

public class Solution {
    /*
     * Complete the function below.
     */
    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        // https://jsonmock.hackerrank.com/api/stocks/search?key=value
        String key, value;
        key = "date";
        value = "5-January-2000";
        String url = "https://jsonmock.hackerrank.com/api/stocks/search?"+key+"="+value+"&"+"page=1";

        System.out.println(url);

        URL stockInfoUrl;
        HttpURLConnection stockUrlConnection;
        BufferedReader bufferedReader;
        StringBuffer stockResponse;

        try {
            stockInfoUrl = new URL(url);
            stockUrlConnection = (HttpURLConnection) stockInfoUrl.openConnection();
            stockUrlConnection.setRequestMethod("GET");

            bufferedReader = new BufferedReader(new InputStreamReader(stockUrlConnection.getInputStream()));
            stockResponse = new StringBuffer();

            bufferedReader.lines().forEach(stockResponse::append);
            bufferedReader.close();

            StockInfo stockInfo = new Gson().fromJson(stockResponse.toString(), StockInfo.class);

            Arrays.stream(stockInfo.getData())
                    .map(Data::stockInfo)
                    .forEach(System.out::println);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner bufferedReader = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = bufferedReader.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }

        String _lastDate;
        try {
            _lastDate = bufferedReader.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }

        String _weekDay;
        try {
            _weekDay = bufferedReader.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }

        openAndClosePrices(_firstDate, _lastDate, _weekDay);

    }
}
