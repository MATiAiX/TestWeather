package com.mtxsoftware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtxsoftware.model.forecast.*;
import com.mtxsoftware.model.forecast.parts.Hour;
import com.mtxsoftware.model.forecast.parts.Part;
import com.mtxsoftware.model.forecast.parts.PartShort;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import org.apache.http.util.EntityUtils;
import org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mtxsoftware.model.*;


public class TestWeather {

    private static final String EUROPE_MOSCOW = "Europe/Moscow";
    private static final String MSK = "MSK";
    private static final String UTC = "UTC";
    private static final double LAT_VALUE = 55.75396;
    private static final double LON_VALUE = 37.620393;
    private static final double DELTA_EQUALS = 0.000001;
    private static final String URL_EXTRA_TRUE = "https://api.weather.yandex.ru/v1/forecast?lat=55.75396&lon=37.620393&extra=true";
    private static final String HEADER_NAME_KEY = "x-yandex-api-key";
    private static final String HEADER_KEY_VALUE = "71e5fc77-9252-412f-9b93-e551d4be2592";
    private static final String HEADER_KEY_VALUE_NEGATIVE = "71e5fc77----------------e551d4be2592";
    private static final String YANDEX_FORMAT_DATETIME = "yyyy-MM-dd\'T\'hh:mm:ss.SSS\'Z\'";
    private static final String YANDEX_FORMAT_DATETIME_FORECAST = "yyyy-MM-dd";
    private static final String EQUALS_FORMAT_DATETIME = "yyyy-MM-dd";
    private static final int EQUALS_MIN_TEMP = -50;
    private static final int EQUALS_MAX_TEMP = 50;
    private static final double MAX_WIND_SPEED = 30.0;
    private static final int PREC_TYPE_MIN = 0;
    private static final int PREC_TYPE_MAX = 3;
    private static final int PREC_MM_MAX = 100;
    private static final int PREC_MM_MIN = 0;
    private static final double PREC_STRENGHT_MAX = 1.0;
    private static final double PREC_STRENGHT_MIN = 0.0;


    private static HttpClient client;
    private static HttpGet request;
    private static HttpResponse response;
    private static Weather testWeather;
    private static int responseCode;
    private static String json;


    private SimpleDateFormat SDFWeatherForecast = new SimpleDateFormat(YANDEX_FORMAT_DATETIME_FORECAST);
    private SimpleDateFormat SDFEquals = new SimpleDateFormat(EQUALS_FORMAT_DATETIME);
    private SimpleDateFormat SDFWeather = new SimpleDateFormat(YANDEX_FORMAT_DATETIME);

    {
        SDFWeather.setTimeZone(TimeZone.getTimeZone(UTC));
    }

