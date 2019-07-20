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
}

class StockInfo {
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private Data data;
}

public class Solution {
    /*
     * Complete the function below.
     */
    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        final String STOCK_API_BASE_URL = "https://jsonmoc.hackerrank.com/api/stocks";
        URL stockApi;
        HttpURLConnection stockUrlkConnection;

        try {
            stockApi = new URL(STOCK_API_BASE_URL);
            stockUrlkConnection = (HttpURLConnection) stockApi.openConnection();
            stockUrlkConnection.setRequestMethod("GET");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }

        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }

        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }

        openAndClosePrices(_firstDate, _lastDate, _weekDay);

    }
}
