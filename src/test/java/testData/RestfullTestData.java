package testData;

import java.util.*;

public class DummyTestData {

    public HashMap<String, Object> booking1ExpDataSetUp () {
        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2017-08-15");
        bookingDates.put("checkout", "2018-12-01");
        HashMap<String, Object> booking1ExpData = new HashMap<>();
        booking1ExpData.put("statusCode", 200);
        booking1ExpData.put("Content-Type", "application/json");
        booking1ExpData.put("Via", "1.1 vegur");
        booking1ExpData.put("firstname", "Mary");
        booking1ExpData.put("lastname", "Ericsson");
        booking1ExpData.put("totalprice", 672);
        booking1ExpData.put("depositpaid", true);
        booking1ExpData.put("bookingDates", bookingDates);
        return booking1ExpData;
    }

    public HashMap<String, Object> expectedEmployeeData() {

        HashMap<String, Object> expEmpData = new HashMap<>();
        expEmpData.put("employee_name", "Ashton Cox");
        expEmpData.put("employee size", 24);
        return expEmpData;
    }
}