    //тестирование положительного кода ответа сервера вынес в инициализацию класса,
    // чтобы создать зависимость между тестами
    @BeforeClass
    public static void setup() {
        client = HttpClientBuilder.create().build();
        request = new HttpGet(URL_EXTRA_TRUE);
        request.addHeader(HEADER_NAME_KEY, HEADER_KEY_VALUE);
        try {
            response = client.execute(request);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        responseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, responseCode);
        if (responseCode == 200) {
            try {
                json = EntityUtils.toString(response.getEntity());
                ObjectMapper objectMapper = new ObjectMapper();
                testWeather = objectMapper.readValue(json, Weather.class);
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }

    }

    private HttpResponse prepareNegativeAuth(String key, boolean useHeader) {
        HttpClient clientNegative = HttpClientBuilder.create().build();
        HttpGet requestNegative = new HttpGet(URL_EXTRA_TRUE);
        if (useHeader)
            requestNegative.addHeader(HEADER_NAME_KEY, key);
        HttpResponse httpResponseNegative = null;
        try {
            httpResponseNegative = clientNegative.execute(requestNegative);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        return httpResponseNegative;
    }

    //region SupplyAsserts
    private void assertTemp(String infoObject, Integer temp) {
        Assert.assertNotNull(String.format("Missing %s", infoObject), temp);
        Assert.assertTrue(String.format("Wrong %s", infoObject),
                temp > EQUALS_MIN_TEMP);
        Assert.assertTrue(String.format("Wrong %s", infoObject),
                temp < EQUALS_MAX_TEMP);
    }

    private void assertWind(String infoObject, Double speed) {
        Assert.assertNotNull(String.format("Missing %s", infoObject), speed);
        Assert.assertTrue(String.format("Wrong %s", infoObject),
                (speed < MAX_WIND_SPEED) && (speed >= 0.0));
    }

    private void assertWindDir(String infoObject, String dir) {
        Assert.assertNotNull(String.format("Missing %s", infoObject), dir);
        Assert.assertTrue(String.format("Wrong %s", infoObject),
                WindDir.findValue(dir));
    }
    //endregion SupplyAsserts

    //region AuthHTTP
    @Test
    public void AuthHTTPWithoutHeader() {
        HttpResponse responseNegative = prepareNegativeAuth(null, false);
        Assert.assertEquals(403, responseNegative.getStatusLine().getStatusCode());
    }

    @Test
    public void AuthNullKeyHTTP() {
        HttpResponse responseNegative = prepareNegativeAuth(null, true);
        Assert.assertEquals(403, responseNegative.getStatusLine().getStatusCode());
    }

    @Test
    public void AuthWrongKeyHTTP() {
        HttpResponse responseNegative = prepareNegativeAuth(HEADER_KEY_VALUE_NEGATIVE, true);
        Assert.assertEquals(403, responseNegative.getStatusLine().getStatusCode());
    }

    @Test
    public void AuthEmptyKeyHTTP() {
        HttpResponse responseNegative = prepareNegativeAuth("", true);
        Assert.assertEquals(403, responseNegative.getStatusLine().getStatusCode());
    }
    //endregion AuthHTTP

    //region Location
    @Test
    public void LocationLat() {
        Assert.assertNotNull("Missing Lat", testWeather.getInfo().getLat());
        Assert.assertEquals(LAT_VALUE, testWeather.getInfo().getLat(), DELTA_EQUALS);
    }

    @Test
    public void LocationLon() {
        Assert.assertNotNull("Missing Lon", testWeather.getInfo().getLon());
        Assert.assertEquals(LON_VALUE, testWeather.getInfo().getLon(), DELTA_EQUALS);
    }

    @Test
    public void LocationName() {
        Assert.assertNotNull("Missing name location", testWeather.getInfo().getTzinfo().getName());
        Assert.assertEquals(EUROPE_MOSCOW, testWeather.getInfo().getTzinfo().getName());
    }

    @Test
    public void LocationAbbr() {
        Assert.assertNotNull("Missing abbr location", testWeather.getInfo().getTzinfo().getAbbr());
        Assert.assertEquals(MSK, testWeather.getInfo().getTzinfo().getAbbr());
    }
    //endregion Location

    //region Date
    @Test
    public void DateServer() {
        try {
            Assert.assertNotNull("Missing date server", testWeather.getNowDt());
            Date weatherDate = SDFWeather.parse(testWeather.getNowDt());
            Assert.assertEquals(SDFEquals.format(new Date()), SDFEquals.format(weatherDate));
        } catch (ParseException e) {
            Assert.fail(String.format("getNowDt wrong format date server %s", testWeather.getNowDt()));
        }
    }

    @Test
    public void ForecastsDate() {
        for (int i = 0; i < testWeather.getForecasts().size(); i++) {
            Forecast fc = testWeather.getForecasts().get(i);
            Assert.assertNotNull(String.format("Missing date in forcast #%s", i), fc.getDate());
            try {
                Date date = SDFWeatherForecast.parse(testWeather.getForecasts().get(i).getDate());
                Assert.assertEquals(SDFEquals.format(DateUtils.addDays(new Date(), i)), SDFEquals.format(date));
            } catch (ParseException e) {
                Assert.fail(String.format("Date wrong format forcast #%s %s", i, fc.getDate()));
            }
        }
    }

    @Test
    public void Season() {
        Assert.assertTrue("Wrong season value", Season.findValue(testWeather.getFact().getSeason()));
    }
    //endregion Date

    //region SizeCollections
    @Test
    public void SizeForecastsRecords() {
        Assert.assertEquals("Wrong size forecasts collection", 11, testWeather.getForecasts().size());
    }

    @Test
    public void CountHoursFirstThreeDaysForecasts() {
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(String.format("Wrong size hours collection in forcast #%s", i), 24, testWeather.getForecasts().get(i).getHours().size());
        }
    }
    //endregion SizeCollections

    //region Temperature
    @Test
    public void TempFact() {
        assertTemp(String.format("Temp in Fact: %s", testWeather.getFact().getTemp())
                , testWeather.getFact().getTemp());
        assertTemp(String.format("FeelsLike in Fact: %s", testWeather.getFact().getFeelsLike()),
                testWeather.getFact().getFeelsLike());
    }

    @Test
    public void TempForecastParts6Hours() {
        for (Forecast fc : testWeather.getForecasts()) {
            for (Part part : fc.getParts().getAllParts6Hours()) {
                assertTemp(String.format("TempAvg in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getTempAvg()),
                        part.getTempAvg());
                assertTemp(String.format("TempMax in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getTempMax()),
                        part.getTempMax());
                assertTemp(String.format("TempMin in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getTempMin()),
                        part.getTempMin());
                assertTemp(String.format("FeelsLike in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getFeelsLike()),
                        part.getFeelsLike());
            }
        }
    }

    @Test
    public void TempForecastParts12Hours() {
        for (Forecast fc : testWeather.getForecasts()) {
            for (PartShort part : fc.getParts().getAllParts12Hours()) {
                if (part.getTempMin() != null)
                    assertTemp(String.format("TempMin in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getTempMin()),
                            part.getTempMin());
                assertTemp(String.format("FeelsLike in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getFeelsLike()),
                        part.getFeelsLike());
            }
        }
    }

    @Test
    public void TermForthForcastHours() {
        for (int i = 0; i < 4; i++) {
            for (Hour hour : testWeather.getForecasts().get(i).getHours()) {
                assertTemp(String.format("Term in hour %s forecast#%s", hour.getHour(), i),
                        hour.getTemp());
                assertTemp(String.format("FeelsLike in hour %s forecast#%s", hour.getHour(), i),
                        hour.getFeelsLike());
            }
        }
    }

    //endregion Temperature

    //region Wind
    @Test
    public void WindForecastAllPart() {
        for (Forecast fc : testWeather.getForecasts()) {
            for (PartShort part : fc.getParts().getAllPartsLikeShort()) {
                assertWind(String.format("WindGuest in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getWindGust()),
                        part.getWindGust());
                assertWind(String.format("WindSpeed in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getWindSpeed()),
                        part.getWindSpeed());
                assertWindDir(String.format("WindDir in %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getWindDir().toUpperCase()),
                        part.getWindDir().toUpperCase());
            }
        }
    }

    @Test
    public void WindForthForcastHours() {
        for (int i = 0; i < 4; i++) {
            for (Hour hour : testWeather.getForecasts().get(i).getHours()) {
                assertWind(String.format("WindGuest in hour %s forecast#%s", hour.getHour(), i),
                        hour.getWindGust());
                assertWind(String.format("PrecStrenght in hour %s forecast#%s", hour.getHour(), i),
                        hour.getWindSpeed());
                assertWindDir(String.format("PrecMm in hour %s forecast#%s", hour.getHour(), i),
                        hour.getWindDir().toUpperCase());
            }
        }
    }

    @Test
    public void WindFact() {
        assertWind(String.format("WindGuest in Fact: %s", testWeather.getFact().getWindGust()),
                testWeather.getFact().getWindGust());
        assertWind(String.format("WindGuest in Fact: %s", testWeather.getFact().getWindGust()),
                testWeather.getFact().getWindGust());
        assertWindDir(String.format("WindDir in Fact: %s", testWeather.getFact().getWindDir().toUpperCase()),
                testWeather.getFact().getWindDir().toUpperCase());
    }
    //endregion Wind

    //region Prec - ExtraKey
    @Test
    public void PrecFact() {
        Assert.assertNotNull("Missing PrecType in Fact",
                testWeather.getFact().getPrecType());
        Assert.assertNotNull("Missing PrecType in Fact",
                testWeather.getFact().getPrecStrength());
        Assert.assertTrue(String.format("Wrong PrecType in Fact: %s", testWeather.getFact().getPrecType()),
                (testWeather.getFact().getPrecType() >= PREC_TYPE_MIN) && (testWeather.getFact().getPrecType() <= PREC_TYPE_MAX));
        Assert.assertTrue(String.format("Wrong PrecStrenght in Fact: %s", testWeather.getFact().getPrecStrength()),
                (testWeather.getFact().getPrecStrength() - PREC_STRENGHT_MAX < 0.001) && (testWeather.getFact().getPrecStrength() - PREC_STRENGHT_MIN >= -0.001));
    }

    @Test
    public void PrecForecastsAllParts() {
        for (Forecast fc : testWeather.getForecasts()) {
            for (PartShort part : fc.getParts().getAllPartsLikeShort()) {
                Assert.assertNotNull(String.format("Missing PrecType in %s %s", part.getClass().getSimpleName(), fc.getDate()),
                        part.getPrecType());
                Assert.assertNotNull(String.format("Missing PrecStrenght in %s %s", part.getClass().getSimpleName(), fc.getDate()),
                        part.getPrecStrength());
                Assert.assertNotNull(String.format("Missing PrecMm in %s %s", part.getClass().getSimpleName(), fc.getDate()),
                        part.getPrecMm());

                Assert.assertTrue(String.format("Wrong PrecType %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getPrecType()),
                        (part.getPrecType() >= PREC_TYPE_MIN) && (part.getPrecType() <= PREC_TYPE_MAX));
                Assert.assertTrue(String.format("Wrong PrecStrenght %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getPrecStrength()),
                        (part.getPrecStrength() - PREC_STRENGHT_MAX < 0.001) && (part.getPrecStrength() - PREC_STRENGHT_MIN >= -0.001));
                Assert.assertTrue(String.format("Wrong PrecMm %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getPrecMm()),
                        (part.getPrecMm() <= PREC_MM_MAX) && (part.getPrecMm() >= PREC_MM_MIN));
            }
        }
    }

    @Test
    public void PrecForthForcastHours() {
        for (int i = 0; i < 4; i++) {
            for (Hour hour : testWeather.getForecasts().get(i).getHours()) {
                Assert.assertNotNull(String.format("Missing PrecType in hour %s forecast#%s", hour.getHour(), i),
                        hour.getPrecType());
                Assert.assertNotNull(String.format("Missing PrecStrenght in hour %s forecast#%s", hour.getHour(), i),
                        hour.getPrecStrength());
                Assert.assertNotNull(String.format("Missing PrecMm in hour %s forecast#%s", hour.getHour(), i),
                        hour.getPrecMm());

                Assert.assertTrue(String.format("Missing PrecType in hour %s forecast#%s: %s", hour.getHour(), i, hour.getPrecType()),
                        (hour.getPrecType() >= PREC_TYPE_MIN) && (hour.getPrecType() <= PREC_TYPE_MAX));
                Assert.assertTrue(String.format("Missing PrecStrenght in hour %s forecast#%s: %s", hour.getHour(), i, hour.getPrecStrength()),
                        (hour.getPrecStrength() - PREC_STRENGHT_MAX < 0.0001) && (hour.getPrecStrength() - PREC_STRENGHT_MIN >= -0.001));
                Assert.assertTrue(String.format("Missing PrecMm in hour %s forecast#%s: %s", hour.getHour(), i, hour.getPrecMm()),
                        (hour.getPrecMm() <= PREC_MM_MAX) && (hour.getPrecMm() >= PREC_MM_MIN));
            }
        }
    }
    //endregion Prec - ExtraKey

    //region Condition
    @Test
    public void ConditionFact() {
        Assert.assertNotNull("Missing Condition in Fact",
                testWeather.getFact().getCondition());
        Assert.assertTrue(String.format("Wrong Condition in Fact: %s", testWeather.getFact().getCondition()),
                Condition.findValue(testWeather.getFact().getCondition()));

    }

    @Test
    public void ConditionForcastAllPart() {
        for (Forecast fc : testWeather.getForecasts())
            for (PartShort part : fc.getParts().getAllPartsLikeShort()) {
                Assert.assertNotNull(String.format("Missing Condition %s %s", part.getClass().getSimpleName(), fc.getDate()),
                        part.getCondition());
                Assert.assertTrue(String.format("Wrong Condition %s %s: %s", part.getClass().getSimpleName(), fc.getDate(), part.getCondition()),
                        Condition.findValue(part.getCondition()));
            }
    }

    @Test
    public void ConditionForthForcastHours() {
        for (int i = 0; i < 4; i++) {
            for (Hour hour : testWeather.getForecasts().get(i).getHours()) {
                Assert.assertNotNull(String.format("Missing Condition hour %s in forecast#%s", hour.getHour(), i),
                        hour.getCondition());
                Assert.assertTrue(String.format("Wrong Condition hour %s in forecast#%s: %s", hour.getHour(), i, hour.getCondition()),
                        Condition.findValue(hour.getCondition()));
            }
        }
    }
    //endregion Condition

}
